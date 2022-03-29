import { CentreBasicModel } from './../../../models/CentreBasicModel';
import { Component, OnInit, Inject } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EmployeeModel } from 'src/app/models/EmployeeModel';
import { CentreService } from '../../centre/service/centre.service';
import { EmployeeService } from '../service/employee.service';
import { forkJoin } from 'rxjs';

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
    id: new FormControl(),
    nom: new FormControl(),
    prenom: new FormControl(),
    active: new FormControl(true),
    type: new FormControl(),
    telephone: new FormControl(),
    email: new FormControl(),
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
    let id = this.data.id
    if( id ){
      forkJoin({
        centres: this.centreService.withNoneResponsable(),
        model: this.service.findOne(parseInt(id))}).subscribe(res=>{
          this.centres = res.centres
          let assume = res.model?.assume?.map(e=>e.id)
          res.model?.assume?.forEach(e=>{
            this.centres.push({value: e.id, view: e.label})
          })
          this.employeeForm.patchValue(res.model)
          this.employeeForm.patchValue({assume})
          
        })
  //    this.centreService.withNoneResponsable().subscribe(res=> this.centres = res)
    }
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
    if(!this.data.id)
      this.service.save(r).subscribe(res=> this.dialogRef.close())
    else
      this.service.update(r).subscribe(res=> this.dialogRef.close())
  }

  get centresValue(): Array<any>{
    return this.employeeForm.get('assume')?.value || []
  }
}
