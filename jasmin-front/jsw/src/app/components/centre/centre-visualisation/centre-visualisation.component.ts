import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-centre-visualisation',
  templateUrl: './centre-visualisation.component.html',
  styleUrls: ['./centre-visualisation.component.scss']
})
export class CentreVisualisationComponent implements OnInit {
  id = null
  
  constructor(private route: ActivatedRoute, private service: CentreService) {
    this.id = route.snapshot.params['id']
  }

  ngOnInit(): void {
  }

}
