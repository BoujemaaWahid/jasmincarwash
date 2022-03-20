import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CentreModel } from 'src/app/models/CentreModel';
import { CentreFormComponent } from '../centre-form/centre-form.component';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-list',
  templateUrl: './centre-list.component.html',
  styleUrls: ['./centre-list.component.scss']
})
export class CentreListComponent implements OnInit {

  centres !: CentreModel[];
  constructor(public dialog: MatDialog, private service: CentreService) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(res=> {
      this.centres = res
      console.log( res )
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CentreFormComponent, {
      width: '800px',
      data: {  id: null },
      panelClass: ['animate__animated','animate__fadeIn']
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  croissanceClass(value: number | undefined){
    if( !value ) value = 0
    return {
      'croissance-plus': value > 0,
      'croissance-moins': value < 0,
      'croissance-0': value == 0
    }
  }

}
