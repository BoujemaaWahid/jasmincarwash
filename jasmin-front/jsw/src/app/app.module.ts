import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';
import { AppjswComponent } from './components/appjsw/appjsw.component';
import { CentreComponent } from './components/centre/centre//centre.component';
import {MatCardModule} from '@angular/material/card';
import { CentreFormComponent } from './components/centre/centre-form/centre-form.component';
import {MatDialogModule} from '@angular/material/dialog';
import {NgxMatTimepickerModule} from 'ngx-mat-timepicker';
import {MatSelectModule} from '@angular/material/select';
import { CentreVisualisationComponent } from './components/centre/centre-visualisation/centre-visualisation.component';
import { CentreListComponent } from './components/centre/centre-list/centre-list.component';
import { NgApexchartsModule } from 'ng-apexcharts';
import { CentrePlanningComponent } from './components/centre/centre-planning/centre-planning.component';
import { CentreOldChartComponent } from './components/centre/centre-old-chart/centre-old-chart.component';
import { CentreActualChartComponent } from './components/centre/centre-actual-chart/centre-actual-chart.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeComponent } from './components/employee/employee/employee.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { EmployeeFormComponent } from './components/employee/employee-form/employee-form.component';
import { EmployeeVisualisationComponent } from './components/employee/employee-visualisation/employee-visualisation.component';

@NgModule({
  declarations: [
    AppComponent,
    AppjswComponent,
    CentreComponent,
    CentreFormComponent,
    CentreVisualisationComponent,
    CentreListComponent,
    CentrePlanningComponent,
    CentreOldChartComponent,
    CentreActualChartComponent,
    EmployeeComponent,
    EmployeeListComponent,
    EmployeeFormComponent,
    EmployeeVisualisationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatDividerModule,
    MatCardModule,
    MatDialogModule,
    NgxMatTimepickerModule,
    MatSelectModule,
    NgApexchartsModule,
    FormsModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
