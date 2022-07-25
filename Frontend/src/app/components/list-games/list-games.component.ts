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

  boards : Board[]=[];
	playerId: string = "";
  
	player: Player = {
			playerId : "",
				nickName : "",
				email: "",
				score: 0,

				pointsHistory: [],
				cardModels: [],
	}

  board: Board = {
    id: "62dd61651a07e0562b2cb040",
    time: 1,
    listWindRound:[],
    listCard: [],
    listPlayer:[],
    idplayers: [],
  }
  listaPlayers: string[]=[];

  constructor(private playerAPIService: PlayerAPIService, 
    private boardAPIService: BoardAPIService) {
      
  }
  ngOnInit(): void {
   
    this.addPlayerToBoard();
  }
  iniciarJuego(): void {
    
    // var playerId = JSON.parse(localStorage.getItem('user') || "").uid;
    // console.log(playerId);
     
    //this.playerAPIService.getPlayer(playerId).subscribe(player =>  console.log(player.email));
    
  }

  addPlayerToBoard(): void {
   
    this.playerId =JSON.parse(localStorage.getItem('user') || "").uid;
     this.playerAPIService.getPlayer(this.playerId).subscribe(player =>{
      this.board.listPlayer.push(player)
      player.playerId
      this.boardAPIService.updateBoard(this.board.id, this.board)
    .subscribe();
  });
   
    // this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    //   .subscribe(board=>
    //     board.idplayers.push(playerId||"")
    //     this.boardAPIService.updateBoard("62dd61651a07e0562b2cb040",board) )
    //     //board.listplayer.push(playerId}

  }

  



}
