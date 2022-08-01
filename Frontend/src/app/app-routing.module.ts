import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { BoardComponent } from "./components/board/board.component";
import { GameComponent } from "./components/game/game.component";
import { HallComponent } from "./hall/hall.component";
import { PagenotfoundComponent } from "./pagenotfound/pagenotfound.component";
import { VigilanteGuard } from "./vigilante.guard";
import { VistaAuthComponent } from "./vista-auth/vista-auth.component";
import { VistaRegistroComponent } from "./vista-registro/vista-registro.component";

const routes: Routes = [
	{ path: "", redirectTo: "/auth", pathMatch: "full" },
	{ path: "auth", component: VistaAuthComponent },
	{ path: "register", component: VistaRegistroComponent },
	{ path: "hall", component: HallComponent, canActivate: [VigilanteGuard] },
	{ path: "board", component: BoardComponent, canActivate: [VigilanteGuard] },
	{ path: "game", component: GameComponent, canActivate: [VigilanteGuard] },
	{ path: "**", component: PagenotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
