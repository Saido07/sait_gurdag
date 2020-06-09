/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import java.util.Vector;


public class Strings {
    private static String MusName="";
    private static String option;                         //userOptions ekranında hangi tuşa tıklandığı için
    private static int List=0;
    private static boolean okey1=false;
    private static boolean okey2=false;
    private static boolean okey3=false;
    private static boolean okey4=false;
    private static boolean okey5=false;
    private static boolean isSearch=false;
    private static String listBack="";                         //listede geri tuşunun çalışması için
    private static String searchedText="";
    private static String searched2Text="";

    public static String getSearched2Text() {
        return searched2Text;
    }
    
    public static String getSearchedText() {
        return searchedText;
    }
    
    public static void setSearchedText(String searchedText) {
        Strings.searchedText = searchedText;
        Strings.searched2Text = searchedText.substring(0,1).toUpperCase() + searchedText.substring(1);
    }
    
    public static boolean isSearch() {
        return isSearch;
    }

    public static void isSearch(boolean isSearch) {
        Strings.isSearch = isSearch;
    }
    
    public static String getListBack() {
        return listBack;
    }

    public static void setListBack(String listBack) {
        Strings.listBack = listBack;
    }
    
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

    public static void setList(int List) {
        Strings.List = List;
    }

    public static int getList() {
        return List;
    }
    
    public static String getMusName() {
        return MusName;
    }

    public static void setMusName(String MusName) {
        Strings.MusName = MusName;
    }
    
    public static void setOption(String option) {
        Strings.option=option;
    }
    
    public static String getOption(){
        return option;
    }


}
