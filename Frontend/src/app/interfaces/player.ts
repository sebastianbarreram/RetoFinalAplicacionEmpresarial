import { Card } from "./card";

export interface Player{
  playerId: string;
  nickName: number;
  email: string;
  score: string;

  pointsHistory: number[];
  cardModels: Card[];
}
