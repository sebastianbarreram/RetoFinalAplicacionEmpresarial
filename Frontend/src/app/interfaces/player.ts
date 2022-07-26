import { Card } from "./card";

export interface Player{
  playerId: string | null;
  nickName: string;
  email: string;
  score: number;

  pointsHistory: number[];
  cardModels: Card[];
}
