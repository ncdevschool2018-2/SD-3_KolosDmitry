import {Component, OnInit} from '@angular/core';
import {HttpService} from '../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';


@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {
  public subscriptions: any[];
  public formatter: boolean;
  public search = '';

  constructor(private http: HttpService, private userInfo: UserIDService) {
    http.getSubscriptions()
      .subscribe(subscriptions => this.subscriptions = subscriptions);
    this.formatter = null;
  }

  filter(data: Array<any>): Array<any> {
    return data.filter((sub) => {
      return (sub['name'] as string).includes(this.search);
    });
  }

  ngOnInit() {
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

  contains(arr: any[], elem: any): boolean {
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === elem.name) {
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

  subscribeClick(subscription) {
    subscription.subscribe = false;
    this.userInfo.subscriptions.push(subscription.name);
    this.userInfo.balance = this.userInfo.balance - subscription.cost;
    subscription.subscribers++;
  }

  unsubscribeClick(elem, arr) {
    const index = arr.indexOf(elem.name);
    arr.splice(index, 1);
    elem.subscribers--;
  }
}
