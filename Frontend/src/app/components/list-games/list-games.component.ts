import { Component, OnInit } from '@angular/core';
import { PlayerAPIService } from '../../services/player-api.service';
import { Player } from '../../interfaces/player';
import { BoardAPIService } from '../../services/board-api.service';
import { Board } from 'src/app/interfaces/board';
import { findIndex, map } from 'rxjs/operators';
import { HttpParams } from '@angular/common/http';
import { CardGameAPIService } from '../../services/card-api.service';
import { Router } from '@angular/router';
import { GameService } from 'src/app/services/game.service';
import { Card } from '../../interfaces/card';

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
  handPlayer:Card[]=[];

  constructor(
    private boardAPIService: BoardAPIService,
    private cardAPIService: CardGameAPIService,
    private router: Router,
    private gameService: GameService,
    ) {
      }


  ngOnInit(): void {
    this.getPlayerLocal();
    this.addPlayerToBoard();
    //this.addPlayersIdToBoard();
    this.getBoardOfDB();

  }

  iniciarJuego(){
      this.router.navigate(['game']);
  }

  getPlayerLocal():void{
    this.playerId=localStorage.getItem("uid")!;
    if (!this.playerId) {
      location.reload();
    }
  }


  getBoardOfDB(): void {
    this.boardAPIService.getBoardById("62de01f1ee60c664c3d720fb").subscribe(board=>{this.board=board})
    console.log("consulta Db: ",this.board.idPlayers);
  }

  // addPlayersToBoard(): void {

  //   this.board.idPlayers.push(this.playerId);

  //   console.log("Actualizacion Local: ",this.board.idPlayers);
  // }

  addPlayerToBoard(): void {

    this.board.idPlayers.push(this.playerId);
    this.boardAPIService.addPlayerInBoard(this.playerId).subscribe();
    console.log("Actualizacion Local: ",this.board.idPlayers);
  }
}








