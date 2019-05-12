package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reavture.daos.GetUserByUsernameDao;
import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.services.HttpException;
import com.revature.services.LoginService;

public class LoginServlet extends DefaultServlet{
LoginService loginService = new LoginService();
User user = new User();
GetUserByUsernameDao getuser = new  GetUserByUsernameDao();
@Override
public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	response.addHeader("Access-Control-Allow-Headers", "content-type");
	response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	super.service(request, response);
}


@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		ObjectMapper om = new ObjectMapper();
		Credentials credentials = om.readValue(request.getInputStream(), Credentials.class);
		
		Integer id = null;
		try {
			id = this.loginService.login(credentials);
		} catch (HttpException e) {
			response.setStatus(e.getStatus());
			return;
		}
		user = getuser.getUserByUserName(credentials.getUsername());
		String cache = user.getErsUserID()+" "+user.getUserRoleID()+" "+user.getUserFirstName()+" "+user.getUserLastName();
		
		 HttpSession session = request.getSession();
		 
		 session.setAttribute("id", id);
		 om.writeValue(response.getOutputStream(), cache);
		 
	}


}
