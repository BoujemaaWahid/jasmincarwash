import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentreActualChartComponent } from './centre-actual-chart.component';

describe('CentreActualChartComponent', () => {
  let component: CentreActualChartComponent;
  let fixture: ComponentFixture<CentreActualChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CentreActualChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CentreActualChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
