import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitReimbursementComponent } from './submit-reimbursement.component';

describe('SubmitReimbursementComponent', () => {
  let component: SubmitReimbursementComponent;
  let fixture: ComponentFixture<SubmitReimbursementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmitReimbursementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmitReimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
