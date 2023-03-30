import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinginFormComponent } from './singin-form.component';

describe('SinginFormComponent', () => {
  let component: SinginFormComponent;
  let fixture: ComponentFixture<SinginFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SinginFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SinginFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
