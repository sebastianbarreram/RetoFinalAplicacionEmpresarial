import { Card } from "./card";
import { Player } from "./player";

export interface Board {
  id: string;
  time: number;
  listWindRound:string[];
  listCard: Card[];
  listPlayer:Player[];
  idplayers: string[];
}
