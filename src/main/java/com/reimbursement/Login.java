package com.reimbursement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.dao.LoginAdminDao;
import com.reimbursement.dao.LoginDao;


public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		LoginAdminDao daoAdmin = new LoginAdminDao();
		
		if(dao.check(userId, pass)){
			if(daoAdmin.check(userId, pass))
			{
				HttpSession session = request.getSession();
				session.setAttribute("adminMode", true);
				response.sendRedirect("iniciateConfig");
			}else
			{
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				response.sendRedirect("home.jsp");
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
