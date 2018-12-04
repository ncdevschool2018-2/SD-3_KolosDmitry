import {Component, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';
import {LoggedUser} from '../model/LoggedUser';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  @ViewChild('addBalance') addBalance;
  modalRef: BsModalRef;

  constructor(private ModalService: BsModalService, private userInfo: UserIDService, private logUser: LoggedUser) { }

  showModal() {
    this.modalRef = this.ModalService.show(this.addBalance);
  }

  plusBalance($event): void {
    this.logUser.setBalance((this.logUser.getBalance()) + +$event);
    // this.userInfo.balance = +this.userInfo.balance + +$event;
  }

}
