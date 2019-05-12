package com.reavture.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;

import com.revature.beans.Reimbursement;
import com.revature.services.HttpException;
import com.revature.util.ConnectionUtil;

public class GetReimbursementByAuthorIdDao {
	public List<Reimbursement> getReimbursementByAuthorId(int reimbursementAuthorID, int reimbursementRoleId) {
		
		List<Reimbursement> requests = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM ers_reimbursement WHERE  reimb_author = ? ";
		String sql2 = "SELECT * FROM ers_reimbursement";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps;
			if(reimbursementRoleId ==1) {
			    ps = conn.prepareStatement(sql);
				ps.setInt(1,  reimbursementAuthorID);	
			}
			else {
				ps = conn.prepareStatement(sql2);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbID = rs.getInt("reimb_id");
				double reimbAmount = rs.getDouble("reimb_amount");
				Timestamp reimbSubmitted = rs.getTimestamp("reimb_submitted");
				String reimbDescription = rs.getString("reimb_description");
				int reimbResolver = rs.getInt("reimb_resolver");
				int reimbStatusID = rs.getInt("reimb_status_id");
				int reimbTypeID = rs.getInt("reimb_type_id");
				String reimbReceipt = rs.getString("reim_receipt");
				
				Reimbursement reimb = new Reimbursement(reimbID, reimbAmount, reimbSubmitted, reimbDescription, reimbursementAuthorID, reimbResolver, reimbStatusID, reimbTypeID, reimbReceipt);
				requests.add(reimb);	
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
		
		return requests;
	}

}


