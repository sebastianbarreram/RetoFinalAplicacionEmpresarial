import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HEROES } from '../mock-heroes';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';



@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {
  //selectedHero?: Hero;
  hero: Hero = {id:1,name:'Windstorm'};
  //heroes = HEROES;
  heroes:Hero[] = []

  constructor(private heroService:HeroService, private messageService:MessageService) { }

 /* onSelect(hero: Hero): void {
    this.selectedHero = hero;
    this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
  }*/

  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes():void {
    //this.heroes = this.heroService.getHeroes();
    this.heroService.getHeroes().subscribe(heroes=>this.heroes=heroes);
  }

}
