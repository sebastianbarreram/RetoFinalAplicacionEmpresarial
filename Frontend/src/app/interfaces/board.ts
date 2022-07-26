import { Card } from "./card";
import { Player } from "./player";

export interface Board {
  id: string;
  time: number;
  listWinRound:string[];
  listCard: Card[];
  listplayer:Player[];
  idPlayers: string[];
}
