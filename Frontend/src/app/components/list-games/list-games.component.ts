import { Component, OnInit } from '@angular/core';
import { PlayerAPIService } from '../../services/player-api.service';
import { Player } from '../../interfaces/player';
import { BoardAPIService } from '../../services/board-api.service';
import { Board } from 'src/app/interfaces/board';


@Component({
  selector: 'app-list-games',
  templateUrl: './list-games.component.html',
  styleUrls: ['./list-games.component.css']
})
export class ListGamesComponent implements OnInit {

  Players : Player[]=[];
	playerId: string = "";
  boardId: string ="";

	player: Player = {
			playerId : "",
				nickName : "",
				email: "",
				score: 0,

				pointsHistory: [],
				cardModels: [],
	}

  boards: Board | undefined;

  constructor(private playerAPIService: PlayerAPIService, 
    private boardAPIService: BoardAPIService) {

  }
  ngOnInit(): void {
    // this.addPlayerToBoard();
    this.getBoard();
  }
  iniciarJuego(): void {
    
    // var playerId = JSON.parse(localStorage.getItem('user') || "").uid;
    // console.log(playerId);
    // this.playerAPIService.getPlayer(playerId).subscribe(player => this.player = player)
    //this.playerAPIService.getPlayer(playerId).subscribe(player =>  console.log(player.email));
    
  }

  getBoard(): void {
   
    this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    .subscribe(board=>{
      this.boardId=board.id});
      console.log(this.boardId);
      
  }

  addPlayerToBoard(): void {
    const playerId = localStorage.getItem('uid');
    console.log(playerId);
    
    this.playerAPIService.getPlayer(playerId)
    .subscribe(player => {
      this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
      .subscribe(board=>{
        var newBoard=board;
        var listaJugadores=newBoard.listplayer;
        console.log(listaJugadores);
        listaJugadores.push(player);
        console.log(listaJugadores);
        board.listplayer=listaJugadores;
        console.log(typeof(board))
        this.boardAPIService.updateBoard("62dd61651a07e0562b2cb040",board);
        console.log("Tiene que actualizar")
      });
    })
  }



}
