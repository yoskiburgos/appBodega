package com.gloria.gloriabnsservvalidarcliente.utils;

public class Validar {
    
    public static boolean onlyDigits(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

}
