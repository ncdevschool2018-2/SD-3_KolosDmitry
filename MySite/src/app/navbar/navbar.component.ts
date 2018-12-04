import {Component, OnInit} from '@angular/core';
import {UserIDService} from '../services/http.IDservice';
import {HttpAuthUser} from '../services/http.AuthUser';
import {LoggedUser} from '../model/LoggedUser';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private login: any;

  constructor(private userInfo: UserIDService, private logUser: LoggedUser) {
    // this.loggedUser.getLogin().subscribe(login => this.login = login);
  }

  quitclick() {
    this.userInfo.isLogged = false;
    this.userInfo.isAdmin = false;
  }

  ngOnInit() {
    // this.loggedUser.getLogin().subscribe(login => this.login = login);
    // console.log(this.login);
  }

}
