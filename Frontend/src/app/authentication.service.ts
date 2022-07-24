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

	//------------------------------------------------
	// authUrl = "http://localhost:5000/api/auth/";
	// employersUrl = "http://localhost:5000/api/employers/";
	// confirmEmailUrl = "http://localhost:4200/confirm-email/";
	// changePasswordUrl = "http://localhost:4200/change-password/";
	// decodedToken: any;
	// currentUser!: User;

	player: Player = {
			playerId : "",
				nickName : 0,
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
				JSON.parse(localStorage.getItem("user")!);
			} else {
				localStorage.setItem("user", "null");
				JSON.parse(localStorage.getItem("user")!);
			}
		});
	}



	SignIn(email: any, password: any) {
		return this.afAuth
			.signInWithEmailAndPassword(email, password)
			.then((result) => {
				console.log(result);
				this.SetUserData(result.user);
				//localStorage.setItem("uid",JSON.stringify(result.user.uid||""));
			if(result.user){	
			this.player.playerId= result.user.uid;
			this.player.email = email;
		    this.playerAPIService.addPlayer(this.player);
		}
			
			this.router.navigate(['hall']);



			})
			.catch((error) => {
				window.alert(error.message);
			});
	}

	SignOut() {
		return this.afAuth.signOut().then(() => {
			window.alert("se ha cerrado la sesión");
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

	SignUp(email: string, password: string) {
		return this.afAuth
			.createUserWithEmailAndPassword(email, password)
			.then((result) => {
				/* Call the SendVerificaitonMail() function when new user sign
        up and returns promise */
				this.SetUserData(result.user);
			})
			.catch((error) => {
				window.alert(error.message);
			});
	}

	GoogleAuth() {
		return this.AuthLogin(new auth.GoogleAuthProvider()).then((res: any) => {
			if (res) {
			}
				this.router.navigate(['hall']);
		});
	}
}
