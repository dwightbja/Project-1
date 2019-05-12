import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbService {
  private createStatusSubject = new Subject<number>();
  public $createStatus = this.createStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }
  savereimb(amount: number, status: number, description: string, receipt: any, authorID: number) {
    const payload = {
      reimbursementAmount: amount,
      reimbursementAuthorID: authorID,
      reimbursementDescription: description,
      reimbursementTypeID: status,
      reimbursementReceipt: receipt
    };
    this.httpClient.post('http://localhost:8080/ers/savereimb', payload, {
      observe: 'response'
    })
    .subscribe(response => {
      this.createStatusSubject.next(200);
    }, err => {
      this.createStatusSubject.next(err.status);
    });
  }
}
