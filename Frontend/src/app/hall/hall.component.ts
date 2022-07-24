import { Component, OnInit } from '@angular/core';
import { GameService } from '../services/game.service';
import { Game } from '../interfaces/game';
import { User } from '../models/user';


@Component({
  selector: 'app-hall',
  templateUrl: './hall.component.html',
  styleUrls: ['./hall.component.css']
})
export class HallComponent implements OnInit {

	constructor(private game : GameService) {}
  ngOnInit(): void {
    var userId = JSON.parse(localStorage.getItem('user')||"").uid;
        console.log((userId));
  }
  crearSala():void{
   
    //this.game.updateGame({Game},"62dd61651a07e0562b2cb040")
  }
 
}
