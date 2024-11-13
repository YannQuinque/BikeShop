package fr.efrei.util;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty())
            return true;
        return false;
    }
}
