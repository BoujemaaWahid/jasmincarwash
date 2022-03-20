import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CentreFormComponent } from '../centre-form/centre-form.component';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-visualisation',
  templateUrl: './centre-visualisation.component.html',
  styleUrls: ['./centre-visualisation.component.scss']
})
export class CentreVisualisationComponent implements OnInit {
  id = null
  constructor(
    public dialog: MatDialog,
    private route: ActivatedRoute, private service: CentreService) {
    this.id = route.snapshot.params['id']
  }

  ngOnInit(): void {
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
