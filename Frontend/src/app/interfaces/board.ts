import { Card } from "./card";
import { Player } from "./player";

export interface Board {
  id: string;
  time: Date;

  listCard: Card[];
  listplayer: Player[];
}
