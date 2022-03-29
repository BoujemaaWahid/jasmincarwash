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
  links=[
    {link: '/jsw/dashboard', label: 'Dashboard', icon: 'dashboard'},
    {link: '/jsw/centres', label: 'Centres', icon:'business'},
    {link: '/jsw/journees', label: 'Jours', icon: 'event'},
    {link: '/jsw/employees', label: 'Employees', icon:'groups'},
    {link: '/jsw/vehicules', label: 'Vehicules', icon: 'directions_car'},
    {link: '/jsw/formules', label: 'Formules', icon: 'assignment'},
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
