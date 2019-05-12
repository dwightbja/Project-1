import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpClient: HttpClient) { }

  signup(username: string, password: string): Observable<any> {
    const payload = {
      username: username,
      password: password
    };
    return this.httpClient.post('http://localhost:8080/ChatApp/signup', payload)
  }
}
