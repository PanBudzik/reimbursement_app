package com.reimbursement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class iniciateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReceiptTypes rt = new ReceiptTypes();
		ArrayList<String> receiptTypes = rt.get();
		ArrayList<Receipt> allReceipts = new ArrayList<Receipt>();
		
		HttpSession session = request.getSession();
		//userId declared in login
		session.setAttribute("tripId", 0);
		session.setAttribute("receiptId", 0);
		session.setAttribute("allReceipts", allReceipts);
		session.setAttribute("receiptTypes", receiptTypes);
		session.setAttribute("rateMilage", 0.3f);
		session.setAttribute("rateAllowance", 15);
		
		response.sendRedirect("trip.jsp");
	}

}
