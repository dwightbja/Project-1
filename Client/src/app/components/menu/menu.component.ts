import { Component, OnInit } from '@angular/core';
import {routerNgProbeToken} from '@angular/router/src/router_module';
import {Router} from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  roleID = Number(this.splitCache[1]);
  constructor(private router: Router) { }
 isRegular() {
   return this.roleID === 1;
 }

 logout() {
   sessionStorage.removeItem('cache');
   this.router.navigateByUrl('loginpage');
 }
  ngOnInit() {
    this.router.navigateByUrl('home');
  }

}
