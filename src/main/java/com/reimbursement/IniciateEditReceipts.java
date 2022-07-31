package com.reimbursement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IniciateEditReceipts extends HttpServlet {
    
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doPost(request,response);}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ReceiptTypes rt = new ReceiptTypes();
		ArrayList<String> receiptTypes = rt.get();
		session.setAttribute("receiptTypes", receiptTypes);
		
        response.sendRedirect("editReceipts.jsp");
	}

}
