import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { Hero } from "./hero";
import { MessageService } from "./message.service";
import { HEROES } from "./mock-heroes";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
    providedIn: 'root',
  })
export class HeroService {
	private heroesUrl = "http://localhost:8080/heroes";

	constructor(
		private messageService: MessageService,
		private http: HttpClient,
	) {}

	getHeroes(): Observable<Hero[]> {
		let header = new HttpHeaders().set("Type-content", "aplication/json");
		const heroes = of(HEROES);
		this.messageService.add("HeroService: fetched heroes");
		return heroes;
		//return HEROES;
		//return this.http.get<Hero[]>(this.heroesUrl,{headers:header});
	}

	getHero(id: number): Observable<Hero> {
		// For now, assume that a hero with the specified `id` always exists.
		// Error handling will be added in the next step of the tutorial.
		const hero = HEROES.find((h) => h.id === id)!;
		this.messageService.add(`HeroService: fetched hero id=${id}`);
		return of(hero);
	}
}
