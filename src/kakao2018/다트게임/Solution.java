package kakao2018.다트게임;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solution("1S2D*3T");
    }
    public int solution(String dartResult) {
        int len = dartResult.length();
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    resultStack.add(stack.pop());
                    break;
                case 'D':
                    int p = stack.pop();
                    resultStack.add(p * p);
                    break;
                case 'T':
                    int pp = stack.pop();
                    resultStack.add(pp * pp * pp);
                    break;
                case '*':
                    int resultStackSize = resultStack.size();
                    if (resultStackSize == 1) {
                        resultStack.add(resultStack.pop() * 2);
                    } else {
                        int t = resultStack.pop() * 2;
                        resultStack.add(resultStack.pop() * 2);
                        resultStack.add(t);
                    }
                    break;
                case '#':
                    resultStack.add(resultStack.pop() * -1);
                    break;
                case '1':
                    if(i+1<len&&dartResult.charAt(i+1)=='0'){
                        stack.add(10);
                        i++;
                    } else {
                        stack.add(1);
                    }
                    break;
                default:
                    stack.add(dartResult.charAt(i)-'0');
            }
        }
        int stackSize=resultStack.size();
        for(int i=0; i<stackSize; i++){
            answer+=resultStack.pop();
        }
        return answer;
    }
}