/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String searchPrepocessor(String s) {
        if (s != null) {
            return s
                    .toLowerCase()
                    .trim()
                    //            .replaceAll("([`~!@#$%^&*()-_=+[{]};:',<.>/?])", " ")
                    .replaceAll("\\s+", " ");
        } else {
            return "";
        }
    }

    public static String encrypt(String password) {
        String encryptedpassword = "";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int asciiValue = (int) c;
            String asciiString = String.format("%03d", asciiValue); // Thêm chữ số 0 vào trước mã ASCII nếu nó chỉ có 2 chữ số
            String indexString = String.format("%02d", i + 1); // Thêm chữ số 0 vào trước số thứ tự nếu nó nhỏ hơn 10
            encryptedpassword += indexString + asciiString;
        }

        return encryptedpassword;
    }

    public static String decrypt(String encryptedpassword) {
        String decryptedpassword = "";
        // Tách chuỗi số thành từng bộ 5 số
        for (int i = 0; i < encryptedpassword.length(); i += 5) {
            String subString = encryptedpassword.substring(i, i + 5);
            String asciiString = decrypthelper(subString);
            decryptedpassword += asciiString;
        }

        return decryptedpassword;
    }

    public static String decrypthelper(String encryptedpassword) {
        int asciiValue = Integer.parseInt(encryptedpassword.substring(2, 5));
        char c = (char) asciiValue;
        return Character.toString(c);
    }

    public static List<String> splitString(String s) {
        List<String> ans = new ArrayList<>();

        return ans;
    }
}
