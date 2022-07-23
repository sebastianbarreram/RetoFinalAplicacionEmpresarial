import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hall',
  templateUrl: './hall.component.html',
  styleUrls: ['./hall.component.css']
})
export class HallComponent implements OnInit {
  
  constructor() { 
    
  }

  ngOnInit(): void {
    
  }

  cards = [
    {xp:400,image:"../../assets/Pack 108 Pepsicards marvel/2E2.jpg",hidden:false},
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

}
