package com.BIN;

import java.util.Vector;

public class Customer {
    private static Vector customers = new Vector();
    private static Vector customers2 = new Vector();
    private static String db_customerId=null;
    private static String db_cus_name = "";
    private static String db_cus_place = "";
    private static String db_cus_job = "";
    private static String db_cus_offer = "";
    
    public static void setDb_cus_job(String db_cus_job) {
        Customer.db_cus_job = db_cus_job;
    }

    public static void setDb_cus_name(String db_cus_name) {
        Customer.db_cus_name = db_cus_name;
    }

    public static void setDb_cus_offer(String db_cus_offer) {
        Customer.db_cus_offer = db_cus_offer;
    }

    public static void setDb_cus_place(String db_cus_place) {
        Customer.db_cus_place = db_cus_place;
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
    
    public static void setCustomers(String customers) {
        Customer.customers.add(customers);
    }
    
    public static Vector getCustomers() {
        return customers;
    }
    
    public static void setCustomers2(String customers) {
        Customer.customers2.add(customers);
    }
    
    public static Vector getCustomers2() {
        return customers2;
    }
    
    public static String getDb_customerId() {
        return db_customerId;
    }

    public static void setDb_customerId(String db_customerId) {
        Customer.db_customerId = db_customerId;
    }
}
