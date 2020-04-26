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
        
        Date today = new Date();
        today.getTime();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
        password_hash p = new password_hash();
        Connection con = null;
        int result = 0;
        
        try {
            
            
                System.out.println("Connecting database...");
                Class.forName("org.hsqldb.jdbcDriver");
                String url = "jdbc:hsqldb:res:/db_inf202/; shutdown=true";
                con = DriverManager.getConnection(url, "Sait" , "123");
                System.out.println("Connection successful");

                Statement stmt = con.createStatement();
            
                
            if(type=="firstTimeConnection"){
                
                //tablolar oluşmamışsa sistemde tablolar ekleniyor.

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "users( id INT NOT NULL IDENTITY, name VARCHAR(20) NOT NULL , surname VARCHAR(25) NOT NULL ,"
                        + " level INT NOT NULL , signature_expiry_date DATE NOT NULL , addition_date DATE NOT NULL ,"
                        + " added_by VARCHAR(15) NOT NULL , username VARCHAR(15) NOT NULL , pass VARCHAR(256) NOT NULL ,"
                        + " PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + " customer ( id INT NOT NULL IDENTITY , name VARCHAR(40) NOT NULL ,"
                        + " place VARCHAR(30) NOT NULL , job_order_no VARCHAR(20) NOT NULL , offer_no VARCHAR(20) NOT NULL ,"
                        + " addition_date DATE NOT NULL , added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "project_names ( id INT NOT NULL IDENTITY , name VARCHAR(30) NOT NULL ,"
                        + "addition_date DATE NOT NULL , added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "mp ( id INT NOT NULL IDENTITY , mp_carrier_medium VARCHAR(30) NOT NULL ,"
                        + "addition_date DATE NOT NULL , added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "mp_equipment ( id INT NOT NULL IDENTITY , mp_id INT NOT NULL , equipment_id INT NOT NULL, "
                        + "addition_date DATE NOT NULL , added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id) );");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "equipment ( id INT NOT NULL IDENTITY , name VARCHAR(30) NOT NULL , "
                        + "pole_distance_mm VARCHAR(20) NOT NULL , mag_tech VARCHAR(20) NOT NULL , "
                        + "uv_light_intensity_w_m2 VARCHAR(20) NOT NULL , distance_of_light_mm VARCHAR(20) NOT NULL ,"
                        + " mp_carrier_medium VARCHAR(80) NOT NULL , addition_date DATE NOT NULL ,"
                        + " added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id));");

                result = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
                        + "surface_condition ( id INT NOT NULL IDENTITY , name VARCHAR(20) NOT NULL ,"
                        + " addition_date DATE NOT NULL , added_by VARCHAR(15) NOT NULL , PRIMARY KEY (id));");

                System.out.println(result);
    
            }else if(type=="login"){
                
                String username = params[1];
                String pass = params[2];
                String db_pass = null;
                
                
                resultSet = stmt.executeQuery("SELECT pass FROM users WHERE username = '" + username + "' ");
                while(resultSet.next()){
                    db_pass =(String) resultSet.getString("pass");
                }
              
                return controller(pass, db_pass );  
            }else if(type=="getusers"){
                Strings.getUsers().removeAllElements();
                Strings.setUsers("Yeni Kullanıcı");
                resultSet = stmt.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    int i=0;
                    Strings.setUsers((String)resultSet.getString("id")+ " | " + resultSet.getString("name") + " " 
                            +  resultSet.getString("surname"));
                    i++;
                }
            }else if(type=="getCustomer"){
                Strings.getCustomers().removeAllElements();
                Strings.setCustomers("Yeni Müşteri");
                resultSet = stmt.executeQuery("SELECT * FROM customer");
                while(resultSet.next()){
                    int i=0;
                    Strings.setCustomers((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getTest"){
                Strings.getTest().removeAllElements();
                Strings.setTest("Yeni Test");
                resultSet = stmt.executeQuery("SELECT * FROM project_names");
                while(resultSet.next()){
                    int i=0;
                    Strings.setTest((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getSurface"){
                Strings.getSurface().removeAllElements();
                Strings.setSurface("Yeni Yüzey Durumu");
                resultSet = stmt.executeQuery("SELECT * FROM surface_condition");
                while(resultSet.next()){
                    int i=0;
                    Strings.setSurface((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getEqui"){
                Strings.getEqui().removeAllElements();
                Strings.setEqui("Yeni Ekipman");
                resultSet = stmt.executeQuery("SELECT * FROM equipment");
                while(resultSet.next()){
                    int i=0;
                    Strings.setEqui((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                } 
            }else if(type=="addNewUser"){
                String username = params[1];
                String name = params[2];
                String surname = params[3];
                String level = params[4]; 
                String sign = params[5];
                try {
                    result = stmt.executeUpdate("INSERT INTO users(username, name, surname,"
                        + " level, signature_expiry_date, addition_date, pass ,  added_by) VALUES ('" + username + "','"
                        + ""+ name +"','"+surname+"','"+level+"','"+sign+"','"+modifiedDate+"','"+ p.password_hash(surname) +"',"
                        + "'"+Strings.getUsername()+"')");
                    System.out.println("Kullanıcı başarıyla eklendi");
                                            
                    //standart soyismi şifresi olarak geliyor sonra kullanıcı kendi ayarlayabilecek.
                    System.out.println(result);
                    if(result==1){
                        System.out.println("burda");
                        return true;                       
                    }else{
                        return false;
                    }
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            
            }else if(type=="addNewCustomer"){
                String cusName = params[1];
                String place = params[2];
                String jobOrderNo = params[3];
                String offerNo = params[4];
                try {
                    result = stmt.executeUpdate("INSERT INTO users(name, place, job_order_no,"
                        + " offer_no, addition_date, added_by) VALUES ('" + cusName + "','"
                        + ""+ place +"','"+jobOrderNo+"','"+offerNo+"','"+modifiedDate+"','"+Strings.getUsername()+"')");
                    System.out.println("Yeni müşteri başarıyla eklendi");
                    return true;
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="addNewEqui"){
//doldurulacak///////                  
            }else if(type=="addNewTest"){
                String test = params[1];
                try {
                    result = stmt.executeUpdate("INSERT INTO project_names(name,"
                        + " addition_date, added_by) VALUES ('" + test + "',"
                        + "'"+modifiedDate+"','"+Strings.getUsername()+"')");
                    System.out.println("Yeni test başarıyla eklendi");
                    return true;
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="addNewSurface"){
                String surface = params[1];
                try {
                    result = stmt.executeUpdate("INSERT INTO surface_condition(name,"
                        + " addition_date, added_by) VALUES ('" + surface + "',"
                        + "'"+modifiedDate+"','"+Strings.getUsername()+"')");
                    System.out.println("Yeni yüzey durumu başarıyla eklendi");
                    return true;
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } 
            }else if(type=="finduser"){         //admin'in kullanıcı değişikliği yaparken kullanıdığı
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
            }else if(type=="finduser2"){        //profil ekranı için
                resultSet = stmt.executeQuery("SELECT * FROM users WHERE username ='"+ Strings.getUsername() +"'");
                
                while(resultSet.next()){
                    Strings.setDb_User_id((String) resultSet.getString("id"));
                    Strings.setDb_name((String) resultSet.getString("name"));
                    Strings.setDb_surname((String) resultSet.getString("surname"));
                }
                return true;
            }else if(type=="findCustomer"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM customer WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    
                    Strings.setDb_cus_name((String) resultSet.getString("name"));
                    Strings.setDb_cus_place((String) resultSet.getString("place"));
                    Strings.setDb_cus_job((String) resultSet.getString("job_order_no,"));
                    Strings.setDb_cus_offer((String) resultSet.getString("offer_no"));
                }
                return true;
            }else if(type=="findSurface"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM surface_condition WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Strings.setDb_surf_name((String) resultSet.getString("name"));
                }
                return true;
            }else if(type=="findEqui"){
/////////////////                               
            }else if(type=="findTest"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM project_names WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Strings.setDb_test_name((String) resultSet.getString("name"));
                }
                return true;                              
            }else if(type=="updateUser"){
                if(params[1]=="pro"){
                    String username = params[2];
                    String name = params[3];
                    String surname = params[4];
                    String pass = params[5]; 
                    try {
                        result = stmt.executeUpdate("UPDATE users SET username = '" + username + "',"
                                + " name = '" + name + "' , surname = '"+surname+"' ,"
                                + " pass = '"+pass+"', addition_date = '"+modifiedDate+"',"
                                + " added_by = '"+Strings.getUsername()+"' "
                                + "WHERE id = '"+Strings.getDb_User_id()+"'");
                        System.out.println("kullanıcı bilgileri güncellendi");
                        return true;                         
                    } catch (Exception ex) {
                            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                    }
                }else if(params[1]=="pro2"){
                    String username = params[2];
                    String name = params[3];
                    String surname = params[4]; 
                    try {
                        result = stmt.executeUpdate("UPDATE users SET username = '" + username + "',"
                                + " name = '" + name + "' , surname = '"+surname+"' ,"
                                + " addition_date = '"+modifiedDate+"',"
                                + " added_by = '"+Strings.getUsername()+"' "
                                + "WHERE id = '"+Strings.getDb_User_id()+"'");
                        System.out.println("kullanıcı bilgileri güncellendi");
                        return true;                         
                    } catch (Exception ex) {
                            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                    }
                }else{
                    String username = params[1];
                    String name = params[2];
                    String surname = params[3];
                    String level = params[4]; 
                    String sign = params[5];
                    try {
                        result = stmt.executeUpdate("UPDATE users SET username = '" + username + "',"
                                + " name = '" + name + "' , surname = '"+surname+"' , level = '"+level+"',"
                                + " signature_expiry_date = '"+sign+"', addition_date = '"+modifiedDate+"', "
                                + " added_by ='"+Strings.getUsername()+"' WHERE id = '"+Strings.getDb_id()+"'");
                        System.out.println("Kullanıcı bilgileri güncellendi");
                        return true;                         
                    } catch (Exception ex) {
                            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                    }
                }
            }else if(type=="updateSurface"){
                String name = params[1];
                try {
                    result = stmt.executeUpdate("UPDATE surface_condition SET name = '" + name + "'"
                            + ", addition_date = '"+modifiedDate+"', added_by = '"+Strings.getUsername()+"'"
                            + "WHERE id = '"+Strings.getDb_surId()+"'");
                    System.out.println("Yüzey durumu bilgileri güncellendi");
                    return true;                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateTest"){
                String name = params[1];
                try {
                    result = stmt.executeUpdate("UPDATE project_names SET name = '" + name + "'"
                            + ", addition_date = '"+modifiedDate+"', added_by = '"+Strings.getUsername()+"'"
                            + "WHERE id = '"+Strings.getDb_testId()+"'");
                    System.out.println("Test bilgileri güncellendi");
                    return true;                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateCustomer"){
                String name = params[2];
                String place = params[3];
                String job = params[4];
                String offer = params[5]; 
                try {
                    result = stmt.executeUpdate("UPDATE customer SET name = '" + name + "',"
                            + " place = '" + place + "' , job_order_no = '"+job+"' ,"
                            + " offer_no = '"+offer+"', addition_date = '"+modifiedDate+"',"
                            + " added_by = '"+Strings.getUsername()+"' "
                            + "WHERE id = '"+Strings.getDb_customerId()+"'");
                    System.out.println("kullanıcı bilgileri güncellendi");
                    return true;                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateEqui"){
/////////////////////               
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
            }else if(type=="surfaceDelete"){
                String deletedId =params[1];
                try {
                    result = stmt.executeUpdate("DELETE FROM surface_condition "
                            + "WHERE id = '"+deletedId+"'");
                    System.out.println("Yüzey Durumu Silindi");
                    return true;                        
                } catch (Exception ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="testDelete"){
                String deletedId =params[1];
                try {
                    result = stmt.executeUpdate("DELETE FROM project_names "
                            + "WHERE id = '"+deletedId+"'");
                    System.out.println("Test Türü Silindi");
                    return true;                        
                } catch (Exception ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="customerDelete"){
/////////////////////                
            }else if(type=="equiDelete"){
/////////////////////              
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
