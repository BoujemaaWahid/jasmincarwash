import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppjswComponent } from './components/appjsw/appjsw.component';
import { CentreListComponent } from './components/centre/centre-list/centre-list.component';
import { CentreVisualisationComponent } from './components/centre/centre-visualisation/centre-visualisation.component';
import { CentreComponent } from './components/centre/centre/centre.component';


const routes: Routes = [
  {path: '', redirectTo: 'jsw', pathMatch: 'full'},
  {path: 'jsw', component: AppjswComponent, children:[
    {path: '', redirectTo: 'centres', pathMatch: 'full'},
    {path: 'centres', component: CentreComponent, children:[
      {path: '', redirectTo: 'list', pathMatch: 'full'},
      {path: 'list', component: CentreListComponent},
      {path: 'visual/:id', component: CentreVisualisationComponent}
    ]},
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
