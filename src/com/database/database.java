/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class database {


    public boolean doInBackground(String... params) throws SQLException, ClassNotFoundException {
        String type = params[0];
        
        
        Connection con = null;
        int result = 0;
        
        try {
            
            
                System.out.println("Connecting database...");
                Class.forName("org.hsqldb.jdbcDriver");
                String url = "jdbc:hsqldb:file:C:\\db_inf202\\; shutdown=true";
                con = DriverManager.getConnection(url, "Sait" , "123");
                System.out.println("Connection successful");

                Statement stmt = con.createStatement();
            
                
            if(type=="firstTimeConnection"){
                
                //tablolar oluşmamışsa sistemde tablolar ekleniyor.

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "users( id INT NOT NULL IDENTITY, name VARCHAR(20) NOT NULL , surname VARCHAR(25) NOT NULL ,"
                        + " level INT NOT NULL , signature_expiry_date DATE NOT NULL , addition_date DATE NOT NULL ,"
                        + "username VARCHAR(15) NOT NULL , pass VARCHAR(256) NOT NULL ,"
                        + " PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + " customer ( id INT NOT NULL IDENTITY , name VARCHAR(40) NOT NULL ,"
                        + " place VARCHAR(30) NOT NULL , job_order_no VARCHAR(20) NOT NULL , offer_no VARCHAR(20) NOT NULL ,"
                        + " PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "project_names ( id INT NOT NULL IDENTITY , name VARCHAR(30) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "mp ( id INT NOT NULL IDENTITY , mp_carrier_medium VARCHAR(30) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "mp_equipment ( id INT NOT NULL IDENTITY , mp_id INT NOT NULL , equipment_id INT NOT NULL, "
                        + "PRIMARY KEY (id) );");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "equipment ( id INT NOT NULL IDENTITY , name VARCHAR(30) NOT NULL , "
                        + "pole_distance_mm VARCHAR(20) NOT NULL , mag_tech VARCHAR(20) NOT NULL , "
                        + "uv_light_intensity_w_m2 VARCHAR(20) NOT NULL , distance_of_light_mm VARCHAR(20) NOT NULL ,"
                        + " mp_carrier_medium VARCHAR(80) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "surface_condition ( id INT NOT NULL IDENTITY , surface_condition VARCHAR(20) NOT NULL ,"
                        + " PRIMARY KEY (id));");

                System.out.println(result);
            }
            else if(type=="login"){
                
                String username = params[1];
                String pass = params[2];
                String db_pass = null;
                
                ResultSet resultSet = null;
                resultSet = stmt.executeQuery("SELECT pass FROM users WHERE username = '" + username + "' ");
                while(resultSet.next()){
                    db_pass =(String) resultSet.getString("pass");
                }
              
                return controller(pass, db_pass );    
            }
                
        
            con.close();
            
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
        } catch (SQLException e) {
            System.out.println("Database connection error:" + e);
        }
            return false;
        }

    private boolean controller(String pass, String db_pass) {        
        if(pass.equals(db_pass))
            return true;
        else
            return false;
    }
        
    
}
