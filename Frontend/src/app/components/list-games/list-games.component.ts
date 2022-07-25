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
    id: "62debea588fdc0240d2ced4d",
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
    this.getPlayer();
    this.addPlayerToBoard();
    
  }
  iniciarJuego(): void {
  }
  getPlayer():void{
    this.playerId=(localStorage.getItem("uid")!);
    
  }
  addPlayerToBoard(): void {
    console.log(this.playerId);
   this.playerAPIService.getPlayer(this.playerId).subscribe(element=>{  
      this.board.listPlayer.push(this.player)  
      this.boardAPIService.addPlayerBoard(this.playerId,this.board).subscribe()
      console.log(this.board);
    }
      ) 
      
      
  }

    // this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    //   .subscribe(board=>
    //     board.idplayers.push(playerId||"")
    //     this.boardAPIService.updateBoard("62dd61651a07e0562b2cb040",board) )
    //     //board.listplayer.push(playerId}

  }

  




