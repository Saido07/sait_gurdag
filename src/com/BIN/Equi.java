
package com.BIN;

import java.util.Vector;

public class Equi {
    private static Vector equi = new Vector();
    private static String db_equiId=null;
    
    public static Vector getEqui() {
        return equi;
    }
    
    public static void setEqui(String equi) {
        Equi.equi.add(equi);
    }
    
    public static String getDb_equiId() {
        return db_equiId;
    }

    public static void setDb_equiId(String db_equiId) {
        Equi.db_equiId = db_equiId;
    }
    
    

}
