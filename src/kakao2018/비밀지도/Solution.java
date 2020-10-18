package kakao2018.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] solvedArr1 = new boolean[n][n];
        boolean[][] solvedArr2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String solved1 = unifyFormat(Integer.toBinaryString(arr1[i]), n);
            String solved2 = unifyFormat(Integer.toBinaryString(arr2[i]), n);
            for (int j = 0; j < n; j++) {
                solvedArr1[i][j] = solved1.charAt(j) == '1';
                solvedArr2[i][j] = solved2.charAt(j) == '1';
            }
        }
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((solvedArr1[i][j] || solvedArr2[i][j]) ? "#" : " ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public String unifyFormat(String binaryStr, int n) {
        int len = binaryStr.length();
        if (len == n) {
            return binaryStr;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - len; i++) {
                sb.append("0");
            }
            sb.append(binaryStr);
            return sb.toString();
        }
    }
}