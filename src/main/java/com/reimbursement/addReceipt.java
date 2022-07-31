package com.reimbursement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("receiptAmount")!="")
		{
		String receiptChosen = request.getParameter("receiptChosen");
		int receiptAmount = Integer.parseInt(request.getParameter("receiptAmount"));

		HttpSession session = request.getSession();
		ArrayList<Receipt> allReceipts = (ArrayList<Receipt>) session.getAttribute("allReceipts");
		int receiptId = (int) session.getAttribute("receiptId") + 1;
		int tripId = (int) session.getAttribute("tripId");

		Receipt receipt = new Receipt(receiptId, tripId, receiptChosen, receiptAmount, "");
		allReceipts.add(receipt);

		session.setAttribute("allReceipts", allReceipts);
		session.setAttribute("receiptId", receiptId);

		}
		response.sendRedirect("trip.jsp");
	}

}
