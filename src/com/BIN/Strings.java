/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import fxmlController.userLoginController;
import java.util.Vector;


public class Strings {
    private static String username;
    private static String option; //userOptions ekranında hangi tuşa tıklandığı için
    private static Vector users = new Vector();

    
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
