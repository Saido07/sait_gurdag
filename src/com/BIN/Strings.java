/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import java.util.Vector;


public class Strings {

    private static String option;                         //userOptions ekranında hangi tuşa tıklandığı için


    public static void setOption(String option) {
        Strings.option=option;
    }
    
    public static String getOption(){
        return option;
    }


}
