import { Component, OnInit } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ReimbList } from 'src/app/models/reimblist';
import { ResolvereimbService} from 'src/app/resolvereimb.service';



@Component({
  selector: 'app-resolvereimb',
  templateUrl: './resolvereimb.component.html',
  styleUrls: ['./resolvereimb.component.css']
})
export class ResolvereimbComponent implements OnInit {



  private viewStatusSubject = new Subject<number>();
  public $viewStatus = this.viewStatusSubject.asObservable();
  splitCache = sessionStorage.getItem('cache').split(' ');
  authorID = Number(this.splitCache[0]);
  roleID = Number(this.splitCache[1]);
  lastStatus = 200;
  reimblist = new Array<ReimbList>();
  response: Subscription;
  statusID = 0;

  constructor(private reimbResolveService: ResolvereimbService ) { }

  ngOnInit() {
    this.reimbResolveService.reimb.length = 0;
    this.reimbResolveService.getReimb(this.authorID, this.roleID);
    this.response = this.$viewStatus.subscribe(status => {
      if (status === 200) {
        alert('Reimbursement Resolved');
      } else {
        this.lastStatus = status;
      }
    });
    this.reimblist = this.reimbResolveService.reimb;
  }

  ngOnDestroy() {
    if(this.response) {
      this.response.unsubscribe();
    }
  }
  resolve(reimbursementID, statusID) {
    alert(`ID: ${reimbursementID} Reimbursement Resolved`);
    this.reimbResolveService.resolve(this.authorID, reimbursementID, statusID);
    for (let i = 0; i < this.reimbResolveService.reimb.length; i++) {
      if (this.reimbResolveService.reimb[i].reimbursementID === reimbursementID) {
        this.reimbResolveService.reimb.splice(i, 1);
        break;
      }
    }
  }
 ifIsEmpty() {
  this.reimblist.length === 0;
 }
}

