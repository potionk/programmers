package kakao2018.캐시;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> cache = new HashSet<>();
        int citiesLen = cities.length;
        int answer = 0;
        for (int i = 0; i < citiesLen; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                int idx = 0;
                for (String q : queue) {
                    if (q.equals(city)) {
                        queue.remove(idx);
                        break;
                    }
                    idx++;
                }
                queue.add(city);
                answer++;
            } else {
                int queueSize = queue.size();
                if (queueSize == cacheSize) {
                    cache.remove(queue.poll());
                }
                queue.add(city);
                cache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}