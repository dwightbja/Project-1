import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  authorID = Number(this.splitCache[0]);
  roleID = Number(this.splitCache[1]);
  firstName = this.splitCache[2];
  lastName = this.splitCache[3];

  constructor() { }

  ngOnInit() {
  }
 
}
