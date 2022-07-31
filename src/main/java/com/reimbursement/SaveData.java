package com.reimbursement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 13L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		if((float)session.getAttribute("totalWithLimit")!=0)
		{
		int userIdNum = 0;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM users WHERE user='"+session.getAttribute("userId")+"'";
		String url = "jdbc:mysql://localhost:3306/reimbursement_calculator_db";
		String username = "root";
		String password = "";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(sql);
				//st.setString(1, (String)session.getAttribute("userId"));
				
				resultSet = st.executeQuery(sql);
	            
	            while(resultSet.next()){
	            	userIdNum = resultSet.getInt("id");
	            }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		sql = "INSERT INTO trips(id, userId, distance, duration, plate, total) VALUES (NULL,?,?,?,?,?)";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, userIdNum+"");
				st.setString(2, session.getAttribute("distanceDriven")+"");
				st.setString(3, session.getAttribute("daysOfAllowance")+"");
				st.setString(4, (String)session.getAttribute("plate"));
				st.setString(5, session.getAttribute("totalWithLimit")+"");
				
				st.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

			response.sendRedirect("summary.jsp");
	}

}
