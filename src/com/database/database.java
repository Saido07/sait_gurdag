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

/**
 *
 * @author sait_
 */
public class database {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        
        try {
            System.out.println("Connecting database...");
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:D:\\Uni\\TMS-II\\II. Dönem\\Inf-202\\app_database\\; shutdown=true";
            con = DriverManager.getConnection(url, "Sait" , "123456");
            System.out.println("Database connected!");
            
            
            } catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
            } catch (SQLException e) {
            System.out.println("Database connection error:" + e);
            }
        
        
      /*  try{
            result = stmt.executeUpdate("CREATE TABLE Kullanici(id INTEGER PRIMARY KEY AUTOINCREMENT, isim VARCHAR(20) NOT NULL, soyisim VARCHAR(20) NOT NULL, imza-son-gecerlilik DATE, seviye int , PRIMARY KEY (id));");            
        } catch(Exception e) {
            e.printStackTrace(System.out);
        
        }*/
        }
        
    
}
