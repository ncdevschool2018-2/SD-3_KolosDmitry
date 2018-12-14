import {Component, OnChanges, OnInit} from '@angular/core';
import {HttpService} from '../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';
import {LoggedUser} from '../model/LoggedUser';


@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnChanges {
  public subscriptions: any[];
  public formatter: boolean;
  public search = '';

  constructor(private http: HttpService, private userInfo: UserIDService, private logUser: LoggedUser) {
    http.getSubscriptions()
      .subscribe(subscriptions => this.subscriptions = subscriptions);
    console.log(this.subscriptions);
    this.formatter = null;
  }

  filter(data: Array<any>): Array<any> {
    return data.filter((sub) => {
      return (sub['name'] as string).includes(this.search);
    });
  }

  ngOnChanges() {
    for (let j = 0; j < this.subscriptions.length; j++) {
      for (let i = 0; i < this.logUser.getSubscriptions().length; i++) {
        if (this.logUser.getSubscriptions()[i].name === this.subscriptions[j].name) {
          this.subscriptions[j].subscribe = true;
        } else {
          this.subscriptions[j].subscribe = false;
        }
      }
    }
  }

  showSubscribed(): void {
    this.http.getSubscriptions().subscribe((data: Array<any>) => {
      this.subscriptions = data.filter((value: any) => {
          return value['subscribe'] === false;
        }
      );
    });
  }

  showUnsubscribed() {
    this.http.getSubscriptions().subscribe((data: Array<any>) => {
      this.subscriptions = data.filter((value: any) => {
          return value['subscribe'];
        }
      );
    });
  }

  showAll() {
    this.http.getSubscriptions().subscribe((data: Array<any>) => {
      this.subscriptions = data;
    });
  }

  contains(userSubs: any[], elem: any): boolean {
    for (let i = 0; i < userSubs.length; i++) {
      if (userSubs[i].name === elem.name) {
        return true;
      }
    }
    return false;
    // const num = arr.indexOf(elem);
    // if (num === -1) {
    //   return false;
    // } else {
    //   return true;
    // }
  }

  checkSolvency(subscription: any): boolean {
    console.log(subscription.cost);
    console.log(this.logUser.getBalance());
    return this.logUser.getBalance() <= subscription.cost;
  }

  subscribeClick(subscription) {
    subscription.subscribe = false;
    this.logUser.setBalance(+this.logUser.getBalance()  - +subscription.cost);
    this.http.subscribeUser(this.logUser.getUser(), subscription.idsubscription)
      .subscribe(user => {
        this.logUser.setUser(user);
        console.log(this.logUser.getUser());
        console.log(this.logUser.getSubscriptions());
        subscription.subscribe = false;
      });

    this.userInfo.subscriptions.push(subscription.name);

    subscription.subscribers++;
  }

  unsubscribeClick(subscription, arr) {
    const index = arr.indexOf(subscription.name);
    arr.splice(index, 1);
    this.http.unsubscribeUser(this.logUser.getUser(), subscription.idsubscription)
      .subscribe(user => {
        this.logUser.setUser(user);
        console.log(this.logUser.getUser());
        console.log(this.logUser.getSubscriptions());
        subscription.subscribe = true;
      });
  }
}
