package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.services.GetReimbursementService;

public class GetReimbursementServlet extends DefaultServlet{
GetReimbursementService getReimbursementService = new GetReimbursementService();
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
	User user = om.readValue(request.getInputStream(),  User.class);
	List<Reimbursement> reimb = getReimbursementService.getReimbursementService(user.getErsUserID(), user.getUserRoleID());
	om.writeValue(response.getOutputStream(), reimb);

}
}
