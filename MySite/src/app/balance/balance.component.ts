import {Component, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {UserIDService} from '../services/http.IDservice';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  @ViewChild('addBalance') addBalance;
  modalRef: BsModalRef;

  constructor(private ModalService: BsModalService, private userInfo: UserIDService) { }

  showModal() {
    this.modalRef = this.ModalService.show(this.addBalance);
  }

  plusBalance($event): void {
    this.userInfo.balance = +this.userInfo.balance + +$event;
  }

}
