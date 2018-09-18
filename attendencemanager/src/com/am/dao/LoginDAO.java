package com.am.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean checkLogin(String id, String password){
		
		boolean valid = false;
		
		 Connection con = null;       // to connect with database
         Statement st = null;         // to execute queries
         ResultSet rs = null;         // to read data from table

         // load the driver
         try {
             Class.forName(DB.driver);
             con = DriverManager.getConnection(DB.url, DB.user, DB.password);
         }
         catch (ClassNotFoundException e) {
              System.out.println("Driver error : " + e.getMessage());
              return false;
         }
         catch (SQLException e) {
              System.out.println("DSN error : " + e.getMessage());
              return false;
         }

      try {
        st = con.createStatement();

        String qry = "select * from admin where id='" + id + "' and password='" + password + "'";

        rs = st.executeQuery(qry);

        valid = rs.next();

      } catch (Exception e) {
              System.out.println("Query error : " + e.getMessage());
              valid = false;
      }
      finally{
          try {
              rs.close();
              st.close();
              con.close();

          } catch (Exception e) {
          }
      }		
      
      return valid;
	}

	public String checkTeacherLogin(String id, String password) {
		
		String result = "";
		
		 Connection con = null;       // to connect with database
         Statement st = null;         // to execute queries
         ResultSet rs = null;         // to read data from table

         // load the driver
         try {
             Class.forName(DB.driver);
             con = DriverManager.getConnection(DB.url, DB.user, DB.password);
         }
         catch (ClassNotFoundException e) {
              System.out.println("Driver error : " + e.getMessage());
              return "error";
         }
         catch (SQLException e) {
              System.out.println("DSN error : " + e.getMessage());
              return "error";
         }

      try {
        st = con.createStatement();

        String qry = "select loginid from faculty where loginid='" + id + "' and password='" + password + "'";
        rs = st.executeQuery(qry);

        if(rs.next())
        	result = "correct";
        else
        	result = "wrong";

      } catch (Exception e) {
              System.out.println("Query error : " + e.getMessage());
              return "error";
      }
      finally{
          try {
              rs.close();
              st.close();
              con.close();

          } catch (Exception e) {
          }
      }		
      
      return result;
	}

}
