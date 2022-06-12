import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMyReimbursementsComponent } from './view-my-reimbursements.component';

describe('ViewMyReimbursementsComponent', () => {
  let component: ViewMyReimbursementsComponent;
  let fixture: ComponentFixture<ViewMyReimbursementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMyReimbursementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMyReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
