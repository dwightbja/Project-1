import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Subject, Observable } from 'rxjs';
import { ReimbList } from './models/reimblist';
import { map } from 'rxjs/operators';
import { elementEnd } from '@angular/core/src/render3';

@Injectable({
  providedIn: 'root'
})
export class ResolvereimbService {
  private resolveStatusSubject = new Subject<number>();
  public $resolveStatus = this.resolveStatusSubject.asObservable();
  public reimb = new Array <ReimbList>();

  constructor(private httpClient: HttpClient) { }

  getReimb(authorID: number, roleID: number) {
    const payload = {
      ersUserID: authorID,
      userRoleID: roleID
    };
    this.httpClient.post('http://localhost:8080/ers/resolvereimb', payload, {
    observe: 'response'
  }).pipe(map(response => response.body as Array <ReimbList>)
  ).subscribe(response => {
    this.resolveStatusSubject.next(200);
    response.forEach(element => {
      if (element.reimbursementStatusID === 1 && element.reimbursementAuthorID!=authorID ) {
      this.reimb.push(element);
      }
    });
  }, err => {
    this.resolveStatusSubject.next(err.status);
  });
  }

  resolve( authorID: number, reimbID: number, statusID: number){
    const payload = {
      reimbursementResolverID: authorID,
      reimbursementID: reimbID,
      reimbursementStatusID: statusID
    };
    this.httpClient.put('http://localhost:8080/ers/resolvereimb', payload, {
      observe: 'response'
  }).subscribe(response => {
    this.resolveStatusSubject.next(200);
  }, err => {
    this.resolveStatusSubject.next(err.status);
  });
}
}
