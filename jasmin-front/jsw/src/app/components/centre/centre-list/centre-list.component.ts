import { Observable, Subscription } from 'rxjs';
import { ChangeDetectorRef, Component, NgZone, OnDestroy, OnInit, ViewRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CentreModel } from 'src/app/models/CentreModel';
import { CentreFormComponent } from '../centre-form/centre-form.component';
import { CentreService } from '../service/centre.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-centre-list',
  templateUrl: './centre-list.component.html',
  styleUrls: ['./centre-list.component.scss']
})
export class CentreListComponent implements OnInit, OnDestroy {
  i = 0
  centres = new Array<CentreModel>();
  streamer !: Subscription;
  actualDate = new Date().toLocaleDateString('fr')
  constructor(
    public dialog: MatDialog,
    private service: CentreService,
    private cdRef: ChangeDetectorRef,
    private zone: NgZone,
    private router: Router,
    private acRouter: ActivatedRoute
    ) { }

  ngOnDestroy(): void {
    this.streamer.unsubscribe()
  }

  ngOnInit(): void {
    this.streamer = this.service.streamAll().subscribe(res=> {
      this.centres = res
      this.cdRef.detectChanges()
    })
  }
  navigate(id: number|undefined){
    this.zone.run(()=>{
      this.router.navigate(['visual/'+id], {relativeTo: this.acRouter.parent})
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

  croissanceClass(value: number | undefined, index: number){
    if( !value ) value = 0
    
    return {
      'croissance-plus': value > 0,
      'croissance-moins': value < 0,
      'croissance-0': value == 0,
    }
  }

}
