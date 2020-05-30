/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import java.util.Vector;


public class Strings {

    private static String option;                         //userOptions ekranında hangi tuşa tıklandığı için
    private static boolean okey1=false;
    private static boolean okey2=false;
    private static boolean okey3=false;
    private static boolean okey4=false;
    private static boolean okey5=false;


    public static void setOkey1(boolean okey1) {
        Strings.okey1 = okey1;
    }

    public static void setOkey2(boolean okey2) {
        Strings.okey2 = okey2;
    }

    public static void setOkey3(boolean okey3) {
        Strings.okey3 = okey3;
    }

    public static void setOkey4(boolean okey4) {
        Strings.okey4 = okey4;
    }

    public static void setOkey5(boolean okey5) {
        Strings.okey5 = okey5;
    }
     
    public static boolean getOkey1(){
        return okey1;
    }
    
    public static boolean getOkey2(){
        return okey2;
    }
    
    public static boolean getOkey3(){
        return okey3;
    }
    
    public static boolean getOkey4(){
        return okey4;
    }
    
    public static boolean getOkey5(){
        return okey5;
    }
    
    public static void setOption(String option) {
        Strings.option=option;
    }
    
    public static String getOption(){
        return option;
    }


}
