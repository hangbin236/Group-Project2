import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursements } from '../reimbursements.model'
import { ReimbursementsService } from '../reimbursements.service';

@Component({
  selector: 'view-all-reimbursements',
  templateUrl: './view-all-reimbursements.component.html',
  styleUrls: ['./view-all-reimbursements.component.css']
})
export class ViewAllReimbursementsComponent implements OnInit {

  currentAllReimbursements: Reimbursements[];

  shouldDisplay: boolean = false;

  newReimbursement: Reimbursements = {
    id: 0,
    rbStatus: '',
    rbAmount: 0,
    rbTimestamp: '',
    empId: 0
  }


  constructor(private reimbursementService: ReimbursementsService, private router: Router) { 
    this.currentAllReimbursements = [];
  }

  ngOnInit(): void {
    this.currentAllReimbursements = this.reimbursementService.getAllReimbursements();
  }

  displayReimbursementsForm(){
    if(this.shouldDisplay){
      this.shouldDisplay = false;
    }else{
      this.shouldDisplay = true;
    }
  }

  addNewRequest(){
    let localNewReimbursement: Reimbursements = {
      id: 0,
      rbStatus: this.newReimbursement.rbStatus,
      rbAmount: this.newReimbursement.rbAmount,
      rbTimestamp: this.newReimbursement.rbTimestamp,
      empId: this.newReimbursement.empId
    };

    this.newReimbursement = {
      id: 0,
      rbStatus: '',
      rbAmount: 0,
      rbTimestamp: '',
      empId: 0
    };

    this.shouldDisplay = false;

    this.currentAllReimbursements = this.reimbursementService.addNewReimbursement(localNewReimbursement);
  }

}
