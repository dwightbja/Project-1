package com.reavture.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.services.HttpException;
import com.revature.util.ConnectionUtil;

public class GetUserByUsernameDao {
	public User getUserByUserName(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT ers_users_id, ers_username, user_first_name, user_last_name, user_role_id FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				int roleID = rs.getInt("user_role_id");
				int userID = rs.getInt("ers_users_id");
				
				return new User(userID, roleID, username, firstName, lastName);
			} else {
				throw new HttpException(400);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

}
