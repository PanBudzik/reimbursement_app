package com.reimbursement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "DELETE FROM `receipttypes` WHERE type=?";
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
			
			
		
        response.sendRedirect("IniciateEditReceipts");
	}

}
