import { Injectable } from "@angular/core";
import { AngularFireAuth } from "@angular/fire/compat/auth";
import {
	AngularFirestore,
	AngularFirestoreDocument,
} from "@angular/fire/compat/firestore";
import { User } from "./user";
import * as auth from "firebase/auth";
import {PlayerAPIService} from "./services/player-api.service";
import { Player } from "./interfaces/player"

import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
	userData: any; // Save logged in user data

	Players :Player[] = [];
	playerId: string = "";

	player: Player = {
			playerId : "",
				nickName : "",
				email: "",
				score: 0,

				pointsHistory: [],
				cardModels: [],
	}

	constructor(public afAuth: AngularFireAuth,
				public afs: AngularFirestore,
				public router: Router,
				public playerAPIService: PlayerAPIService,
			   ) {
			this.afAuth.authState.subscribe((user) => {
			if (user) {
				this.userData = user;
				localStorage.setItem("user", JSON.stringify(this.userData));
				localStorage.setItem("uid",this.userData.uid);
				JSON.parse(localStorage.getItem("user")!);
			} else {
				localStorage.setItem("user", "null");
				JSON.parse(localStorage.getItem("user")!);
			}
		});
	}


	/**
	 * Metodo para ingresar a al cuenta
	 * */
	SignIn(email: any, password: any) {
		return this.afAuth
			.signInWithEmailAndPassword(email, password)
			.then((result) => {
				this.SetUserData(result.user);
				this.router.navigate(['hall']);

			})
			.catch((error) => {
				window.alert(error.message);
			});
	}

	SignOut() {
		return this.afAuth.signOut().then(() => {
			window.alert("se ha cerrado la sesión");
			localStorage.clear();
			this.router.navigate(['auth']);
		});
	}

	SetUserData(user: any) {

		const userRef: AngularFirestoreDocument<any> = this.afs.doc(
			`users/${user.uid}`,
		);
		const userData: User = {
			uid: user.uid,
			email: user.email,
			displayName: user.displayName,
			photoURL: user.photoURL,
			emailVerified: user.emailVerified,
		};
		return userRef.set(userData, {
			merge: true,
		});
	}

	AuthLogin(provider: any) {
		return this.afAuth
			.signInWithPopup(provider)
			.then((result) => {
				this.SetUserData(result.user);
			})
			.catch((error) => {
				window.alert(error);
			});
	}

	/**
	 * Incripcion
	 * */
	SignUp(email: string, password: string) {
		return this.afAuth
			.createUserWithEmailAndPassword(email, password)
			.then((result) => {
				/* Call the SendVerificaitonMail() function when new user sign
				up and returns promise */

				this.SetUserData(result.user);

				this.player.playerId = result.user?.uid || " ";
				this.player.email = email;

				this.playerAPIService.addPlayer(this.player)
					.subscribe(playerNew => this.Players.push(playerNew));

				this.router.navigate(['hall']);

			})
			.catch((error) => {
				window.alert(error.message);
			});
	}

	GoogleAuth() {
		return this.AuthLogin(new auth.GoogleAuthProvider()).then((res: any) => {

			this.router.navigate(['hall']);

		});
	}
}
