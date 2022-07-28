import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Player } from '../interfaces/player';
import { Board } from '../interfaces/board';


@Injectable({
  providedIn: 'root'
})
export class BoardAPIService {

  private boardUrl = 'api/board';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(private http: HttpClient) { }

  /** GET boards from the server */
  /*getBoards(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playerUrl)
      .pipe(
        tap(_ => console.log('fetched players')),
        catchError(this.handleError<Player[]>('getPlayers', []))
      );
  }*/

/** GET Board by id*/
getBoardById(id: string | null): Observable<Board> {
  const url = `${this.boardUrl}/${id}`;
  return this.http.get<Board>(url).pipe(
    tap(_ => console.log(`fetched board id=${id}`)),
    catchError(this.handleError<Board>(`getBoardById id=${id}`))
  );
}


//////// Save methods //////////
/** POST: add a new hero to the server */
addBoard(board: Board): Observable<Board> {
  return this.http.post<Board>(this.boardUrl, board, this.httpOptions).pipe(
    tap((newBoard: Board) => console.log(`added board id=${newBoard.id}`)),
    catchError(this.handleError<Board>('addBoard'))
  );
}



/** PUT: update the board on the server */
updateBoard(id: string|null,  board: Board): Observable<any> {
  const url = `${this.boardUrl}/${id}`;
  return this.http.put(url, board, this.httpOptions).pipe(
    tap(_ => console.log(`updated board id=${board.id}`)),
    catchError(this.handleError<any>('updateBoard'))
  );
}

updateReallocateCards(id: string): Observable<any> {
  const url = `${this.boardUrl}/reallocatecards/${id}`;
  return this.http.put(url, this.httpOptions).pipe(
    tap(_ => console.log(`reallocateCards`)),
    catchError(this.handleError<any>('UdateReallocateCards'))
  );
}

/*
updateTieBreak(id: string): Observable<any> {
  const url = `${this.boardUrl}/tiebreak/${id}`;
  return this.http.put(url, this.httpOptions).pipe(
    tap(_ => console.log(`updateTieBreak`)),
    catchError(this.handleError<any>('updateTieBreak'))
  );
}
*/

updateUseCards(id: string, idCard: string ): Observable<any> {
  const url = `${this.boardUrl}/set/${idCard}`;
  return this.http.put(url, this.httpOptions).pipe(
    tap(_ => console.log(`updateUseCards`)),
    catchError(this.handleError<any>('updateUseCards'))
  );
}
/*

/** DELETE: delete the hero from the server */
deleteHero(id: number): Observable<Player> {
  const url = `${this.boardUrl}/${id}`;

  return this.http.delete<Player>(url, this.httpOptions).pipe(
    tap(_ => console.log(`Delete player id=${id}`)),
      catchError(this.handleError<Player>('deletePalyer'))
    );
}

/** GET Player by id. Return `undefined` when id not found */
 getPlayerNo404<Data>(id: String | null): Observable<Player> {
    const url = `${this.boardUrl}/?id=${id}`;
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
  addPlayerInBoard(id:string):Observable<any>{
    const url = `${this.boardUrl}/player/${id}`;
    return this.http.put(url, this.httpOptions).pipe(
      tap(_ => console.log(`addPlayer ${id} InBoard`)),
      catchError(this.handleError<any>('updateUseCards')))
    }

  addPlayerIdInBoard(id:string):Observable<any>{
    const url = `${this.boardUrl}/playerid/${id}`;
    return this.http.put(url, this.httpOptions).pipe(
      tap(_ => console.log(`addPlayer ${id} InBoard`)),
      catchError(this.handleError<any>('updateUseCards')))
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
