/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.BIN.Strings;
import com.security.password_hash;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



public class database {

    public ResultSet resultSet = null;

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
                
                
                resultSet = stmt.executeQuery("SELECT pass FROM users WHERE username = '" + username + "' ");
                while(resultSet.next()){
                    db_pass =(String) resultSet.getString("pass");
                }
              
                return controller(pass, db_pass );    
            }
            else if(type=="getusers"){
                Strings.getUsers().removeAllElements();
                Strings.setUsers("Yeni Kullanıcı");
                resultSet = stmt.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    int i=0;
                    Strings.setUsers((String)resultSet.getString("id")+ " | " + resultSet.getString("name") + " " 
                            +  resultSet.getString("surname"));
                    i++;
                }   
            }else if(type=="addNewUser"){
                String username = params[1];
                String name = params[2];
                String surname = params[3];
                String level = params[4]; 
                String sign = params[5];
                Date today = new Date();
                today.getTime();
                String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
                password_hash p = new password_hash();
                try {
                    result = stmt.executeUpdate("INSERT INTO users(username, name, surname,"
                        + " level, signature_expiry_date, addition_date, pass) VALUES ('" + username + "','"
                        + ""+ name +"','"+surname+"','"+level+"','"+sign+"','"+modifiedDate+"','"+ p.password_hash("123") +"')");
                    System.out.println("kullanıcı eklendi");
                                            
                    //standart 123 şifresi geliyor sonra kullanıcı kendi ayarlayabilecek.
                    return true;
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
                
            }else if(type=="finduser"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM users WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Strings.setDb_username((String) resultSet.getString("username"));
                    Strings.setDb_name((String) resultSet.getString("name"));
                    Strings.setDb_surname((String) resultSet.getString("surname"));
                    Strings.setDb_level((String) resultSet.getString("level"));
                    Strings.setDb_signature_expiry_date((String) resultSet.getString("signature_expiry_date"));
                }
                return true;
                
            }else if(type=="updateUser"){
                String username = params[1];
                String name = params[2];
                String surname = params[3];
                String level = params[4]; 
                String sign = params[5];
                Date today = new Date();
                today.getTime();
                String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
                
                try {
                    result = stmt.executeUpdate("UPDATE users SET username = '" + username + "',"
                            + " name = '" + name + "' , surname = '"+surname+"' , level = '"+level+"',"
                            + " signature_expiry_date = '"+sign+"', addition_date = '"+modifiedDate+"' "
                            + "WHERE id = '"+Strings.getDb_id()+"'");
                    System.out.println("kullanıcı bilgileri güncellendi");
                    return true;                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="userDelete"){
                
                String deletedId =params[1];
                try {
                    result = stmt.executeUpdate("DELETE FROM users "
                            + "WHERE id = '"+deletedId+"'");
                    System.out.println("Kullanıcı Silindi");
                    return true;                        
                } catch (Exception ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
              
            
            
        
            con.close();
            
            
            
            } catch (ClassNotFoundException e) {
                System.out.println("Database connection error:" + e);
            } catch (SQLException e) {
                System.out.println("Database connection error:" + e);
            }
                return true;
        }

    private boolean controller(String pass, String db_pass) {        
        if(pass.equals(db_pass))
            return true;
        else
            return false;
    }
    
        
    
}
