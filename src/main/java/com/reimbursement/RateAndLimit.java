package com.reimbursement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class RateAndLimit {
	public ArrayList<Float> get() {
		
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Float> parameters = new ArrayList<Float>();
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reimbursement_calculator_db", "root", "");
            if(connection==null) {
                System.out.println("No connection");
            }else{
                System.out.println("connected");
            }

            statement = connection.createStatement();
            String sql = "SELECT * FROM config";

            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
            	float rateAllowance = resultSet.getFloat("rateAllowance");
            	float rateMilage = resultSet.getFloat("rateMilage");
                float limitTotal = resultSet.getFloat("limitTotal");
                parameters.add(rateMilage);
                parameters.add(rateAllowance);
                parameters.add(limitTotal);
            }
            
            return parameters;
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                resultSet.close();
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
        return parameters;
	}
}
