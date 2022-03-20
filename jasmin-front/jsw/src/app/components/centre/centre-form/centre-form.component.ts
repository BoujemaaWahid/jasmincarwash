import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { CentreModel } from 'src/app/models/CentreModel';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-form',
  templateUrl: './centre-form.component.html',
  styleUrls: ['./centre-form.component.scss']
})
export class CentreFormComponent implements OnInit {
  foods = [
    {value: {id: 1}, viewValue: 'Steak'},
    {value: {id: 2}, viewValue: 'Pizza'},
    {value: {id: 3}, viewValue: 'Tacos'},
  ];
  selected = {id: 1}
  public centreForm = new FormGroup({
    id: new FormControl(null),
    label: new FormControl('LABEL'),
    ouverture: new FormControl('10:00'),
    fermeture: new FormControl('18:00'),
    adresse: new FormControl('ADRESSE'),
    telephone: new FormControl('TELEPHONE'),
    code: new FormControl('CODE'),
    responsable: new FormControl(),
    formule: new FormControl(),
    croissancemp: new FormControl(0)
  })
  
  constructor(
    public dialogRef: MatDialogRef<CentreFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private service: CentreService
  ) { }

  ngOnInit(): void {
    /*this.centreForm.patchValue({
      responsable: this.foods[0].value,
      formule: this.foods[1].value
    }, {emitEvent: false})*/
  }

  centreEnregistre(){
    let data = this.centreForm.value as CentreModel
    this.service.save(data).subscribe( res=> this.dialogRef.close() )
  }

}
