package bruteforce.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int yMulx = brown + yellow;
        double rootYMulX = Math.sqrt(yMulx);
        for (int i = 2; i <= rootYMulX; i++) {
            double j = (double) yMulx / (double) i;
            if (j % 1 != 0) {
                continue;
            }
            if (i * 2 + j * 2 - 4 == brown) {
                return new int[]{(int) j, i};
            }
        }
        return null;
    }
}