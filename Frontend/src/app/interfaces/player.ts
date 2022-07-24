import { Card } from "./card";

export interface Player{
  playerId: string | null;
  nickName: number;
  email: string;
  score: number;

  pointsHistory: number[];
  cardModels: Card[];
}
