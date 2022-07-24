import { Component, OnInit } from '@angular/core';
import { Card } from 'src/app/interfaces/card';
import { CardGameAPIService } from 'src/app/services/card-api.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  cards: Card[] = [];

  constructor(private cardGameAPI: CardGameAPIService) { }

  ngOnInit(): void {
    this.getCards();
  }

  getCards(): void {
    this.cardGameAPI.getCards()
      .subscribe(cards => this.cards = cards);
  }

  // cards = [
  //   {
  //     "cardId": "62dc7e8104e748902a9a82ec",
  //     "xp": 1000,
  //     "image": "../../assets/Pack 108 Pepsicards marvel/25B.jpg",
  //     "hidden": true,
  //     "playerId": "62dd5edd1a07e0562b2cb03e"
  //   },
  //   {
  //     "cardId": "62dc7e8104e748902a9a82ed",
  //     "xp": 100,
  //     "image": "../../assets/Pack 108 Pepsicards marvel/272.jpg",
  //     "hidden": true,
  //     "playerId": "62dd5edd1a07e0562b2cb03e"
  //   },
  //   {
  //     "cardId": "62dc7e8104e748902a9a82ee",
  //     "xp": 400,
  //     "image": "../../assets/Pack 108 Pepsicards marvel/287.jpg",
  //     "hidden": true,
  //     "playerId": "62dd5edd1a07e0562b2cb03e"
  //   },
  //   {
  //     "cardId": "62dc7e8104e748902a9a82ef",
  //     "xp": 900,
  //     "image": "../../assets/Pack 108 Pepsicards marvel/292.jpg",
  //     "hidden": true,
  //     "playerId": "62dd5edd1a07e0562b2cb03e"
  //   },
  //   {
  //     "cardId": "62dc7e8104e748902a9a82f0",
  //     "xp": 400,
  //     "image": "../../assets/Pack 108 Pepsicards marvel/2E2.jpg",
  //     "hidden": true,
  //     "playerId": "62dd5edd1a07e0562b2cb03e"
  //   }
  // ];

}
