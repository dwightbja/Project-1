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
import com.revature.services.ResolveReimbursementService;

public class ResolveReimbursementServlet extends DefaultServlet {
	ResolveReimbursementService resolveReimbursementService = new ResolveReimbursementService();
	
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
		super.service(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ObjectMapper om =new ObjectMapper();
		User user= om.readValue(request.getInputStream(),  User.class);
		List <Reimbursement> list = resolveReimbursementService.getPendingReimbursementService(user.getUserRoleID(), user.getErsUserID());
		om.writeValue(response.getOutputStream(), list);
		
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		Reimbursement reimbursement = om.readValue(request.getInputStream(), Reimbursement.class );
		super.doPost(request, response);
		boolean result = resolveReimbursementService.resolveReimmbursement(reimbursement.getReimbursementID(), reimbursement.getReimbursementResolverID(), reimbursement.getReimbursementStatusID());
		
		if (result) {
			response.setStatus(200);
		} else {
			response.setStatus(409);
		}	
	}
}

