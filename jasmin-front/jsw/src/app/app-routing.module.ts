import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppjswComponent } from './components/appjsw/appjsw.component';
import { CentreListComponent } from './components/centre/centre-list/centre-list.component';
import { CentreVisualisationComponent } from './components/centre/centre-visualisation/centre-visualisation.component';
import { CentreComponent } from './components/centre/centre/centre.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { EmployeeVisualisationComponent } from './components/employee/employee-visualisation/employee-visualisation.component';
import { EmployeeComponent } from './components/employee/employee/employee.component';


const routes: Routes = [
  {path: '', redirectTo: 'jsw', pathMatch: 'full'},
  {path: 'jsw', component: AppjswComponent, children:[
    {path: '', redirectTo: 'centres', pathMatch: 'full'},
    {path: 'centres', component: CentreComponent, children:[
      {path: '', redirectTo: 'list', pathMatch: 'full'},
      {path: 'list', component: CentreListComponent},
      {path: 'visual/:id', component: CentreVisualisationComponent}
    ]},
    {path: 'employees', component: EmployeeComponent, children:[
      {path: '', redirectTo: 'list', pathMatch: 'full'},
      {path: 'list', component: EmployeeListComponent},
      {path: 'visual/:id', component: EmployeeVisualisationComponent}
    ]}
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
