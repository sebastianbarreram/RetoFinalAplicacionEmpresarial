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
      this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb")
    .subscribe(board=>{this.board=board})
    
      
      }
      
  
  ngOnInit(): void {
    if(this.board){
      this.getPlayer();
    }
    this.addPlayerToBoard();
    
  }
  iniciarJuego(): void {
  }
  getPlayer():void{
    this.playerId=(localStorage.getItem("uid")!);
    
    if (!this.playerId) {
      location.reload();

    }
    
  }
  addPlayerToBoard(): void {

    if (this.board) {
      console.log(this.board.idPlayers);
      this.boardAPIService.addPlayerInBoard(this.playerId,this.board)
      .subscribe(respuesta=>console.log(respuesta));
    } 
  }
  }

  




