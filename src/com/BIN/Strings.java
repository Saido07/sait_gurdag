/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import fxmlController.userLoginController;
import java.util.Vector;


public class Strings {
    private static String username;
    private static String option; //userOptions ekranında hangi tuşa tıklandığı için
    private static Vector users = new Vector();
    private static String db_id=null;
    private static String db_username = "";
    private static String db_signature_expiry_date = "";
    private static String db_name = "";
    private static String db_surname = "";
    private static String db_level = "";

    public static void setDb_id(String db_id) {
        Strings.db_id = db_id;
    }

    public static String getDb_id() {
        return db_id;
    }

    public static void setDb_name(String db_name) {
        Strings.db_name = db_name;
    }

    public static void setDb_level(String db_level) {
        Strings.db_level = db_level;
    }

    public static void setDb_signature_expiry_date(String db_signature_expiry_date) {
        Strings.db_signature_expiry_date = db_signature_expiry_date;
    }

    public static void setDb_surname(String db_surname) {
        Strings.db_surname = db_surname;
    }

    public static void setDb_username(String db_username) {
        Strings.db_username = db_username;
    }

    public static String getDb_level() {
        return db_level;
    }

    public static String getDb_name() {
        return db_name;
    }

    public static String getDb_signature_expiry_date() {
        return db_signature_expiry_date;
    }

    public static String getDb_surname() {
        return db_surname;
    }

    public static String getDb_username() {
        return db_username;
    }
    
    public static void setUsername(String username){
        Strings.username=username;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static void setOption(String option) {
        Strings.option=option;
    }
    
    public static String getOption(){
        return option;
    }

    public static void setUsers(String users) {
        Strings.users.add(users);
    }

    public static Vector getUsers() {
        return users;
    }
    
    
    
    

}
