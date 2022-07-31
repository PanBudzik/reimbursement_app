package com.reimbursement;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SummarizeTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		RateAndLimit ral = new RateAndLimit();
		ArrayList<Float> rateAndLimit= ral.get();
		
		int fullAmountReceipts=0;
		
		if(session.getAttribute("allReceipts")!=null)
		{
		ArrayList<Receipt> allReceipts = (ArrayList<Receipt>) session.getAttribute("allReceipts");
		session.setAttribute("rateMilage", rateAndLimit.get(0));
		session.setAttribute("rateAllowance", rateAndLimit.get(1));
		session.setAttribute("limitTotal", rateAndLimit.get(2));
		
		for(Receipt r : allReceipts)
		{
		    fullAmountReceipts+=r.receiptAmount;
		}
		}
		
		session.setAttribute("fullAmountReceipts", fullAmountReceipts);
		
		
		String startString = request.getParameter("startDate");
		String endString = request.getParameter("endDate");
		
		long daysOfAllowance = 0;
		if((startString!=null)&&(endString!=null)) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
		    Date date1 = myFormat.parse(startString);
		    Date date2 = myFormat.parse(endString);
		    long diff = date2.getTime() - date1.getTime();
		    if(diff>0){
		    daysOfAllowance = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    }
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		session.setAttribute("daysOfAllowance", daysOfAllowance);
		
		float rateAllowance= (float) session.getAttribute("rateAllowance");
		float amountAllowance = (float)(daysOfAllowance*rateAllowance);
		session.setAttribute("amountAllowance", amountAllowance);
		
		
		int startMilage = 0;
		int endMilage = 0;
		if(request.getParameter("startMilage")!="") startMilage = Integer.parseInt(request.getParameter("startMilage"));
		if(request.getParameter("endMilage")!="") endMilage = Integer.parseInt(request.getParameter("endMilage"));
		int distanceDriven = 0;
		if((startMilage>=0)&&(endMilage>=startMilage)) {
		distanceDriven = endMilage - startMilage;
		}
		float rateMilage = (float) session.getAttribute("rateMilage");
		float amountMilage = distanceDriven*rateMilage;
		
		session.setAttribute("distanceDriven", distanceDriven);
		session.setAttribute("amountMilage", amountMilage);
	    
		String plate = request.getParameter("plate");
		session.setAttribute("plate", plate);
		
		
		float total = amountMilage+amountAllowance+fullAmountReceipts;
		session.setAttribute("total", total);
		
		float totalWithLimit=total;
		if(total>(float)session.getAttribute("limitTotal")) {
			totalWithLimit = (float)session.getAttribute("limitTotal");
		}
		session.setAttribute("totalWithLimit", totalWithLimit);
		
		
		
		response.sendRedirect("SaveData");
		
		
	}

}}
