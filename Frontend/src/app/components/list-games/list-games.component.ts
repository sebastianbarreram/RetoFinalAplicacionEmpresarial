import { Component, OnInit } from '@angular/core';
import { PlayerAPIService } from '../../services/player-api.service';
import { Player } from '../../interfaces/player';
import { BoardAPIService } from '../../services/board-api.service';
import { Board } from 'src/app/interfaces/board';
import { map } from 'rxjs/operators';



@Component({
  selector: 'app-list-games',
  templateUrl: './list-games.component.html',
  styleUrls: ['./list-games.component.css']
})
export class ListGamesComponent implements OnInit {

  boards : Board[]=[];
	playerId: string= "";
  
	player: Player = {
			playerId : "",
				nickName : "",
				email: "",
				score: 0,

				pointsHistory: [],
				cardModels: [],
	}

  board: Board = {
    id: "62de01f1ee60c664c3d720fb",
time: 10000,
listWinRound: [],
listCard: [],
listplayer: [],
idPlayers: []
}
  listaPlayers: string[]=[];

  constructor(private playerAPIService: PlayerAPIService, 
    private boardAPIService: BoardAPIService) {
      this.getPlayer();
      this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb")
      .subscribe(board=>this.board=board);
      this.board.idPlayers.push(this.playerId); 
      }
      
  
  ngOnInit(): void {
    this.addPlayerToBoard();
    
  }
  iniciarJuego(): void {
  }
  getPlayer():void{
    this.playerId=(localStorage.getItem("uid")!);
    if (!this.playerId) {
      location.reload();
    }
    this.board.idPlayers.push(this.playerId)
  }
  addPlayerToBoard(): void {
    // if(this.playerId==null){
    //   location.reload();
    // }
    //  this.playerAPIService.getPlayer(this.playerId).subscribe(element=>{  

    //   this.boardAPIService.addBoard(this.board)
    //   console.log(JSON.stringify(this.board.listPlayer));
      
    // }
    //   ) 
    if (this.board) {
      
      console.log(this.board.idPlayers);
      this.boardAPIService.addBoard(this.board).subscribe(respuesta=>console.log(respuesta));
    }
    
  }

    // this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    //   .subscribe(board=>
    //     board.idplayers.push(playerId||"")
    //     this.boardAPIService.updateBoard("62dd61651a07e0562b2cb040",board) )
    //     //board.listplayer.push(playerId}

  }

  




