import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { AngularFireAuthModule } from "@angular/fire/compat/auth";
import { ListGamesComponent } from './list-games/list-games.component';
import { CarouselComponent } from './carousel/carousel.component';

@NgModule({
  declarations: [
    HeaderComponent,
    ListGamesComponent,
    CarouselComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    AngularFireAuthModule
  ],
  exports: [
    HeaderComponent,
    CarouselComponent,
    ListGamesComponent
  ]
})

export class ComponentsModule { }
