package com.revature.services;

import java.util.List;

import com.reavture.daos.GetReimbursementByAuthorIdDao;
import com.revature.beans.Reimbursement;

public class GetReimbursementService {

	GetReimbursementByAuthorIdDao getReimbursementDao = new GetReimbursementByAuthorIdDao();
	
	public List<Reimbursement> getReimbursementService(int reimbursementAuthorID, int reimbursementRoleID){
		List<Reimbursement> reimbursement = getReimbursementDao.getReimbursementByAuthorId(reimbursementAuthorID, reimbursementRoleID);
		return reimbursement;
	}
}
	
