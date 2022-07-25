import { Component, OnInit } from '@angular/core';
import { PlayerAPIService } from '../../services/player-api.service';
import { Player } from '../../interfaces/player';
import { BoardAPIService } from '../../services/board-api.service';
import { Board } from 'src/app/interfaces/board';
import { ignoreElements, map } from 'rxjs/operators';
import { BoundTarget } from '@angular/compiler';


@Component({
  selector: 'app-list-games',
  templateUrl: './list-games.component.html',
  styleUrls: ['./list-games.component.css']
})
export class ListGamesComponent implements OnInit {

  Players : Player[]=[];
	playerId: string = "";
  boardId: string="";

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
    listCard: [],
    idplayers: [],
  }
  listaPlayers: string[]=[];

  constructor(private playerAPIService: PlayerAPIService, 
    private boardAPIService: BoardAPIService) {
      this.playerId = localStorage.getItem('uid')||"";

  }
  ngOnInit(): void {
    
    this.addPlayerToBoard();
  }
  iniciarJuego(): void {
    
    // var playerId = JSON.parse(localStorage.getItem('user') || "").uid;
    // console.log(playerId);
    // this.playerAPIService.getPlayer(playerId).subscribe(player => this.player = player)
    //this.playerAPIService.getPlayer(playerId).subscribe(player =>  console.log(player.email));
    
  }

  addPlayerToBoard(): void {
    
    this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    .subscribe(board=>{
      this.board.idplayers=board.idplayers;
      this.board.idplayers.push(this.playerId);
    })
    
    this.boardAPIService.addBoard(this.board)
    .subscribe(board => this.listaPlayers.push(this.playerId));
    
    
    // this.boardAPIService.getBoardById("62dd61651a07e0562b2cb040")
    //   .subscribe(board=>
    //     board.idplayers.push(playerId||"")
    //     this.boardAPIService.updateBoard("62dd61651a07e0562b2cb040",board) )
    //     //board.listplayer.push(playerId}

  }

  



}
