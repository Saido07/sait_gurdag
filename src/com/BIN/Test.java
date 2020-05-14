
package com.BIN;

import java.util.Vector;

public class Test {
    private static Vector test = new Vector();
    private static String db_testId=null;
    private static String db_test_name = "";
    
    
    public static String getDb_test_name() {
        return db_test_name;
    }

    public static void setDb_test_name(String db_test_name) {
        Test.db_test_name = db_test_name;
    }
    
    public static Vector getTest() {
        return test;
    }

    public static void setTest(String test) {
        Test.test.add(test);
    }
    
    public static String getDb_testId() {
        return db_testId;
    }

    public static void setDb_testId(String db_testId) {
        Test.db_testId = db_testId;
    }
    
    


}
