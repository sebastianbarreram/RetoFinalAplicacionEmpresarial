import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  display: any;
  constructor() { }

  ngOnInit(): void {
    // this.timer(1);
    //para hacer pruebas en segundos recordar quitar el comentario en el metoo timer
    this.timer(3);

  }

  playerId="1";
  cards = [
  {
		cardId: "2222222",
		xp: 600,
		image: "../../assets/Pack 108 Pepsicards marvel/303.jpg",
		hidden: true,
		playerId: "1"
	},
  {
		cardId: "62dc7e8104e748902a9a82de",
		xp: 600,
		image: "../../assets/Pack 108 Pepsicards marvel/063.jpg",
		hidden: true,
		playerId: "1"
	},
	{
		cardId: "62dc7e8104e748902a9a82df",
		xp: 100,
		image: "../../assets/Pack 108 Pepsicards marvel/0BF.jpg",
		hidden: true,
		playerId: "1"
	},
	{
		cardId: "62dc7e8104e748902a9a82e0",
		xp: 800,
		image: "../../assets/Pack 108 Pepsicards marvel/0E0.jpg",
		hidden: true,
		playerId: "1"
	},
	{
		cardId: "62dc7e8104e748902a9a82e1",
		xp: 500,
		image: "../../assets/Pack 108 Pepsicards marvel/138.jpg",
		hidden: true,
		playerId: "1"
	},
  {
    cardId: "62dc7e8104e748902a9a82ff",
    xp: 200,
    image: "../../assets/Pack 108 Pepsicards marvel/5A6.jpg",
    hidden: true,
    playerId: "2"
  },
  {
    cardId: "62dc7e8104e748902a9a8300",
    xp: 1000,
    image: "../../assets/Pack 108 Pepsicards marvel/5B9.jpg",
    hidden: true,
    playerId: "2"
  },
  {
    cardId: "62dc7e8104e748902a9a8301",
    xp: 400,
    image: "../../assets/Pack 108 Pepsicards marvel/5DE.jpg",
    hidden: true,
    playerId: "2"
  },
  {
    cardId: "62dc7e8104e748902a9a8302",
    xp: 1000,
    image: "../../assets/Pack 108 Pepsicards marvel/5EA.jpg",
    hidden: true,
    playerId: "2"
  },
  {
    cardId: "62dc7e8104e748902a9a8303",
    xp: 800,
    image: "../../assets/Pack 108 Pepsicards marvel/625.jpg",
    hidden: true,
    playerId: "2"
  },
  {
    cardId: "62dc7e8104e748902a9a8306",
    xp: 300,
    image: "../../assets/Pack 108 Pepsicards marvel/6AC.jpg",
    hidden: true,
    playerId: "3"
  },
  {
    cardId: "62dc7e8104e748902a9a8307",
    xp: 1000,
    image: "../../assets/Pack 108 Pepsicards marvel/6B6.jpg",
    hidden: true,
    playerId: "3"
  },
  {
    cardId: "62dc7e8104e748902a9a8308",
    xp: 300,
    image: "../../assets/Pack 108 Pepsicards marvel/740.jpg",
    hidden: true,
    playerId: "3"
  },
  {
    cardId: "62dc7e8104e748902a9a8309",
    xp: 700,
    image: "../../assets/Pack 108 Pepsicards marvel/74D.jpg",
    hidden: true,
    playerId: "3"
  },
  {
    cardId: "62dc7e8104e748902a9a830a",
    xp: 400,
    image: "../../assets/Pack 108 Pepsicards marvel/763.jpg",
    hidden: true,
    playerId: "3"
  }
  
]
  aux=[
    {xp:100,image:"../../assets/Pack 108 Pepsicards marvel/303.jpg",hidden:false},
    {xp:1000,image:"../../assets/Pack 108 Pepsicards marvel/334.jpg",hidden:false},
    {xp:900,image:"../../assets/Pack 108 Pepsicards marvel/338.jpg",hidden:false},
    {xp:500,image:"../../assets/Pack 108 Pepsicards marvel/33C.jpg",hidden:false},
    {xp:700,image:"../../assets/Pack 108 Pepsicards marvel/34F.jpg",hidden:true},
    {xp:900,image:"../../assets/Pack 108 Pepsicards marvel/367.jpg",hidden:false},
    {xp:1000,image:"../../assets/Pack 108 Pepsicards marvel/7D1.jpg",hidden:false},
{xp:300,image:"../../assets/Pack 108 Pepsicards marvel/7DB.jpg",hidden:false},
{xp:700,image:"../../assets/Pack 108 Pepsicards marvel/7EB.jpg",hidden:false},
{xp:1000,image:"../../assets/Pack 108 Pepsicards marvel/807.jpg",hidden:false},
{xp:600,image:"../../assets/Pack 108 Pepsicards marvel/81F.jpg",hidden:false},
{xp:900,image:"../../assets/Pack 108 Pepsicards marvel/85F.jpg",hidden:false},
{xp:700,image:"../../assets/Pack 108 Pepsicards marvel/86A.jpg",hidden:true},
  ];

  bettingCards=[  
    // {
    //   cardId: "62dc7e8104e748902a9a82de",
    //   xp: 600,
    //   image: "../../assets/Pack 108 Pepsicards marvel/063.jpg",
    //   hidden: true,
    //   playerId: 1
    // },
    {
      cardId: "62dc7e8104e748902a9a82e8",
      xp: 1000,
      image: "../../assets/Pack 108 Pepsicards marvel/1F9.jpg",
      hidden: true,
      playerId: "2"
    },  
    // {
    //   cardId: "62dc7e8104e748902a9a82e1",
    //   xp: 500,
    //   image: "../../assets/Pack 108 Pepsicards marvel/807.jpg",
    //   hidden: true,
    //   playerId: "3"
    // }
  ]

  players=["3"]

  @HostListener('click', ['$event'])
  onClick(event: any) {
    try {
      
      // console.log("card of player: "+jugadorId)
    
    if (!this.players.includes(this.playerId)) {
      // get the clicked element
    this.cards.forEach(card=>card.cardId==event.target.id? 
      this.bettingCards.push(card) && this.players.push(card.playerId):NaN);
      console.log("card of player: "+this.playerId)
      
    }
    } catch (error) {
      
    }
    
    
  }

  timer(minute: number) {
    // let minute = 1;
    // let seconds: number = minute * 60;
    //aqui esta en segundos para probar
    let seconds: number = minute ;

    let textSec: any = "0";
    let statSec: number = 60;

    const prefix = minute < 10 ? "0" : "";

    const timer = setInterval(() => {
      seconds--;
      if (statSec != 0) statSec--;
      else statSec = 59;

      if (statSec < 10) {
        textSec = "0" + statSec;
      } else textSec = statSec;

      this.display = `${prefix}${Math.floor(seconds / 60)}:${textSec}`;

      if (seconds == 0) {
        console.log("finished: Pasar a definir ganador");
        clearInterval(timer);
        const randomNuber=Math.floor(Math.random() * this.cards
        .filter(cardMap=>cardMap.playerId==this.playerId).length)
        
        if (!this.players.includes(this.playerId)) {
          const card=this.cards.filter(cardMap=>cardMap.playerId==this.playerId)[randomNuber]
        this.bettingCards.push(card)
        this.players.push(card.playerId)
        }
        
      }
    }, 1000);
  }

}

  
