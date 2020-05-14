package com.BIN;

import java.util.Vector;

public class Surface {
    private static Vector surface = new Vector();
    private static String db_surId=null;
    private static String db_surf_name = "";
    
    public static Vector getSurface() {
        return surface;
    }
    
    public static void setSurface(String surface) {
        Surface.surface.add(surface);
    }
    
    public static String getDb_surId() {
        return db_surId;
    }

    public static void setDb_surId(String db_surId) {
        Surface.db_surId = db_surId;
    }
    
    public static void setDb_surf_name(String db_surf_name) {
        Surface.db_surf_name = db_surf_name;
    }

    public static String getDb_surf_name() {
        return db_surf_name;
    }
    
}
