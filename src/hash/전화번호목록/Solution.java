package hash.전화번호목록;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        Map<String, Integer> dupCheck = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            if (dupCheck.get(phone_book[i]) != null) {
                return false;
            }
            dupCheck.put(phone_book[i], 1);
            int thisLen = phone_book[i].length();
            for (int j = i + 1; j < phone_book.length; j++) {
                String t = phone_book[j].substring(0, thisLen);
                if (dupCheck.get(t) != null) {
                    return false;
                }
            }
        }
        return true;
    }
}