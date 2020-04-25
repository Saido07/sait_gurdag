/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import java.util.Vector;


public class Strings {
    private static String username;
    private static String option; //userOptions ekranında hangi tuşa tıklandığı için
    private static Vector users = new Vector();
    private static Vector test = new Vector();
    private static Vector equi = new Vector();
    private static Vector customers = new Vector();
    private static Vector surface = new Vector();
    private static String db_id=null;
    private static String db_surId=null;
    private static String db_customerId=null;
    private static String db_equiId=null;
    private static String db_testId=null;
    private static String db_username = "";
    private static String db_username2 = "";                        //profil ekranı için gerekenle kullanıcı ekleme ekranındaki usernameler karıştığı için
    private static String db_signature_expiry_date = "";
    private static String db_name = "";
    private static String db_surname = "";
    private static String db_level = "";
    private static String db_surf_name = "";
    private static String db_cus_name = "";
    private static String db_cus_place = "";
    private static String db_cus_job = "";
    private static String db_cus_offer = "";
    private static String db_test_name = "";
    private static String db_User_id = "";

    public static String getDb_User_id() {
        return db_User_id;
    }

    public static void setDb_User_id(String db_User_id) {
        Strings.db_User_id = db_User_id;
    }
    
    

    public static String getDb_test_name() {
        return db_test_name;
    }

    public static void setDb_test_name(String db_test_name) {
        Strings.db_test_name = db_test_name;
    }
    
    

    public static void setDb_username2(String db_username2) {
        Strings.db_username2 = db_username2;
    }

    public static String getDb_username2() {
        return db_username2;
    }

    public static void setDb_cus_job(String db_cus_job) {
        Strings.db_cus_job = db_cus_job;
    }

    public static void setDb_cus_name(String db_cus_name) {
        Strings.db_cus_name = db_cus_name;
    }

    public static void setDb_cus_offer(String db_cus_offer) {
        Strings.db_cus_offer = db_cus_offer;
    }

    public static void setDb_cus_place(String db_cus_place) {
        Strings.db_cus_place = db_cus_place;
    }

    public static String getDb_cus_job() {
        return db_cus_job;
    }

    public static String getDb_cus_name() {
        return db_cus_name;
    }

    public static String getDb_cus_offer() {
        return db_cus_offer;
    }

    public static String getDb_cus_place() {
        return db_cus_place;
    }

    
    public static void setDb_surf_name(String db_surf_name) {
        Strings.db_surf_name = db_surf_name;
    }

    public static String getDb_surf_name() {
        return db_surf_name;
    }

    public static Vector getCustomers() {
        return customers;
    }

    public static Vector getEqui() {
        return equi;
    }

    public static Vector getSurface() {
        return surface;
    }

    public static Vector getTest() {
        return test;
    }

    public static void setTest(String test) {
        Strings.test.add(test);
    }

    public static void setCustomers(String customers) {
        Strings.customers.add(customers);
    }

    public static void setEqui(String equi) {
        Strings.equi.add(equi);
    }

    public static void setSurface(String surface) {
        Strings.surface.add(surface);
    }

    public static String getDb_customerId() {
        return db_customerId;
    }

    public static void setDb_customerId(String db_customerId) {
        Strings.db_customerId = db_customerId;
    }

    public static String getDb_equiId() {
        return db_equiId;
    }

    public static void setDb_equiId(String db_equiId) {
        Strings.db_equiId = db_equiId;
    }

    public static String getDb_surId() {
        return db_surId;
    }

    public static void setDb_surId(String db_surId) {
        Strings.db_surId = db_surId;
    }

    public static String getDb_testId() {
        return db_testId;
    }

    public static void setDb_testId(String db_testId) {
        Strings.db_testId = db_testId;
    }

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
