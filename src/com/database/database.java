package com.database;

import com.BIN.Customer;
import com.BIN.Equi;
import com.BIN.Strings;
import com.BIN.Surface;
import com.BIN.Test;
import com.BIN.User;
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
                String url = "jdbc:hsqldb:file:" + System.getProperty("user.home") + "\\db_inf202\\;" ;   
             // String url = "jdbc:hsqldb:res:/db_inf202/";
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
                if(!Strings.isSearch()){
                    User.getUsers().removeAllElements();
                    User.setUsers("Ara");
                    User.setUsers("Yeni Kullanıcı");
                    resultSet = stmt.executeQuery("SELECT * FROM users");
                    while(resultSet.next()){
                        int i=0;
                        User.setUsers((String)resultSet.getString("id")+ " | " + resultSet.getString("name") + " " 
                                +  resultSet.getString("surname"));
                        i++;
                    }
                }else{
                    User.getUsers().removeAllElements();
                    User.setUsers("Ara");
                    User.setUsers("Yeni Kullanıcı");
                    resultSet = stmt.executeQuery("SELECT * from users WHERE name LIKE '"+Strings.getSearchedText() +"%' "
                            + "OR NAME LIKE '"+Strings.getSearched2Text() +"%';");
         
                    while(resultSet.next()){
                        int i=0;
                        User.setUsers((String)resultSet.getString("id")+ " | " + resultSet.getString("name") + " " 
                                +  resultSet.getString("surname"));
                        i++;
                    }
                    Strings.isSearch(false);
                }
            }else if(type=="getusers2"){
                User.getUsers().removeAllElements();
                resultSet = stmt.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    int i=0;
                    User.setUsers((String)resultSet.getString("id")+ " | " + resultSet.getString("name") + " " 
                            +  resultSet.getString("surname"));
                    i++;
                } 
            }else if(type=="getCustomer"){
                Customer.getCustomers().removeAllElements();
                Customer.setCustomers("Yeni Müşteri");
                resultSet = stmt.executeQuery("SELECT * FROM customer");
                while(resultSet.next()){
                    int i=0;
                    Customer.setCustomers((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getCustomer2"){
                Customer.getCustomers().removeAllElements();
                resultSet = stmt.executeQuery("SELECT * FROM customer");
                while(resultSet.next()){
                    int i=0;
                    Customer.setCustomers((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getTest"){
                Test.getTest().removeAllElements();
                Test.setTest("Yeni Test Türü");
                resultSet = stmt.executeQuery("SELECT * FROM project_names");
                while(resultSet.next()){
                    int i=0;
                    Test.setTest((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getTest2"){
                Test.getTest().removeAllElements();
                resultSet = stmt.executeQuery("SELECT * FROM project_names");
                while(resultSet.next()){
                    int i=0;
                    Test.setTest((String)" " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getSurface"){
                Surface.getSurface().removeAllElements();
                Surface.setSurface("Yeni Yüzey Durumu");
                resultSet = stmt.executeQuery("SELECT * FROM surface_condition");
                while(resultSet.next()){
                    int i=0;
                    Surface.setSurface((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getSurface2"){
                Surface.getSurface().removeAllElements();
                resultSet = stmt.executeQuery("SELECT * FROM surface_condition");
                while(resultSet.next()){
                    int i=0;
                    Surface.setSurface((String)" " + resultSet.getString("name"));
                    i++;
                }
            }else if(type=="getEqui"){
                Equi.getEqui().removeAllElements();
                Equi.setEqui("Yeni Ekipman");
                resultSet = stmt.executeQuery("SELECT * FROM equipment");
                while(resultSet.next()){
                    int i=0;
                    Equi.setEqui((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
                    i++;
                } 
            }else if(type=="getEqui2"){
                Equi.getEqui().removeAllElements();
                resultSet = stmt.executeQuery("SELECT * FROM equipment");
                while(resultSet.next()){
                    int i=0;
                    Equi.setEqui((String)resultSet.getString("id")+ " | " + resultSet.getString("name"));
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
                        + "'"+User.getUsername()+"')");
                    System.out.println("Kullanıcı başarıyla eklendi!!!!!");
                                            
                    //standart soyismi şifresi olarak geliyor sonra kullanıcı kendi ayarlayabilecek.
                    System.out.println(result);
                    if(result==1){
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
                    result = stmt.executeUpdate("INSERT INTO customer(name, place, job_order_no,"
                        + " offer_no, addition_date, added_by) VALUES ('" + cusName + "','"
                        + ""+ place +"','"+jobOrderNo+"','"+offerNo+"','"+modifiedDate+"','"+User.getUsername()+"')");
                    System.out.println("Yeni müşteri başarıyla eklendi");
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
            }else if(type=="addNewEqui"){
                String name = params[1];
                String poleDis = params[2];
                String mag_tech = params[3];
                String uv_light_intensity_w_m2 = params[4];
                String distance_of_light  = params[5];
                String mp_carrier_medium = params[6];
                try {
                    result = stmt.executeUpdate("INSERT INTO equipment(name, pole_distance_mm, mag_tech,"
                        + " uv_light_intensity_w_m2, distance_of_light_mm, mp_carrier_medium, addition_date, added_by) VALUES ('" + name + "','"
                        + ""+ poleDis +"','"+mag_tech+"','"+uv_light_intensity_w_m2+"','"+distance_of_light+"','"+mp_carrier_medium+"','"+modifiedDate+"','"+User.getUsername()+"')");
                    System.out.println("Yeni ekipman başarıyla eklendi");
                    System.out.println(result);
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="addNewTest"){
                String test = params[1];
                try {
                    result = stmt.executeUpdate("INSERT INTO project_names(name,"
                        + " addition_date, added_by) VALUES ('" + test + "',"
                        + "'"+modifiedDate+"','"+User.getUsername()+"')");
                    System.out.println("Yeni test başarıyla eklendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="addNewSurface"){
                String surface = params[1];
                try {
                    result = stmt.executeUpdate("INSERT INTO surface_condition(name,"
                        + " addition_date, added_by) VALUES ('" + surface + "',"
                        + "'"+modifiedDate+"','"+User.getUsername()+"')");
                    System.out.println("Yeni yüzey durumu başarıyla eklendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }
                } catch (Exception ex){
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } 
            }else if(type=="finduser"){         //admin'in kullanıcı değişikliği yaparken kullanıdığı
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM users WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    User.setDb_username((String) resultSet.getString("username"));
                    User.setDb_name((String) resultSet.getString("name"));
                    User.setDb_surname((String) resultSet.getString("surname"));
                    User.setDb_level((String) resultSet.getString("level"));
                    User.setDb_signature_expiry_date((String) resultSet.getString("signature_expiry_date"));
                }
                return true;
            }else if(type=="finduser2"){        //profil ekranı için
                resultSet = stmt.executeQuery("SELECT * FROM users WHERE username ='"+ User.getUsername() +"'");
                
                while(resultSet.next()){
                    User.setDb_User_id((String) resultSet.getString("id"));
                    User.setDb_name((String) resultSet.getString("name"));
                    User.setDb_surname((String) resultSet.getString("surname"));
                }
                return true;
            }else if(type=="findCustomer"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM customer WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    
                    Customer.setDb_cus_name((String) resultSet.getString("name"));
                    Customer.setDb_cus_place((String) resultSet.getString("place"));
                    Customer.setDb_cus_job((String) resultSet.getString("job_order_no"));
                    Customer.setDb_cus_offer((String) resultSet.getString("offer_no"));
                }
                return true;
            }else if(type=="findSurface"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM surface_condition WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Surface.setDb_surf_name((String) resultSet.getString("name"));
                }
                return true;
            }else if(type=="findEqui"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM equipment WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Equi.setDb_distanceOfLight((String) resultSet.getString("distance_of_light_mm"));
                    Equi.setDb_equi_name((String) resultSet.getString("name"));
                    Equi.setDb_magTech((String) resultSet.getString("mag_tech"));
                    Equi.setDb_mpTasiyici((String) resultSet.getString("mp_carrier_medium"));
                    Equi.setDb_poleDistance((String) resultSet.getString("pole_distance_mm"));
                    Equi.setDb_uvLightInte((String) resultSet.getString("uv_light_intensity_w_m2"));   
                }
                return true;
            }else if(type=="findTest"){
                String id = params[1];
                resultSet = stmt.executeQuery("SELECT * FROM project_names WHERE id = "+ id +"");
                
                while(resultSet.next()){
                    Test.setDb_test_name((String) resultSet.getString("name"));
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
                                + " added_by = '"+User.getUsername()+"' "
                                + "WHERE id = '"+User.getDb_User_id()+"'");
                        System.out.println("kullanıcı bilgileri güncellendi");
                        if(result==1){
                            return true;                       
                        }else{
                            return false;
                        }                        
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
                                + " added_by = '"+User.getUsername()+"' "
                                + "WHERE id = '"+User.getDb_User_id()+"'");
                        System.out.println("kullanıcı bilgileri güncellendi");
                        if(result==1){
                            return true;                       
                        }else{
                            return false;
                        }                         
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
                                + " added_by ='"+User.getUsername()+"' WHERE id = '"+User.getDb_id()+"'");
                        System.out.println("Kullanıcı bilgileri güncellendi");
                        if(result==1){
                            return true;                       
                        }else{
                            return false;
                        }                       
                    } catch (Exception ex) {
                            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                    }
                }
            }else if(type=="updateSurface"){
                String name = params[1];
                try {
                    result = stmt.executeUpdate("UPDATE surface_condition SET name = '" + name + "'"
                            + ", addition_date = '"+modifiedDate+"', added_by = '"+User.getUsername()+"'"
                            + "WHERE id = '"+Surface.getDb_surId()+"'");
                    System.out.println("Yüzey durumu bilgileri güncellendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateTest"){
                String name = params[1];
                try {
                    result = stmt.executeUpdate("UPDATE project_names SET name = '" + name + "'"
                            + ", addition_date = '"+modifiedDate+"', added_by = '"+User.getUsername()+"'"
                            + "WHERE id = '"+Test.getDb_testId()+"'");
                    System.out.println("Test bilgileri güncellendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateCustomer"){
                String name = params[1];
                String place = params[2];
                String job = params[3];
                String offer = params[4]; 
                try {
                    result = stmt.executeUpdate("UPDATE customer SET name = '" + name + "',"
                            + " place = '" + place + "' , job_order_no = '"+job+"' ,"
                            + " offer_no = '"+offer+"', addition_date = '"+modifiedDate+"',"
                            + " added_by = '"+User.getUsername()+"' "
                            + "WHERE id = '"+Customer.getDb_customerId()+"'");
                    System.out.println("Müşteri bilgileri güncellendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                         
                } catch (Exception ex) {
                        Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                }
            }else if(type=="updateEqui"){
                String name = params[1];
                String poleDis = params[2];
                String mag_tech = params[3];
                String uv_light_intensity_w_m2 = params[4];
                String distance_of_light  = params[5];
                String mp_carrier_medium = params[6];
                try {
                    result = stmt.executeUpdate("UPDATE equipment SET name = '" + name + "',"
                            + " pole_distance_mm = '" + poleDis + "' , mag_tech = '"+mag_tech+"' ,"
                            + " uv_light_intensity_w_m2 = '"+uv_light_intensity_w_m2+"',"
                            + " distance_of_light_mm = '"+distance_of_light+"',"
                            + " mp_carrier_medium = '"+mp_carrier_medium+"',"
                            + " addition_date = '"+modifiedDate+"',"
                            + " added_by = '"+User.getUsername()+"' "
                            + "WHERE id = '"+Equi.getDb_equiId()+"'");
                    System.out.println("Ekipman bilgileri güncellendi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                         
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
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                        
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
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                        
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
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                        
                } catch (Exception ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="customerDelete"){
                String deletedId =params[1];
                try {
                    result = stmt.executeUpdate("DELETE FROM customer "
                            + "WHERE id = '"+deletedId+"'");
                    System.out.println("Müşteri Silindi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                      
                } catch (Exception ex) {
                    Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else if(type=="equiDelete"){
                String deletedId =params[1];
                try {
                    result = stmt.executeUpdate("DELETE FROM equipment "
                            + "WHERE id = '"+deletedId+"'");
                    System.out.println("Ekipman Silindi");
                    if(result==1){
                        return true;                       
                    }else{
                        return false;
                    }                      
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
