package stackqueue.주식가격;

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        boolean[] isFinish = new boolean[prices.length];
        stack.push(prices[0]);
        for(int i=0; i<prices.length; i++){
            answer[i]=1;
        }
        for (int i = 1; i < prices.length; i++) {
            int stackSize = stack.size();
            for (int j = i-1; j < stackSize; j++) {
                if (!isFinish[j] && stack.get(j) <= prices[i]) {
                    answer[j]++;
                } else {
                    isFinish[j] = true;
                    if (answer[j] == 0) {
                        answer[j] = 1;
                    }
                }
            }
            stack.push(prices[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{5, 5, 6, 6, 1});
    }
}