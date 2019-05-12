package com.revature.services;

import com.reavture.daos.SaveReimbursementDao;
import com.revature.beans.Reimbursement;

public class SaveReimbursement {
	SaveReimbursementDao saveReimbursementDao = new SaveReimbursementDao();

	public boolean saveReimmbursement(Reimbursement reimb) {
		//check if reimbursement already exists
		//generate response accordingly
		
		return saveReimbursementDao.saveReimb(reimb);
		
		
	}
}
