/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;


public class Strings {
    private static String username;
    private static String option; //userOptions ekranında hangi tuşa tıklandığı için
    private static String leftType;
    private static int delete=0;

    public static int getDelete() {
        return delete;
    }

    public static void setDelete(int delete) {
        Strings.delete = delete;
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

}
