// 65130500073 - Watchara Santawee
package dev.bestzige.int202midexam.utils;

public class StringUtils {
    public static boolean stringValidation(String str) {
        if(str == null || str.isEmpty() || str.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
