import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { ChatComponent } from './components/chat/chat.component';
import {LoginpageComponent} from './components/loginpage/loginpage.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import { MenuComponent } from './components/menu/menu.component';
import { ViewreimbComponent } from './components/viewreimb/viewreimb.component';
import { ResolvereimbComponent } from './components/resolvereimb/resolvereimb.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
   path: 'loginpage',
   component: LoginpageComponent

  }, {
    path: 'menu',
    component: MenuComponent,
     children: [
       {
         path: 'home',
         component: HomeComponent
       },
       {
        path: 'reimb',
        component: ReimbComponent
       },
       {
         path: 'viewreimb',
         component: ViewreimbComponent
       },
       {
         path: 'resolvereimb',
         component: ResolvereimbComponent
       }
     ]
  }, {
    path: '',
    component: LoginpageComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
