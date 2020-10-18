package stackqueue.다리를지나는트럭;

import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Data> movingTruck = new LinkedList<>();
        int waitTrucks = truck_weights.length;
        int time = 1;
        int truckIdx = 1;
        movingTruck.add(new Data(-1, truck_weights[0]));
        waitTrucks--;
        int curMovingTrucksWeight = truck_weights[0];
        while (waitTrucks > 0 || !movingTruck.isEmpty()) {
            int curSize = movingTruck.size();
            int pollCount = 0;
            for (int i = 0; i < curSize; i++) {
                Data truck = movingTruck.get(i);
                int next = truck.getCurTime() + 1;
                if (next == bridge_length) {
                    curMovingTrucksWeight -= truck.getData();
                    pollCount++;
                } else {
                    movingTruck.get(i).setCurTime(truck.getCurTime() + 1);
                }
            }
            for (int i = 0; i < pollCount; i++) {
                movingTruck.poll();
            }
            if (waitTrucks == 0 && movingTruck.isEmpty()) {
                break;
            }
            if (truckIdx < truck_weights.length && truck_weights[truckIdx] + curMovingTrucksWeight <= weight) {
                curMovingTrucksWeight += truck_weights[truckIdx];
                movingTruck.add(new Data(0, truck_weights[truckIdx++]));
                waitTrucks--;
            }
            time++;

        }
        int answer = time;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 10, new int[]{7,4,5,6});
    }

}

class Data {
    private int curTime;
    private int data;

    public int getCurTime() {
        return curTime;
    }

    public void setCurTime(int curTime) {
        this.curTime = curTime;
    }

    public int getData() {
        return data;
    }

    public Data(int curTime, int data) {
        this.curTime = curTime;
        this.data = data;
    }
}