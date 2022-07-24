import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Card } from '../interfaces/card';

@Injectable({
  providedIn: 'root'
})
export class CardGameAPIService {
  private cardUrl = 'api/cards';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

    /** GET cards from the server */
  getCards(): Observable<Card[]> {
    return this.http.get<Card[]>(this.cardUrl)
      .pipe(
        tap(_ => console.log('fetched cards')),
        catchError(this.handleError<Card[]>('getCards', []))
      );
  }

  /** GET card by cardId. Will 404 if id not found */
  getCardById(cardId: string | null): Observable<Card> {
    const url = `${this.cardUrl}/${cardId}`;
    return this.http.get<Card>(url).pipe(
      tap(_ => console.log(`fetched card cardId=${cardId}`)),
      catchError(this.handleError<Card>(`getCardById cardId=${cardId}`))
    );
  }

  /** POST: add a new card to the server */
  addCard(card: Card): Observable<Card> {
    return this.http.post<Card>(this.cardUrl, card, this.httpOptions).pipe(
      tap((newCard: Card) => console.log(`added card w/ id=${newCard.cardId}`)),
      catchError(this.handleError<Card>('addCard'))
    );
  }

  /** DELETE: delete the card from the server */
  deleteHero(cardId: string): Observable<Card> {
    const url = `${this.cardUrl}/${cardId}`;

    return this.http.delete<Card>(url, this.httpOptions).pipe(
      tap(_ => console.log(`deleted card cardId=${cardId}`)),
      catchError(this.handleError<Card>('deleteCard'))
    );
  }

  /** PUT: update the card on the server */
  updateHero(card: Card,cardId: string): Observable<any> {
    return this.http.put(`${this.cardUrl}/${cardId}`, card, this.httpOptions).pipe(
      tap(_ => console.log(`updated card cardId=${card.cardId}`)),
      catchError(this.handleError<any>('updateCard'))
    );
  }

  /** GET cards by playerId. Will 404 if id not found */
  getCardByPlayerId(playerId: string | null): Observable<Card> {
    const url = `${this.cardUrl}/player/${playerId}`;
    return this.http.get<Card>(url).pipe(
      tap(_ => console.log(`fetched card cardId=${playerId}`)),
      catchError(this.handleError<Card>(`getCardById cardId=${playerId}`))
    );
  }

  /** GET random cards. Will 404 if id not found */
  getRandomCards(numberOfCards: number | null): Observable<Card> {
    const url = `${this.cardUrl}/random/${numberOfCards}`;
    return this.http.get<Card>(url).pipe(
      tap(_ => console.log(`fetched ${numberOfCards} random cards`)),
      catchError(this.handleError<Card>(`getRandomCards numberOfCards=${numberOfCards}`))
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
