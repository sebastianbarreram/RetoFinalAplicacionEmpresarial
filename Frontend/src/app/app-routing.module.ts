import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { BoardComponent } from "./components/board/board.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { HallComponent } from "./hall/hall.component";
import { HeroDetailComponent } from "./hero-detail/hero-detail.component";
import { HeroesComponent } from "./heroes/heroes.component";
import { VistaAuthComponent } from "./vista-auth/vista-auth.component";
import { VistaRegistroComponent } from "./vista-registro/vista-registro.component";

const routes: Routes = [
	{ path: "", redirectTo: "/auth", pathMatch: "full" },
	{ path: "dashboard", component: DashboardComponent },
	{ path: "detail/:id", component: HeroDetailComponent },
	{ path: "heroes", component: HeroesComponent },
	{ path: "auth", component: VistaAuthComponent },
	{ path: "register", component: VistaRegistroComponent },
	{path: "hall", component: HallComponent},
	{path: "board", component: BoardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
