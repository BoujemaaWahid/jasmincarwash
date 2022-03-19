import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentreVisualisationComponent } from './centre-visualisation.component';

describe('CentreVisualisationComponent', () => {
  let component: CentreVisualisationComponent;
  let fixture: ComponentFixture<CentreVisualisationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CentreVisualisationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CentreVisualisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
