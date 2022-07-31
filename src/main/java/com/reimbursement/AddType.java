package com.reimbursement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddType extends HttpServlet {
	private static final long serialVersionUID = 122L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if((String)request.getParameter("type")!="") {
		String sql = "INSERT INTO receipttypes(id, type) VALUES (NULL,?)";
		String url = "jdbc:mysql://localhost:3306/reimbursement_calculator_db";
		String username = "root";
		String password = "";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, (String)request.getParameter("type"));
				
				st.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

        response.sendRedirect("IniciateEditReceipts");
		
	}

}
