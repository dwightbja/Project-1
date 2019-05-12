package com.revature.services;

import java.util.List;

import com.reavture.daos.ResolveReimbursementDao;
import com.revature.beans.Reimbursement;

public class ResolveReimbursementService {

	ResolveReimbursementDao resolveReimbursementDao = new ResolveReimbursementDao();
	
	public boolean resolveReimmbursement(int reimbID, int resolverID, int statusID) {
		return resolveReimbursementDao.resolveReimb(reimbID, resolverID, statusID);
	}
	
	public List<Reimbursement> getPendingReimbursementService(int roleID, int authorID){
		return resolveReimbursementDao.getPendingReimbursements(roleID, authorID);
		
	}

}
