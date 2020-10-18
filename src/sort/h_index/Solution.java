package sort.h_index;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int quotedNum = citations.length - i;
            if (citations[i] >= quotedNum) {
                max = Math.max(max, quotedNum);
            }
        }
        return max;
    }
}