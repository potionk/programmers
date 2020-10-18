package bruteforce.모의고사;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] answerPaper = new int[3][answers.length];
        for (int i = 0; i < answers.length; i++) {
            answerPaper[0][i] = (i % 5) + 1;
        }
        for (int i = 0; i < answers.length; i++) {
            answerPaper[1][i] = two[i % 8];
        }
        for (int i = 0; i < answers.length; i++) {
            answerPaper[2][i] = three[i % 10];
        }
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int j = 0; j < 3; j++) {
                if (answerPaper[j][i] == answer) {
                    score[j]++;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, score[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }
        Object[] answerObj = list.toArray();
        int[] answer = new int[answerObj.length];
        for (int i = 0; i < answerObj.length; i++) {
            answer[i] = (int) answerObj[i];
        }
        return answer;
    }
}