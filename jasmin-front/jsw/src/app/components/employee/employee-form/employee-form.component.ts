import { CentreBasicModel } from './../../../models/CentreBasicModel';
import { Component, OnInit, Inject } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EmployeeModel } from 'src/app/models/EmployeeModel';
import { CentreService } from '../../centre/service/centre.service';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {
  active = [
    {view: 'Active', value: true},
    {view: 'Non active', value: false}
  ]
  centres = [] as any
  employeeForm = new FormGroup({
    nom: new FormControl('NOM'),
    prenom: new FormControl('PRENOM'),
    active: new FormControl(true),
    type: new FormControl('RES'),
    telephone: new FormControl('TEL'),
    email: new FormControl('EMAIL'),
    assume: new FormControl()
  })
  
  constructor(
    public dialogRef: MatDialogRef<EmployeeFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private centreService: CentreService,
    private service: EmployeeService
  ) { 
  }

  ngOnInit(): void {
    this.centreService.withNoneResponsable().subscribe(res=> this.centres = res)
  }
  formatMsg(value: number){
    let t = this.centresValue.length > 1 ? `(+${this.centresValue.length - 1} autres)` : ''
    let r: any;
    if( this.centresValue.length )
      r = this.centres.filter((e: any)=>e.value == this.centresValue[0])[0]
    return r?.view+' '+t
  }
  employeeEnregistre(){
    let val = this.employeeForm.value
    if( val.assume )
      val['assume'] = val['assume'].map((e: any)=>{ return {id: e} })
    let r = val as EmployeeModel
    this.service.save(r).subscribe(res=> this.dialogRef.close())
  }

  get centresValue(): Array<any>{
    return this.employeeForm.get('assume')?.value || []
  }
}
