package com.reavture.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.services.HttpException;
import com.revature.util.ConnectionUtil;


public class LoginDao {
	public User getPasswordByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT ers_users_id, ers_password FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString("ers_password");
				int id = rs.getInt("ers_users_id");
				return new User(username, password, id);
			} else {
				throw new HttpException(400);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

}


