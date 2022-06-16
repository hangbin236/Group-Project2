import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement.model';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  baseUrl: string = "http://localhost:7474";

  constructor(private http: HttpClient) { }


  generateReimbursementRequest(userId: any): Observable<Reimbursement> {
    // get user's reimbursement amount 
    let amount = prompt("Please enter the amount to be Reimbursed", '22.50');

    while(isNaN(parseFloat(amount as string))){
        amount = prompt("Please enter a correct number for your amount ")
    }
    const formData = new FormData();
    formData.append("emp_id", userId);
    formData.append("amount", amount as string);
    return this.http.post<Reimbursement>(`${this.baseUrl}/reimbursements` , formData);
  }

  // get an Employee's list of Reimbursement request from DB
  getEmployeeReimbursementRequests(userId: number): Observable<Reimbursement[]>{
    return this.http.get<Reimbursement[]>(`${this.baseUrl}/reimbursements/emp/${userId}`);
  }

  // filter operations for reimbursement
  getPendingReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.rb_status == "pending") {
              return item;
          }
      });

    return reimbursements
  }

  getResolvedReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.rb_status == "resolved") {
              return item;
          }
      });

    return reimbursements
  }

  getRejectedReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.rb_status == "rejected") {
              return item;
          }
      });

    return reimbursements
  }

  getAllReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string);
    return reimbursements
  }

  // updates request in DB
  updateReimbursementStatus(status: string, reimbursementId: any): Observable<any> {
    const formData = new FormData();
    formData.append("rb_id", reimbursementId);
    formData.append("rb_status", status);
    return this.http.put<any>(`${this.baseUrl}/reimbursements/status/update` , formData);
  }

    // get an Employee's list of Reimbursement request from DB
    getAllEmployeesReimbursementRequests(): Observable<Reimbursement[]>{
      return this.http.get<Reimbursement[]>(`${this.baseUrl}/reimbursements`);
    }
  

}
