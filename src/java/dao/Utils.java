/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    public static String searchPrepocessor(String s){
        return s
            .toLowerCase()
            .trim()
//            .replaceAll("([`~!@#$%^&*()-_=+[{]};:',<.>/?])", " ")
            .replaceAll("\\s+", " ");
    }
    public static String encryptPassword(String password){
        String ans = "";
        //logic
        return ans;
    }
    public static String decryptPassword(String password){
        String ans = "";
        //logic
        return ans;
    }
    public static List<String> splitString(String s){
        List<String> ans = new ArrayList<>();
        
        return ans;
    }
}
