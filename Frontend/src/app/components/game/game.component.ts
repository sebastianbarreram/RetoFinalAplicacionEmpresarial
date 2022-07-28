import { Component, HostListener, OnInit } from '@angular/core';
import { Board } from 'src/app/interfaces/board';
import { Card } from 'src/app/interfaces/card';
import { Game } from 'src/app/interfaces/game';
import { BoardAPIService } from 'src/app/services/board-api.service';
import { GameService } from 'src/app/services/game.service';
import { CardGameAPIService } from '../../services/card-api.service';
import { PlayerAPIService } from '../../services/player-api.service';


@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  display: any;

  board: Board = {
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


  handPlayer: Card[]=[];

  playerId= "";
  constructor(private boardAPIService: BoardAPIService,
    private cardAPIService: CardGameAPIService,
    private playerAPIService:PlayerAPIService,
    private gameAPIService: GameService ) {

      this.getCards();

   }


  ngOnInit(): void {

    this.iniciarJuego();
    this.getPlayer();
    this.getCards();
    this.gameAPIService.getGame().subscribe( game => this.game = game[0]);
       // this.updateCardsRoun(10);
        //this.timer(1);
          //para hacer pruebas en segundos recordar quitar el comentario en el metoo timer
    this.timer(10);

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
        this.handPlayer = board.listCard;
    })
    this.cards=this.board.listCard;
  }



  bettingCards=[
    // {
    //   cardId: "62dc7e8104e748902a9a82de",
    //   xp: 600,
    //   image: "../../assets/Pack 108 Pepsicards marvel/063.jpg",
    //   hidden: true,
    //   playerId: 1
    // },
    {
      cardId: "62dc7e8104e748902a9a82e8",
      xp: 1000,
      image: "../../assets/Pack 108 Pepsicards marvel/1F9.jpg",
      hidden: true,
      playerId: "2"
    },
    // {
    //   cardId: "62dc7e8104e748902a9a82e1",
    //   xp: 500,
    //   image: "../../assets/Pack 108 Pepsicards marvel/807.jpg",
    //   hidden: true,
    //   playerId: "3"
    // }
  ]

  players=["2"]

  @HostListener('click', ['$event'])
  onClick(event: any) {
    try {
      if (!this.game.playerModelList.includes(this.playerId)) {
      // get the clicked element
      this.board.listCard.forEach(card=>card.cardId==event.target.id?
      this.game.cardGamesList.push(card) &&
      this.game.playerModelList.push(card.playerId) &&
      this.gameAPIService.addPlayerInGame(card.playerId,this.game).subscribe(a => console.log(a)):NaN);
      console.log("card of player: "+this.playerId)

      this.gameAPIService.updateGame(this.game, this.game.id).subscribe();

    }
    } catch (error) {

    }

  }

  updateCardsRoun(second: number) {
    // let minute = 1;
    //let seconds: number = minute * 60;
    //aqui esta en segundos para probar
    let seconds: number = second ;

    let textSec: any = "0";
    let statSec: number = 60;

    const prefix = second < 10 ? "0" : "";

    const timer = setInterval(() => {
      seconds--;
      if (statSec != 0) statSec--;
      else statSec = 59;

      if (statSec < 10) {
        textSec = "0" + statSec;
      } else textSec = statSec;

      this.display = `${prefix}${Math.floor(seconds / 60)}:${textSec}`;

      if (seconds == 0) {
        clearInterval(timer);
       // this.updateCardsRoun(3);
        this.gameAPIService.getGame().subscribe( game => this.game = game[0])
      // this.game.cardGamesList.push(game[0].cardGamesList) && this.players.push(game[0].playerId):NaN) )
      }

    }, 1000);
  }


  clearGame(){
    this.gameAPIService.updateGame(this.game2,"1").subscribe()
    location.reload();
  }

   iniciarJuego(): void {
     this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb").subscribe(board => {
       if(board.listCard.length === 0){
           this.cardAPIService.getRandomCards(this.board.idPlayers.length*5).subscribe(
           card=>this.board.listCard.push(card))
       }
     })
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

          this.game.cardGamesList.push(card)
          this.game.playerModelList.push(card.playerId) &&
          this.gameAPIService.addPlayerInGame(card.playerId,this.game).subscribe();
        }
        /*actualiza tablero de cartas por ronda*/
        //this.gameAPIService.getGame().subscribe( game => this.game = game[0]);
      }
    }, 1000);
  }

}



