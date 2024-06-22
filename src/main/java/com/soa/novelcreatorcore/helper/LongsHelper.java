package com.soa.novelcreatorcore.helper;

public class LongsHelper {
    public static Long getLongFromString(String str) {
        try {
            return Long.valueOf(str);
        } catch (Exception e) {
        }
        return null;
    }
}
