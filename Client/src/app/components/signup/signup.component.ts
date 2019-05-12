import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  username = '';
  password = '';
  passwordConfirmation = '';
  loginAttemptSucceeded = undefined;

  // Using dependency injection to get reference of the SignupService
  constructor(private signupService: SignupService) { }

  ngOnInit() {
  }

  formValidation(): boolean {
    this.usernameTrim();
    return this.passwordLengthValidation() &&
            this.passwordsMatch() &&
            this.usernameLengthValidation();
  }

  passwordLengthValidation(): boolean {
    return this.password.length >= 8;
  }

  passwordsMatch(): boolean {
    return this.password === this.passwordConfirmation;
  }

  usernameLengthValidation(): boolean {
    return this.username.length >= 1;
  }

  usernameTrim(): void {
    this.username = this.username.trim();
  }

  submit() {
    // call the signupService signup method
    this.signupService.signup(this.username, this.password).subscribe( result => {
      this.loginAttemptSucceeded = true;
    }, error => {
      this.loginAttemptSucceeded = false;
    });
  }

}
