import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeVisualisationComponent } from './employee-visualisation.component';

describe('EmployeeVisualisationComponent', () => {
  let component: EmployeeVisualisationComponent;
  let fixture: ComponentFixture<EmployeeVisualisationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeVisualisationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeVisualisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
