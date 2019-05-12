import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { ChatComponent } from './components/chat/chat.component';
import { SignupService } from './services/signup.service';
import { FormsModule } from '@angular/forms';
import { TrimPipePipe } from './pipes/trim-pipe.pipe';
import { HttpClientModule } from '@angular/common/http';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import { ViewreimbComponent } from './components/viewreimb/viewreimb.component';
import { ReimbService } from './services/reimb.service';
import { MenuComponent } from './components/menu/menu.component';
import { ResolvereimbComponent } from './components/resolvereimb/resolvereimb.component';
import { HomeComponent } from './components/home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    ChatComponent,
    TrimPipePipe,
    LoginpageComponent,
    ReimbComponent,
    ViewreimbComponent,
    MenuComponent,
    ResolvereimbComponent,
    HomeComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SignupService,
    ReimbService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
