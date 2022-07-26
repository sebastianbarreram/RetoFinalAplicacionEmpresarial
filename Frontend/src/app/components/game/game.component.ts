import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Board } from 'src/app/interfaces/board';
import { Card } from 'src/app/interfaces/card';
import { Game } from 'src/app/interfaces/game';
import { Player } from 'src/app/interfaces/player';
import { BoardAPIService } from 'src/app/services/board-api.service';
import { GameService } from 'src/app/services/game.service';
import { CardGameAPIService } from '../../services/card-api.service';
import { PlayerAPIService } from '../../services/player-api.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';


@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']

})

export class GameComponent implements OnInit {
  display: any;
  imagenPrueba:string="../../assets/Pack 108 Pepsicards marvel/807.jpg"

  board: Board = {
    id: "62de01f1ee60c664c3d720fb",
    time: 10000,
    listWinRound: [],
    listCard: [],
    listplayer: [],
    idPlayers: []
  }
  board2: Board = {
    id: "62de01f1ee60c664c3d720fb",
    time: 10000,
    listWinRound: [],
    listCard: [],
    listplayer: [],
    idPlayers: []
  }
  cards: Card[]=[];

  game:Game={
      id:"1",
      numberPlayers:0,
      playerModelList:[],
      cardGamesList:[]
  }
  game2:Game={
      id:"1",
      numberPlayers:0,
      playerModelList:[],
      cardGamesList:[]
  }

  playerId= "";

  title = 'appBootstrap';
  closeResult: string = '';

  winner: Player = {
    playerId : "",
      nickName : "",
      email: "",
      score: 0,
      pointsHistory: [],
      cardModels: [],
}

winnerCard: Card ={
  cardId: "",
  xp: 0,
  image: "",
  hidden: true,
  playerId: ""
}
@ViewChild('mymodal') mymodal: any;
@ViewChild('winnerGameModal') winnerGameModal: any;

  constructor(private boardAPIService: BoardAPIService,
    private cardAPIService: CardGameAPIService,
    private playerAPIService:PlayerAPIService,
    private gameAPIService: GameService,
    private modalService: NgbModal,
    private router: Router,) {
   }


  ngOnInit(): void {

    this.iniciarJuego();
    this.getPlayer();
    this.getCards();
    this.getGameOfDb();
       // this.updateCardsRoun(10);
       //this.timer(1);
    this.timer(5);

  }

  getPlayer():void{
    this.playerId=localStorage.getItem("uid")!;
    if (!this.playerId) {
       location.reload();
     }
  }

  getCards(){
    this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb").subscribe(
      board =>{
        this.board=board;
    })
    this.cards=this.board.listCard;
  }

  getGameOfDb(){
    this.gameAPIService.getGame().subscribe( game => this.game = game[0]);
  }

  getGameOfDbEnd(){
    this.gameAPIService.getGame().subscribe( game => {
      this.game = game[0];
      this.showCards();
    });
  }


  saveSelectedCard(event: any){

    this.board.listCard.forEach(card=>{
      if(card.cardId==event.target.id){
        this.addPlayerInDb(card);
      }
    });
  }

  addPlayerInDb(card: Card): void{
     this.gameAPIService.addPlayerInGame(card.playerId).subscribe(
       game =>{
         console.log(`se agrego el player al game= ${game}`)
         this.addCardInDb(card)
       }
     );
  }

  addCardInDb(card: Card): void{
     this.gameAPIService.addCardsInGame(card.cardId).subscribe(
       game =>{
         console.log(`se agreg la card al game= ${game}`)
         this.getGameOfDb();
       }


     );
  }

  bettingCards=[
    {
      cardId: "62dc7e8104e748902a9a82e8",
      xp: 1000,
      image: "../../assets/Pack 108 Pepsicards marvel/1F9.jpg",
      hidden: true,
      playerId: "2"
    },
  ]

  @HostListener('click', ['$event'])
  onClick(event: any) {
    try {
      if (!this.game.playerModelList.includes(this.playerId)) {
        // get the clicked element
        this.getGameOfDb()
        this.saveSelectedCard(event);
      }
    } catch (error) {

    }
  }

  nextGame(){
    if(this.board.idPlayers.length > 1){
      this.gameAPIService.updateGame(this.game2,"1").subscribe()
      location.reload();
    }else{
      this.router.navigate(['hall'])
    }
  }


  iniciarJuego(): void {
     this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb").subscribe(board => {
       if(board.listCard.length !== 5*board.idPlayers.length){
           this.cardAPIService.getRandomCards(board.idPlayers.length*5).subscribe(
           card=>{this.board.listCard.push(card)
            console.log(board.idPlayers.length);
          })
       }
     })
  }

  showCards(): void{
    this.game.cardGamesList.forEach(card =>{
      card.hidden = false;
      console.log(`Cartas: Xp=${card.xp} hidden=${card.hidden}`)
    });
    this.winnerRound();
  }

  timer(minute: number) {
    // let minute = 1;
    //let seconds: number = minute * 60;
    //aqui esta en segundos para probar
     let seconds: number = minute ;

    let textSec: any = "0";
    let statSec: number = 60;

    const prefix = minute < 10 ? "0" : "";

    const timer = setInterval(() => {
      seconds--;
      if (statSec != 0) statSec--;
      else statSec = 59;

      if (statSec < 10) {
        textSec = "0" + statSec;
      } else textSec = statSec;

      this.display = `${prefix}${Math.floor(seconds / 60)}:${textSec}`;

      if (seconds == 0) {
        console.log("finished: Pasar a definir ganador");
        clearInterval(timer);

        if (!this.game.playerModelList.includes(this.playerId)) {
          const randomNuber=Math.floor(Math.random() * this.board.listCard.filter(cardMap=>cardMap.playerId==this.playerId).length)
          const card=this.board.listCard.filter(cardMap=>cardMap.playerId==this.playerId)[randomNuber]

          this.addPlayerInDb(card);
        }

        setTimeout(() => {
          this.getGameOfDb();
        }, 10000);

        // setTimeout(() => {
        //   this.getGameOfDbEnd();
        // }, 20000);

      }
    }, 1000);
  }

  winnerRound(){

    if(this.game.cardGamesList.length == this.game.playerModelList.length){
          this.gameAPIService.getWinnerRound("1").subscribe(winner=>{
          this.playerAPIService.getPlayer(winner.playerId).subscribe(
          winnerRound=>{
            this.winner=winnerRound;
            this.boardAPIService.updateReallocateCards("62de01f1ee60c664c3d720fb").subscribe(a=>{
            this.getCards();
            this.winnerGame();
          });

          // this.nextGame();
        }
        );
        this.winnerCard=winner
      })
    }
  }

  winnerGame(){
    const numCards = this.board.listCard.filter(card => card.playerId == this.winner.playerId).length + 1;
    if( numCards >= (5*this.game.playerModelList.length)){
      this.gameAPIService.getWinnerGame("1").subscribe(
        winGAme => {
          this.open(this.winnerGameModal);
        }
      );
    }else{
      this.open(this.mymodal);
    }
  }

  buttonWinnerGame(){
    this.modalService.dismissAll();
    this.router.navigate(['hall']);
    this.boardAPIService.updateBoard("62de01f1ee60c664c3d720fb", this.board2).subscribe(a =>{
      this.gameAPIService.updateGame(this.game2,"1").subscribe()
    });
  }
  open(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  RetireGame(){
    alert("seguro que desea retirarse del juego?")
    this.gameAPIService.retireGame(this.playerId).subscribe(a=>{
      this.router.navigate(['auth'])});
  }

}

