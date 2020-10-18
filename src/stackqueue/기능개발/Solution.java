package stackqueue.기능개발;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int finishCount = 0;
        int size = progresses.length;
        List<Integer> list = new ArrayList<>();
        while (finishCount < size) {
            for (int i = finishCount; i < size; i++) {
                progresses[i] += speeds[i];
            }
            if (progresses[finishCount] >= 100) {
                int count = 1;
                finishCount++;
                while (finishCount< size && progresses[finishCount] >= 100) {
                    finishCount++;
                    count++;
                }
                list.add(count);
            }
        }
        int listSize = list.size();
        int[] answer = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}