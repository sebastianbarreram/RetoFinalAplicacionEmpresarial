import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Card } from '../interfaces/card';

@Injectable({
  providedIn: 'root'
})
export class CardGameAPIService {
  private cardUrl = 'cards/';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { 
    /** GET cards from the server */
  getCards(): Observable<Card[]> {
    return this.http.get<Card[]>(this.cardUrl)
      .pipe(
        tap(_ => console.log('fetched cards')),
        catchError(this.handleError<Card[]>('getCards', []))
      );
  }
  }
}
