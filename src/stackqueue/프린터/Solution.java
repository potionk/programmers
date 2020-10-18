package stackqueue.프린터;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Data> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Data(priorities[i], i));
        }
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        int count = 1;
        while (true) {
            Data p = queue.poll();
            if (p.getData() == priorities[idx]) {
                if (p.getIdx() == location) {
                    break;
                }
                count++;
                idx--;
            }
            queue.add(p);
        }
        int answer = count;
        return answer;
    }
}

class Data {
    int data;
    int idx;

    public int getData() {
        return data;
    }

    public int getIdx() {
        return idx;
    }

    public Data(int data, int idx) {
        this.data = data;
        this.idx = idx;
    }
}