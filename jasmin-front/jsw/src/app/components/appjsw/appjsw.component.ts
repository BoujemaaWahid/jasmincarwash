import { Component, OnInit } from '@angular/core';
import { MatDrawerMode } from '@angular/material/sidenav';

@Component({
  selector: 'app-appjsw',
  templateUrl: './appjsw.component.html',
  styleUrls: ['./appjsw.component.scss']
})
export class AppjswComponent implements OnInit {
  toggleSideNav = true
  navmode: MatDrawerMode = "side"
  
  constructor() { }

  ngOnInit(): void {
  }

}
