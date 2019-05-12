import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Observable, Subject} from 'rxjs';
import {ReimbList} from 'src/app/models/reimblist';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-viewreimb',
  templateUrl: './viewreimb.component.html',
  styleUrls: ['./viewreimb.component.css']
})
export class ViewreimbComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

private viewStatusSubject = new Subject<number>();
public $viewStatus = this.viewStatusSubject.asObservable();
splitCache = sessionStorage.getItem('cache').split(' ');
authorID = Number(this.splitCache[0]);
roleID = Number(this.splitCache[1]);
lastStatus = 200;
reimblist = Array<ReimbList>();
response: Subscription;

  ngOnInit() {
this.getReimb(this.authorID, this.roleID);

this.response = this.$viewStatus.subscribe(status => {
  if (status === 200) {
  } else {
    this.lastStatus = status;
  }
});
  }

  ngOnDestroy() {
    if (this.response) {
      this.response.unsubscribe();
    }
}
  getReimb(authorID: number, roleID: number) {
    const payload = {
     ersUserID : authorID,
     userRoleID: roleID
};
this.httpClient.post('http://localhost:8080/ers/getreimb', payload, {
  observe: 'response'
}).pipe(map(response => response.body as Array <ReimbList>)
).subscribe(response => {
  this.viewStatusSubject.next(200);
  response.forEach(element => {
    this.reimblist.push(element);
  });

}, err => {
  this.viewStatusSubject.next(err.status);
});
}
}
