import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CentreModel } from 'src/app/models/CentreModel';
import { CentreFormComponent } from '../centre-form/centre-form.component';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-visualisation',
  templateUrl: './centre-visualisation.component.html',
  styleUrls: ['./centre-visualisation.component.scss']
})
export class CentreVisualisationComponent implements OnInit {
  id = 0
  centre !: CentreModel
  actualDate = ''
  constructor(
    public dialog: MatDialog,
    private route: ActivatedRoute, private service: CentreService) {
    this.id = route.snapshot.params['id']
    let t = new Date().toLocaleDateString('fr').split('/')
    t[1] = service.getMonthsName()[ parseInt(t[1]) ]
    this.actualDate = t.join(' ')
  }

  ngOnInit(): void {
    this.service.findById(this.id).subscribe(res=> this.centre = res)
    
  }
  openDialog(){
    const dialogRef = this.dialog.open(CentreFormComponent, {
      width: '800px',
      data: {  id: this.id },
      panelClass: ['animate__animated','animate__fadeIn']
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}
