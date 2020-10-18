package dfsbfs.네트워크;

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] network;
    static boolean[] isVisited;

    public int solution(int n, int[][] computers) {
        network = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    network[i].add(j);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int vertex) {
        isVisited[vertex] = true;
        for (int i = 0; i < network[vertex].size(); i++) {
            int nextVertex = network[vertex].get(i);
            if (!isVisited[nextVertex]) {
                dfs(nextVertex);
            }
        }
    }
}