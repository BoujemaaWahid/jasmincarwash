import { AfterViewInit, ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { CentreModel } from 'src/app/models/CentreModel';
import { CentreService } from '../service/centre.service';
import { EmployeeService } from '../../employee/service/employee.service';
import { EmployeeModel } from 'src/app/models/EmployeeModel';
import { forkJoin } from 'rxjs';
export interface ViewValue{
  value: number|null;
  view: string;
}
@Component({
  selector: 'app-centre-form',
  templateUrl: './centre-form.component.html',
  styleUrls: ['./centre-form.component.scss']
})
export class CentreFormComponent implements OnInit, AfterViewInit {
  foods = [
    {value: {id: 1}, view: 'Steak'},
    {value: {id: 2}, view: 'Pizza'},
    {value: {id: 3}, view: 'Tacos'},
  ];
  selected = {id: 1}
  centre !: CentreModel
  
  public centreForm = new FormGroup({
    id: new FormControl(null),
    label: new FormControl(),
    ouverture: new FormControl(),
    fermeture: new FormControl(),
    adresse: new FormControl(),
    telephone: new FormControl(),
    code: new FormControl(),
    responsable: new FormControl(-1),
    formule: new FormControl(),
    croissancemp: new FormControl(0)
  })
  responsables  = new Array<ViewValue>()
  constructor(
    public dialogRef: MatDialogRef<CentreFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private service: CentreService,
    private empservice: EmployeeService
    ) { }

  ngAfterViewInit(): void {
  
  }

  ngOnInit(): void {
    let id = parseInt( this.data.id )
    this.responsables.push({value: -1, view: 'Aucun'})
    if( id ){
      forkJoin({center: this.service.findById(id), emps: this.empservice.findAll()}).subscribe(res=>{
        res.emps.forEach(e=>{
          this.responsables.push({value: e.id || 0, view: e.prenom+' '+e.nom})
        })
        res.center.ouverture = res.center.ouverture?.split(":").slice(0, 2).join(":")
        res.center.fermeture = res.center.fermeture?.split(":").slice(0, 2).join(":")
        this.centreForm.patchValue(res.center, {emitEvent: false})
        if( res.center.responsable != null ){
          let i = res.center.responsable.id
          let r = this.responsables.find(e=>e.value == i)
          this.centreForm.patchValue({responsable: r?.value})
        }else{
          this.centreForm.patchValue({responsable: -1})
        }
      })
      return
    }
    this.empservice.findAll().subscribe(res=>{
      res.forEach(e=>{
        this.responsables.push({value: e.id || 0, view: e.prenom+' '+e.nom})
      })
    })
  }

  centreEnregistre(){
    let data = this.centreForm.value
    if( data.responsable != -1)
      data.responsable = {id: data.responsable}
    else
      data.responsable = null

    let r = data as CentreModel
    if( !r.id ) this.service.save(r).subscribe( res=> this.dialogRef.close() )
    else this.service.update(data).subscribe(res=>this.dialogRef.close())
  }

}
