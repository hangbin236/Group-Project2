import { User } from "./user.model";

export interface Reimbursement {
    id: number,
    status: string,
    amount: number,
    timestamp: number,
    employee: User
}