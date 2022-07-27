import { Component, OnInit } from '@angular/core';
import { GameService } from '../services/game.service';
import { Game } from '../interfaces/game';
import { User } from '../models/user';
import { Player } from '../interfaces/player';
import { PlayerAPIService } from '../services/player-api.service';


@Component({
  selector: 'app-hall',
  templateUrl: './hall.component.html',
  styleUrls: ['./hall.component.css']
})
export class HallComponent implements OnInit {

  player: Player = {
    playerId : "",
      nickName : "",
      email: "",
      score: 0,

      pointsHistory: [],
      cardModels: [],
}
	constructor(private game : GameService, private playerAPIService: PlayerAPIService) {}
  ngOnInit(): void {

    this.addPlayer();

  }

  addPlayer(){
			var userId = JSON.parse(localStorage.getItem('user')||"").uid! ;
			var userEmail = JSON.parse(localStorage.getItem('user')||"").email;

      var userIdMongoDb = "";

      this.playerAPIService.getPlayer(userId).subscribe(user => userIdMongoDb= user.playerId!);

      if(userId !== userId){

	      this.player.playerId = userId;
			  this.player.email = userEmail;

			  this.playerAPIService.addPlayer(this.player)
			  .subscribe();
      }
  }
}
