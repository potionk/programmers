package greedy.큰수만들기;

class Solution {
    public String solution(String number, int k) {
        int finish = k+1;
        char[] numberArr = number.toCharArray();
        int numberLen = numberArr.length;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberLen - k; i++) {
            int max = -1;
            for (int j = start; j < finish; j++) {
                if (max < numberArr[j]) {
                    max = numberArr[j];
                    start = j + 1;
                }
            }
            sb.append((char) max);
            finish++;
        }
        return sb.toString();
    }
}