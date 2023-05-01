/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    public String searchPrepocessor(String s){
            s=s.toLowerCase();
            s=s.trim();
            s=s.replaceAll("([`~!@#$%^&*()-_=+[{]};:',<.>/?])", " ");
            s=s.replaceAll("\\s+", " ");
        return s;
    }
    public String encryptPassword(String password){
        String ans = "";
        //logic
        return ans;
    }
    public String decryptPassword(String password){
        String ans = "";
        //logic
        return ans;
    }
    public List<String> splitString(String s){
        List<String> ans = new ArrayList<>();
        
        return ans;
    }
}
