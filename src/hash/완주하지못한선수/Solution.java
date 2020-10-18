package hash.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> state = new HashMap<>();
        for (String s : participant) {
            state.merge(s, 1, Integer::sum);
        }
        for (String s : completion) {
            if (state.get(s) == 1) {
                state.remove(s);
            } else {
                state.put(s, state.get(s) - 1);
            }
        }
        return (String) state.keySet().toArray()[0];
    }
}