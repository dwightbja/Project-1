export class ReimbList {
    reimbursementID: number;
    reimbursementAmount: number;
    reimbursementSubmitted: Date = new Date();
    reimbursementResolver: number;
    reimbursementStatusID: number;
    reimbursementTypeID: number;
    reimbursementReceipt: string;
    reimbursementAuthorID: number;
    reimbursementDescription: string;
    reimbursementResolved: Date = new Date();

    constructor(reimbursementID: number, reimbursementAmount: number, reimbursementSubmitted: Date = new Date(), 
    reimbursementResolver: number, reimbursementStatusID: number, reimbursementTypeID: number,
    reimbursementReceipt: string, reimbursementAuthorID: number, reimbursementDescription: string, 
    reimbursementResolved: Date = new Date()) {
        this.reimbursementID = reimbursementID;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatusID = reimbursementStatusID;
        this.reimbursementTypeID = reimbursementTypeID;
        this.reimbursementReceipt = reimbursementReceipt;
        this.reimbursementAuthorID = reimbursementAuthorID;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementResolved = reimbursementResolved;
    }


}
