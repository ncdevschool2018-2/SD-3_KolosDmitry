import {Injectable} from '@angular/core';
import {UserModel} from './UserModel';

@Injectable({
  providedIn: 'root'
})
export class LoggedUser {
  private user: UserModel;

  getId() {
    return this.user.id;
  }

  getUser() {
    return this.user;
  }

  setUser(user: UserModel) {
    this.user = user;
  }

  getLogin() {
    return this.user.login;
  }

  getBalance() {
    return this.user.balance;
  }

  setBalance(balance: any) {
    this.user.balance = balance;
  }
}
