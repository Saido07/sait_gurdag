/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class database {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Connection con = null;
        int result = 0;
        
        try {
            System.out.println("Connecting database...");
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\sait_\\Desktop\\SEDB\\; shutdown=true";
            con = DriverManager.getConnection(url, "Sait" , "123456");
            
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate("CREATE TABLE Teste(Id INTEGER PRIMARY KEY)");
            
           
            con.close();
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
        } catch (SQLException e) {
            System.out.println("Database connection error:" + e);
        }
        
        
      /*  try{
            } catch(Exception e) {
            e.printStackTrace(System.out);
        
        }*/
        }
        
    
}
