import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursements } from './reimbursements.model';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  // baseUrl: string = "http://localhost:5555/api/reimbursements" // endpoint from backend, may change

  constructor(private http: HttpClient) { }



  // this array will be removed once we connect to the backend
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

      // this will replace the function below

  // getAllReimbursements(): Observable<Reimbursements[]>{
  //   return this.http.get<Reimbursements[]>(this.baseUrl)
  // }

  getAllReimbursements(): Reimbursements[]{
    return this.allReimbursements;
  }


  
      // this will replace the function below

  // addNewReimbursement(newReimbursement: Reimbursements): Observable<Reimbursements>{
  //   return this.http.post<Reimbursements>(this.baseUrl, newReimbursement)
  // }

  addNewReimbursement(newReimbursement: Reimbursements): Reimbursements[]{
    let generatedReimbursementId: number = this.allReimbursements[this.allReimbursements.length-1].id + 1;

    newReimbursement.id = generatedReimbursementId;

    this.allReimbursements.push(newReimbursement);

    return this.allReimbursements;

  }

  approveRequest(requestId: number){
    
  }

  
}
