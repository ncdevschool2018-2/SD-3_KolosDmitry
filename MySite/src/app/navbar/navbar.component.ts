import {Component, OnInit} from '@angular/core';
import {UserIDService} from '../services/http.IDservice';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private userInfo: UserIDService) { }

  quitclick() {
    this.userInfo.isLogged = false;
    this.userInfo.isAdmin = false;
  }

  ngOnInit() {
  }

}
