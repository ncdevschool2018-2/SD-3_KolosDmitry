import {Component, OnChanges} from '@angular/core';
import {UserIDService} from './services/http.IDservice';
import {HttpService} from './services/http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent implements OnChanges {
  isLogged = this.userInfo.isLogged;
  isAdmin = this.userInfo.isAdmin;
  // login = this.userInfo.login;
  // password = this.userInfo.password;
  title = 'MySite';
  login = 'dimas';
  password = '12345';
  private logged: boolean;

  constructor(private userInfo: UserIDService, private http: HttpService) {
  }

  adminclick() {
    this.userInfo.isAdmin = true;
    this.userInfo.isLogged = true;
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }

  userclick() {
    this.http.authUser(this.login, this.password).subscribe((logged) => {
      this.logged = logged;
      this.refresh(logged);
      this.userInfo.isLogged = logged;
      this.isLogged = this.userInfo.isLogged;
    });
    console.log(this.logged);
    // if (this.logged) {
    //   this.userInfo.isLogged = true;
    //   this.isLogged = this.userInfo.isLogged;
    // }
  }

  registerclick() {
    this.http.authUser(this.login, this.password).subscribe((logged) => {
      this.logged = logged;
      this.refresh(logged);
    });
    if (this.logged) {
      this.userInfo.isLogged = true;
      this.isLogged = this.userInfo.isLogged;
    }
  }

  refresh(logged) {
    this.logged = logged;
    this.userInfo.isLogged = this.logged;
    this.isLogged = this.userInfo.isLogged;
  }

  ngOnChanges() {
    this.isLogged = this.userInfo.isLogged;
    this.isAdmin = this.userInfo.isAdmin;
  }
}
