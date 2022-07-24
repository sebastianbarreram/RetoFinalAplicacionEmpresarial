import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from "../../authentication.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  DATA = {
    "backgroundColor": "#ffffff",
    "colorText": "#072457",
    "displayCart": 1,
    "displayWishList": 1,
  }

  statusToShow = {
    activeMenuMobileState: "",
    activeWishListState: "",
    activeCartState: "",
  }

  ITEMS_MENU = [{
    'id': 1,
    "name": "Principal",
    "url": "https://www.google.com.pe/",
    "subMenu": [],
    "subMenuQuantity": 0,
  }, {
    'id': 2,
    "name": "Contactanos",
    "url": "https://www.google.com.pe/",
    "subMenu": [],
    "subMenuQuantity": 0,
  }, {
    'id': 3,
    "name": "Servicios",
    "url": "https://www.google.com.pe/",
    "subMenu": [{
      'id': 4,
      "name": "Páginas web",
      "url": "https://www.google.com.pe/",
      "subMenu": [],
      "subMenuQuantity": 0,
    }, {
      'id': 5,
      "name": "Sistemas web",
      "url": "https://www.google.com.pe/",
      "subMenu": [],
      "subMenuQuantity": 0,
    }],
    "subMenuQuantity": 2,
  }];

  constructor(public authenticationService: AuthenticationService) {}


  ngOnInit(): void {
  }

  toggleActiveMenuMobileState() {
    if (this.statusToShow.activeMenuMobileState == "active-menuMobile-overlay") {
      this.statusToShow.activeMenuMobileState = "";
      return
    }
    if (this.statusToShow.activeMenuMobileState == "") {
      this.statusToShow.activeMenuMobileState = "active-menuMobile-overlay";
      return
    }
  }

  toggleSubMenus(id: number) {
    const box = document.getElementById("boxSubMenuOfMenu_" + id);
    if (box) {
      if (box.style.display == "block") {
        box.style.display = 'none';
      } else {
        box.style.display = 'block';
      }
    }
  }

}
