import { Card } from './card';
import { Player } from './player';

export interface Game{
    id:string,
    numberPlayers:number,
    playerModelList:Player[],
    cardGamesList:Card[];
}