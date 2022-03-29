import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { EmployeeModel } from 'src/app/models/EmployeeModel';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-visualisation',
  templateUrl: './employee-visualisation.component.html',
  styleUrls: ['./employee-visualisation.component.scss']
})
export class EmployeeVisualisationComponent implements OnInit {

  model !: EmployeeModel
  constructor(private service: EmployeeService, private dialog: MatDialog, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id']
    this.service.findOne( parseInt(id) ).subscribe(res=>{
      this.model = res
      console.log( res )
    })
  }

  openDialog(){
    let id = this.route.snapshot.params['id']
    const dialogRef = this.dialog.open(EmployeeFormComponent, {
      width: '800px',
      data: {  id: parseInt(id) },
      panelClass: ['animate__animated','animate__fadeIn']
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}
