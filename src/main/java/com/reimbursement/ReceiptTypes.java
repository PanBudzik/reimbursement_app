package com.reimbursement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReceiptTypes {
	public ArrayList<String> get() {
		
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> types = new ArrayList<String>();
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reimbursement_calculator_db", "root", "");
            if(connection==null) {
                System.out.println("No connection");
            }else{
                System.out.println("connected");
            }

            statement = connection.createStatement();
            String sql = "SELECT * FROM receipttypes";

            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
            	String type = resultSet.getString("type");
                types.add(type);
            }
            
            return types;
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
        return types;
	}
}
