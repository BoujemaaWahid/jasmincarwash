import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentreOldChartComponent } from './centre-old-chart.component';

describe('CentreOldChartComponent', () => {
  let component: CentreOldChartComponent;
  let fixture: ComponentFixture<CentreOldChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CentreOldChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CentreOldChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
