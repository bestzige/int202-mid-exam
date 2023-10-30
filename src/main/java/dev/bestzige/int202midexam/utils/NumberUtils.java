// 65130500073 - Watchara Santawee
package dev.bestzige.int202midexam.utils;

public class NumberUtils {
    public static boolean isPrimerNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}
