import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";

import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
import { HttpClientModule } from "@angular/common/http";
import { VistaAuthComponent } from "./vista-auth/vista-auth.component";
import { AngularFireModule } from "@angular/fire/compat";
import { environment } from "src/environments/environment";
import { AngularFireAuthModule } from "@angular/fire/compat/auth";
import { AngularFirestoreModule } from "@angular/fire/compat/firestore";
import { VistaRegistroComponent } from "./vista-registro/vista-registro.component";
import { HallComponent } from "./hall/hall.component";

import { ComponentsModule } from "./components/components.module";
import { BoardComponent } from './components/board/board.component';
import { GameComponent } from './components/game/game.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    VistaAuthComponent,
    VistaRegistroComponent,
    HallComponent,
    BoardComponent,
    GameComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireAuthModule,
    AngularFirestoreModule,
    ComponentsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
