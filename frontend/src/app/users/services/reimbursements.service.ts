import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RbForm } from '../models/rbForm.model';
import { Reimbursement } from '../models/reimbursement.model';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  baseUrl: string = "http://localhost:8484/api";

  constructor(private http: HttpClient) { }


  generateReimbursementRequest(amount : number): Observable<Reimbursement> {
    // get user's reimbursement amount 
    
    const rbForm = {
      "amount" : amount,
      "employee" : JSON.parse(sessionStorage.getItem("auth") as string)
    }
    return this.http.post<Reimbursement>(`${this.baseUrl}/reimbursement` , rbForm);
  }

  // get an Employee's list of Reimbursement request from DB
  getEmployeeReimbursementRequests(userId: number): Observable<Reimbursement[]>{
    return this.http.get<Reimbursement[]>(`${this.baseUrl}/reimbursement/employee/${userId}`);
  }

  // filter operations for reimbursement
  getPendingReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.status == "pending") {
              return item;
          }
      });

    return reimbursements
  }

  getResolvedReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.status == "resolved") {
              return item;
          }
      });

    return reimbursements
  }

  getRejectedReimbursementRequest(): Reimbursement[] {
    let reimbursements: Reimbursement[] = JSON.parse(
      sessionStorage.getItem("reimbursements") as string)
      .filter((item: any) => {
          if (item.status == "rejected") {
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

  updateReimbursement(reimbursement : Reimbursement) {
    return this.http.put<any>(`${this.baseUrl}/reimbursement` , reimbursement);
  }

    // get an Employee's list of Reimbursement request from DB
    getAllEmployeesReimbursementRequests(): Observable<Reimbursement[]>{
      return this.http.get<Reimbursement[]>(`${this.baseUrl}/reimbursement`);
    }
  

}
