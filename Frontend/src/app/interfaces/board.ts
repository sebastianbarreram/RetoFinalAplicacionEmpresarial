import { Card } from "./card";
import { Player } from "./player";

export interface Board {
  id: string;
  time: number;
  listCard: Card[];
  idplayers: string[];
}
