package com.reavture.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class SaveReimbursementDao {
	Date date = new Date();
	long time = date.getTime();
	
	public boolean saveReimb(Reimbursement reimbursment) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id, reimb_description, reim_receipt) VALUES " + 
		"(?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1,reimbursment.getReimbursementAmount());
			ps.setTimestamp(2,new Timestamp(time));
			ps.setInt(3,reimbursment.getReimbursementAuthorID());
			ps.setInt(4,5);
			ps.setInt(5,1);
			ps.setInt(6,reimbursment.getReimbursementTypeID());
			ps.setString(7,reimbursment.getReimbursementDescription());
			ps.setString(8,  reimbursment.getReimbursementReceipt());
		    ps.executeUpdate();
            return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		

}
}