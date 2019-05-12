import { Component, OnInit } from '@angular/core';
import {ReimbService} from 'src/app/services/reimb.service';
import { Subscription } from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-reimb',
  templateUrl: './reimb.component.html',
  styleUrls: ['./reimb.component.css']
})
export class ReimbComponent implements OnInit {
constructor(private reimbService: ReimbService) { }


amount = 0;
status = 0;
description = '';
receipt: any;
splitCache = sessionStorage.getItem('cache').split(' ');
authorID = Number(this.splitCache[0]);
response: Subscription;
lastStatus = 200;


  ngOnInit() {
    this.response = this.reimbService.$createStatus.subscribe(status => {
      if (status === 200) {
        alert('Request submitted');
      } else {
        this.lastStatus = status;
      }
});
  }

  ngOnDestroy () {
    if (this.response) {
      this.response.unsubscribe();
    }
  }
submit() {
  this.reimbService.savereimb(this.amount, this.status, this.description, this.receipt, this.authorID);
  }
}