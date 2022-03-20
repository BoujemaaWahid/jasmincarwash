import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentrePlanningComponent } from './centre-planning.component';

describe('CentrePlanningComponent', () => {
  let component: CentrePlanningComponent;
  let fixture: ComponentFixture<CentrePlanningComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CentrePlanningComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CentrePlanningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
