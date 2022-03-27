import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { EmployeeService } from '../service/employee.service';
import { EmployeeModel } from 'src/app/models/EmployeeModel';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  employees !: Array<EmployeeModel>
  constructor(
    public dialog: MatDialog,
    private service: EmployeeService
  ) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(res => this.employees = res)
  }


  openDialog(): void {
    const dialogRef = this.dialog.open(EmployeeFormComponent, {
      width: '800px',
      data: {  id: null },
      panelClass: ['animate__animated','animate__fadeIn']
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}
