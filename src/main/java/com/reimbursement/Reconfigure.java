package com.reimbursement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Reconfigure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
        	 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reimbursement_calculator_db", "root", "");
             if(connection==null) {
                 System.out.println("No connection");
             }else{
                 System.out.println("connected");
             }

            statement = connection.createStatement();

            float rateMilage = Float.parseFloat(request.getParameter("rateMilage"));
            float rateAllowance = Float.parseFloat(request.getParameter("rateAllowance"));
            float limitTotal = Float.parseFloat(request.getParameter("limitTotal"));
            String sql="UPDATE config SET rateMilage = "+rateMilage+",rateAllowance = "+rateAllowance+",limitTotal = "+limitTotal;

            statement.executeUpdate(sql);
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                //resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        response.sendRedirect("iniciateConfig");
	}

}
