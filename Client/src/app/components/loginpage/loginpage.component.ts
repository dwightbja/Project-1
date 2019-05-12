import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import {LoginpageService} from 'src/app/services/loginpage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit, OnDestroy {
  username = '';
  password = '';
  loginResponse: Subscription;
  lastStatus = 200;

  constructor(private loginpageService: LoginpageService, private router: Router) { }

  ngOnInit() {
    this.loginResponse = this.loginpageService.$loginStatus.subscribe(status => {
      // do something with status here
      if (status === 200) {
        this.router.navigateByUrl('menu');
      } else {
        // set status to lastStatus to display appripraite error mesage
        this.lastStatus = status;
      }
    });
  }

// tslint:disable-next-line: use-life-cycle-interface
  ngOnDestroy() {
    if (this.loginResponse) {
      this.loginResponse.unsubscribe();
    }
  }

  formValidation(): boolean {
    return this.username.length > 0 && this.password.length > 0;
  }

  submit() {
    this.loginpageService.login(this.username, this.password);

  }

}
