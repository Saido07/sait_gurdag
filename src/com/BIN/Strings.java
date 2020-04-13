/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import sun.tools.tree.ThisExpression;

/**
 *
 * @author sait_
 */
public class Strings {
    private static String username;
    private static String option; //userOptions ekranında hangi tuşa tıklandığı için
    
    
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
