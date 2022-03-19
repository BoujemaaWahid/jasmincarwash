import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CentreFormComponent } from '../centre-form/centre-form.component';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-list',
  templateUrl: './centre-list.component.html',
  styleUrls: ['./centre-list.component.scss']
})
export class CentreListComponent implements OnInit {

  
  constructor(public dialog: MatDialog, private service: CentreService) { }

  ngOnInit(): void {
    this.service.findAll().subscribe(console.log)
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CentreFormComponent, {
      width: '800px',
      data: {  add: true },
      panelClass: ['animate__animated','animate__fadeIn']
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

}
