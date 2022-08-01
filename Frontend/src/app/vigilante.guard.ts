import { Injectable } from "@angular/core";
import {
	ActivatedRouteSnapshot,
	CanActivate,
	Router,
	RouterStateSnapshot,
	UrlTree,
} from "@angular/router";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VigilanteGuard implements CanActivate {
	constructor(public router: Router) {}

	canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
		| Observable<boolean | UrlTree>
		| Promise<boolean | UrlTree>
		| boolean
		| UrlTree {
		const uId = JSON.parse(sessionStorage.getItem("user")!);

		if (uId) {
			return true;
		} else {
			this.router.navigate(["/", "auth"]);
			return false;
		}
	}
}
