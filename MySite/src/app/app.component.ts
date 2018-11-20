import {Component, OnChanges} from '@angular/core';
import {UserIDService} from './services/http.IDservice';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent implements OnChanges {
  isLogged = this.userInfo.isLogged;
  isAdmin = this.userInfo.isAdmin;
  login = this.userInfo.login;
  password = this.userInfo.password;
  title = 'MySite';

  constructor(private userInfo: UserIDService) {
  }

  adminclick() {
    this.userInfo.isAdmin = true;
    this.userInfo.isLogged = true;
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }

  userclick() {
    this.userInfo.isLogged = true;
    this.isLogged = this.userInfo.isLogged;
  }

  registerclick() {
    this.userInfo.isLogged = true;
    this.isLogged = this.userInfo.isLogged;
  }

  ngOnChanges() {
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }
}
