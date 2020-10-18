package kakao2018.셔틀버스;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int arriveTime = unifyTimeFormat(9, 0);
        int[] timeTableInt = new int[timetable.length];
        for (int i = 0; i < timeTableInt.length; i++) {
            String[] tt = timetable[i].split(":");
            timeTableInt[i] = unifyTimeFormat(Integer.parseInt(tt[0]), Integer.parseInt(tt[1]));
        }
        Arrays.sort(timeTableInt);
        LinkedList<Integer> waitQueue = new LinkedList<>();
        for (int i = 0; i < timeTableInt.length; i++) {
            waitQueue.add(timeTableInt[i]);
        }
        boolean isGoTime = false;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                isGoTime = true;
            }
            for (int j = 0; j < m; j++) {
                if (waitQueue.isEmpty()) {
                    break;
                }
                if (waitQueue.peek() <= arriveTime) {
                    if (isGoTime && j == m - 1) {
                        return timeToString(waitQueue.peek() - 1);
                    }
                    waitQueue.poll();
                } else {
                    break;
                }
            }
            if (isGoTime) {
                return timeToString(arriveTime);
            }
            arriveTime += t;
        }
        String answer = "";
        return answer;
    }

    public int unifyTimeFormat(int hour, int min) {
        return hour * 60 + min;
    }

    public String timeToString(int time) {
        return unifyStringFormat(time / 60) + ":" + unifyStringFormat(time % 60);
    }

    public String unifyStringFormat(int s) {
        if (s < 10) {
            return "0" + s;
        } else {
            return s + "";
        }
    }
}