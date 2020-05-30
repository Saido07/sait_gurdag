
package com.BIN;

import java.util.Vector;

public class User {
    private static Vector users = new Vector();
    private static String username;                       //O anda sistemi kullanan kişi
    private static String db_id=null;                     //kullanıcı ekleme ekranında combobox'tan seçilen kişinin id si burada
    private static String db_username = "";               //combobox'ta seçilen kişinin kullanıcı adı
    private static String db_signature_expiry_date = "";
    private static String db_name = "";
    private static String db_surname = "";
    private static String db_level = "";
    private static String db_User_id = "";                 //O anda kullanan kişinin id'si
    private static String db_Ope_id = "";
    private static String db_Deger_id = "";
    private static String db_Onay_id = "";

    public static String getDb_Deger_id() {
        return db_Deger_id;
    }

    public static String getDb_Ope_id() {
        return db_Ope_id;
    }

    public static String getDb_Onay_id() {
        return db_Onay_id;
    }

    public static void setDb_Ope_id(String db_Ope_id) {
        User.db_Ope_id = db_Ope_id;
    }

    public static void setDb_Deger_id(String db_Deger_id) {
        User.db_Deger_id = db_Deger_id;
    }

    public static void setDb_Onay_id(String db_Onay_id) {
        User.db_Onay_id = db_Onay_id;
    }
    
    public static String getDb_User_id() {
        return db_User_id;
    }

    public static void setDb_User_id(String db_User_id) {
        User.db_User_id = db_User_id;
    }
    
    
    public static void setUsers(String users) {
        User.users.add(users);
    }

    public static Vector getUsers() {
        return users;
    }
    
    public static void setDb_id(String db_id) {
        User.db_id = db_id;
    }

    public static String getDb_id() {
        return db_id;
    }
    
    public static void setUsername(String username){
        User.username=username;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static void setDb_name(String db_name) {
        User.db_name = db_name;
    }

    public static void setDb_level(String db_level) {
        User.db_level = db_level;
    }

    public static void setDb_signature_expiry_date(String db_signature_expiry_date) {
        User.db_signature_expiry_date = db_signature_expiry_date;
    }

    public static void setDb_surname(String db_surname) {
        User.db_surname = db_surname;
    }
    
    public static void setDb_username(String db_username) {
        User.db_username = db_username;
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
    

}
