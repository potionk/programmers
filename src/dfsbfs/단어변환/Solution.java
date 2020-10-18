package dfsbfs.단어변환;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;

    public int solution(String begin, String target, String[] words) {
        graph = new ArrayList[words.length];
        List<Integer> availIdx = new ArrayList<>();
        int targetIdx = -1;
        boolean isAvail = false;
        int wordLen = words[0].length();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                targetIdx = i;
                isAvail = true;
            }
            int diffCount = 0;
            boolean isNext = true;
            for (int k = 0; k < wordLen; k++) {
                if (begin.charAt(k) != words[i].charAt(k)) {
                    diffCount++;
                }
                if (diffCount >= 2) {
                    isNext = false;
                    break;
                }
            }
            if (isNext) {
                availIdx.add(i);
            }
        }
        if (!isAvail) {
            return 0;
        }
        for (int i = 0; i < words.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int diffCount = 0;
                boolean isNext = true;
                for (int k = 0; k < wordLen; k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        diffCount++;
                    }
                    if (diffCount >= 2) {
                        isNext = false;
                        break;
                    }
                }
                if (isNext) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (Integer idx : availIdx) {
            isVisited = new boolean[words.length];
            answer = Math.min(bfs(idx, targetIdx), answer);
        }
        return answer;
    }

    public static int bfs(int vertex, int targetIdx) {
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(vertex, 1));
        isVisited[vertex] = true;
        while (queue.size() != 0) {
            Data d = queue.poll();
            int p = d.getData();
            int count = d.getCount();
            int size = graph[p].size();
            if (p == targetIdx) {
                return count;
            }
            for (int i = 0; i < size; i++) {
                int nextVertex = graph[p].get(i);
                if (!isVisited[nextVertex]) {
                    queue.add(new Data(nextVertex, count + 1));
                    isVisited[nextVertex] = true;
                }
            }
        }
        return 0;
    }
}

class Data {
    int data;
    int count;

    public int getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public Data(int data, int count) {
        this.data = data;
        this.count = count;
    }
}