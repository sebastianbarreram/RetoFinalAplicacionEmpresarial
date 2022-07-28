import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Game } from '../interfaces/game';
import { Router } from '@angular/router';
import { Card } from '../interfaces/card';
@Injectable({
  providedIn: 'root'
})
export class GameService {
  private gameUrl = 'api/game'; // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

    /** GET cards from the server */
  getGame(): Observable<Game[]> {
    return this.http.get<Game[]>(this.gameUrl)
      .pipe(
        tap(_ => console.log('creating game')),
        catchError(this.handleError<Game[]>('createGame', []))
      );
  }

  addGame(game: Game): Observable<Game> {
    return this.http.post<Game>(this.gameUrl, game, this.httpOptions).pipe(
      tap((newGame: Game) => console.log(`creating game w/ id=${newGame.id}`)),
      catchError(this.handleError<Game>('addGame'))
    );
  }
  deleteGame(): Observable<Game> {
    const url = `${this.gameUrl}`;
    return this.http.post<Game>(url, this.httpOptions).pipe(
      tap(_ => console.log(`deleted game`)),
      catchError(this.handleError<Game>('deleteGame'))
    );
  }
  updateGame(game: Game,id: string): Observable<any> {
    return this.http.put(`${this.gameUrl}/actualizar/${id}`, game, this.httpOptions).pipe(
      tap(_ => console.log(`updated card cardId=${game.id}`)),
      catchError(this.handleError<any>('updateCard'))
    );
  }
  retireGame(idPlayer:string,game: Game):Observable<any>{
    return this.http.put(`${this.gameUrl}/retire/${idPlayer}`, game, this.httpOptions).pipe(
      tap(_ => console.log(`retired player id=${game.id}`)),
      catchError(this.handleError<any>('retireGame'))
    );
  }

  addPlayerInGame(id: string): Observable<any> {
    return this.http.put(`${this.gameUrl}/player/${id}/`, this.httpOptions).pipe(
    tap(_ => console.log(`updated card cardId=${id}`)),
    catchError(this.handleError<any>('addPlayerInGame'))
    );
  }

  addCardsInGame(id: string): Observable<any> {
    return this.http.put(`${this.gameUrl}/card/${id}/`, this.httpOptions).pipe(
    tap(_ => console.log(`updated card cardId=${id}`)),
    catchError(this.handleError<any>('addPlayerInGame'))
    );
  }

  /** GET Winner round*/
getWinnerRound(id: string | null): Observable<Card> {
  const url = `${this.gameUrl}/win/${id}`;
  return this.http.get<Card>(url).pipe(
    tap(_ => console.log(`fetched win board id=${id}`)),
    catchError(this.handleError<Card>(`getWinBoard id=${id}`))
  );
}

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
