package hash.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> dressRoom = new HashMap<>();
        for (String[] clothe : clothes) {
            String dressClass = clothe[1];
            String dressName = clothe[0];
            if (dressRoom.get(dressClass) == null) {
                dressRoom.put(dressClass, new ArrayList<String>() {{
                    add(dressName);
                }});
            } else {
                ArrayList<String> list = dressRoom.get(dressClass);
                list.add(dressName);
                dressRoom.put(dressClass, list);
            }
        }
        int total = 1;
        for (Map.Entry<String, ArrayList<String>> elem : dressRoom.entrySet()) {
            total *= (elem.getValue().size() + 1);
        }
        return total - 1;
    }
}