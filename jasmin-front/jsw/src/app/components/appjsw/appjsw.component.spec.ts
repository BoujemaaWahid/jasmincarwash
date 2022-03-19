import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppjswComponent } from './appjsw.component';

describe('AppjswComponent', () => {
  let component: AppjswComponent;
  let fixture: ComponentFixture<AppjswComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppjswComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppjswComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
