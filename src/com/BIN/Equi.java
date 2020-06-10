
package com.BIN;

import java.util.Vector;

public class Equi {
    private static Vector equi = new Vector();
    private static Vector equi2 = new Vector();
    private static String db_equiId=null;
    private static String db_equi_name = "";
    private static String db_poleDistance = "";
    private static String db_magTech = "";
    private static String db_uvLightInte = "";
    private static String db_distanceOfLight = "";
    private static String db_mpTasiyici = "";

    public static String getDb_mpTasiyici() {
        return db_mpTasiyici;
    }

    public static void setDb_mpTasiyici(String db_mpTasiyici) {
        Equi.db_mpTasiyici = db_mpTasiyici;
    }

    public static void setDb_distanceOfLight(String db_distanceOfLight) {
        Equi.db_distanceOfLight = db_distanceOfLight;
    }

    public static void setDb_magTech(String db_magTech) {
        Equi.db_magTech = db_magTech;
    }

    public static void setDb_poleDistance(String db_poleDistance) {
        Equi.db_poleDistance = db_poleDistance;
    }

    public static void setDb_uvLightInte(String db_uvLightInte) {
        Equi.db_uvLightInte = db_uvLightInte;
    }

    public static String getDb_distanceOfLight() {
        return db_distanceOfLight;
    }

    public static String getDb_magTech() {
        return db_magTech;
    }

    public static String getDb_poleDistance() {
        return db_poleDistance;
    }

    public static String getDb_uvLightInte() {
        return db_uvLightInte;
    }
    
    public static Vector getEqui() {
        return equi;
    }

    public static void setDb_equi_name(String db_equi_name) {
        Equi.db_equi_name = db_equi_name;
    }

    public static String getDb_equi_name() {
        return db_equi_name;
    }
    
    public static void setEqui(String equi) {
        Equi.equi.add(equi);
    }
    
    public static void setEqui2(String equi) {
        Equi.equi2.add(equi);
    }
    
    public static Vector getEqui2() {
        return equi2;
    }
    
    public static String getDb_equiId() {
        return db_equiId;
    }

    public static void setDb_equiId(String db_equiId) {
        Equi.db_equiId = db_equiId;
    }
    
    

}
