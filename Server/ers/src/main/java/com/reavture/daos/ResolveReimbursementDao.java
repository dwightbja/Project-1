package com.reavture.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.services.HttpException;
import com.revature.util.ConnectionUtil;

public class ResolveReimbursementDao {

	public boolean resolveReimb(int reimbID, int resolverID, int statusID ) {
		Date date = new Date();
		long time = date.getTime();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, new Timestamp(time));
			ps.setInt(2,  resolverID);
			ps.setInt(3, statusID);
			ps.setInt(4, reimbID);
			ps.executeUpdate();
			return true;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	
	public List<Reimbursement> getPendingReimbursements(int roleID, int authorID){
		List<Reimbursement> requests = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM ers_reimbursement ";
		String sql2 = "SELECT * FROM ers_reimbursment where reimb_author = ? ";
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement ps;
			if (roleID ==2) {
				ps =conn.prepareStatement(sql);
			}
			else {
				ps =conn.prepareStatement(sql2);
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
				
				Reimbursement reimb = new Reimbursement(reimbID, reimbAmount, reimbSubmitted, reimbDescription, authorID, reimbResolver, reimbStatusID, reimbTypeID, reimbReceipt);
				requests.add(reimb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new HttpException(500);
		}
		
		return requests;
		
	}
}
