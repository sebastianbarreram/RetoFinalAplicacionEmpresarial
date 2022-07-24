import { Component, OnInit } from "@angular/core";
import { AuthenticationService } from "../authentication.service";

@Component({
  selector: 'app-vista-registro',
  templateUrl: './vista-registro.component.html',
  styleUrls: ['./vista-registro.component.css']
})
export class VistaRegistroComponent implements OnInit {
	constructor(public authService: AuthenticationService) {}

	ngOnInit(): void {}
}
