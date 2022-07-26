import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { BoardComponent } from "./components/board/board.component";
import { GameComponent } from "./components/game/game.component";
import { HallComponent } from "./hall/hall.component";
import { VistaAuthComponent } from "./vista-auth/vista-auth.component";
import { VistaRegistroComponent } from "./vista-registro/vista-registro.component";

const routes: Routes = [
	{ path: "", redirectTo: "/auth", pathMatch: "full" },
	{ path: "auth", component: VistaAuthComponent },
	{ path: "register", component: VistaRegistroComponent },
	{path: "hall", component: HallComponent},
	{path: "board", component: BoardComponent},
	{path: "game", component:GameComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
