import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Player } from '../interfaces/player';


@Injectable({
  providedIn: 'root'
})
export class PlayerAPIService {

  private playerUrl = 'api/player/';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  /** GET cards from the server */
  getPlayers(): Observable<Player[]> {
      return this.http.get<Player[]>(this.playerUrl)
        .pipe(
          tap(_ => console.log('fetched players')),
          catchError(this.handleError<Player[]>('getPlayers', []))
        );
    }

  /** GET Player by id*/
  getPlayer(id: string | null): Observable<Player> {
    const url = `${this.playerUrl}/${id}`;
    return this.http.get<Player>(url).pipe(
      tap(_ => console.log(`fetched player id=${id}`)),
      catchError(this.handleError<Player>(`getPlayer id=${id}`))
    );
  }

  //////// Save methods //////////
  /** POST: add a new hero to the server */
  addPlayer(player: Player): Observable<Player> {
    return this.http.post<Player>(this.playerUrl, player, this.httpOptions).pipe(
      tap((newPlayer: Player) => console.log(`added Player w/ id=${newPlayer.playerId}`)),
      catchError(this.handleError<Player>('addPlayer'))
    );
  }

  /** PUT: update the hero on the server */
  updatePlayer(id: string,  player: Player): Observable<any> {
    const url = `${this.playerUrl}/${id}`;
    return this.http.put(url, player, this.httpOptions).pipe(
      tap(_ => console.log(`updated player id=${player.playerId}`)),
      catchError(this.handleError<any>('updatePlayer'))
    );
  }

  addPointsHistory(points: number,  player: Player): Observable<any> {
    const url = `${this.playerUrl}/points/${points}`;
    return this.http.put(url, player, this.httpOptions).pipe(
      tap(_ => console.log(`addPointsHistory player id=${player.playerId} points=${player.pointsHistory}`)),
      catchError(this.handleError<any>('addPointsHistory'))
    );
  }

  addScore(score: number,  player: Player): Observable<any> {
    const url = `${this.playerUrl}/score/${score}`;
    return this.http.put(url, player, this.httpOptions).pipe(
      tap(_ => console.log(`updated player id=${player.playerId} score=${player.score}`)),
      catchError(this.handleError<any>('addScore'))
    );
  }

  /** DELETE: delete the hero from the server */
  deleteHero(id: number): Observable<Player> {
    const url = `${this.playerUrl}/${id}`;

    return this.http.delete<Player>(url, this.httpOptions).pipe(
      tap(_ => console.log(`Delete player id=${id}`)),
        catchError(this.handleError<Player>('deletePalyer'))
      );
  }

  /** GET Player by id. Return `undefined` when id not found */
   getPlayerNo404<Data>(id: String | null): Observable<Player> {
      const url = `${this.playerUrl}/?id=${id}`;
      return this.http.get<Player[]>(url)
        .pipe(
          map(player => player[0]), // returns a {0|1} element array
          tap(h => {
            const outcome = h ? 'fetched' : 'did not find';
            console.log(`${outcome} player id=${id}`);
          }),
          catchError(this.handleError<Player>(`getplayer id=${id}`))
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
