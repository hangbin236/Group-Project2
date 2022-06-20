import { Injectable } from '@angular/core';
import { Reimbursements } from './reimbursements.model';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  allReimbursements: Reimbursements[] = [
    {
      id: 1,
      rbStatus: 'pending',
      rbAmount: 100,
      rbTimestamp: 'date here',
      empId: 1
    },
    {
      id: 2,
      rbStatus: 'pending',
      rbAmount: 200,
      rbTimestamp: 'date here',
      empId: 1
    },
    {
      id: 3,
      rbStatus: 'pending',
      rbAmount: 150,
      rbTimestamp: 'date here',
      empId: 2
    },
    {
      id: 4,
      rbStatus: 'pending',
      rbAmount: 450,
      rbTimestamp: 'date here',
      empId: 3
    }

  ];

  getAllReimbursements(): Reimbursements[]{
    return this.allReimbursements;
  }

  addNewReimbursement(newReimbursement: Reimbursements): Reimbursements[]{
    let generatedReimbursementId: number = this.allReimbursements[this.allReimbursements.length-1].id + 1;

    newReimbursement.id = generatedReimbursementId;

    this.allReimbursements.push(newReimbursement);

    return this.allReimbursements;

  }

  approveRequest(requestId: number){
    
  }

  constructor() { }
}
