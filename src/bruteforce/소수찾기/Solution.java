package bruteforce.소수찾기;

import java.util.Arrays;

class Solution {
    public int solution(String numbers) {
        int len = numbers.length();
        int answer = 0;
        int[] integerNumbers = new int[numbers.length()];
        for (int i = 0; i < len; i++) {
            integerNumbers[i] = numbers.charAt(i) - '0';
        }
        Arrays.sort(integerNumbers);
        StringBuilder maxSb = new StringBuilder();
        for (int i = integerNumbers.length - 1; i >= 0; i--) {
            maxSb.append(integerNumbers[i]);
        }
        int[] numbersCount = countNum(numbers);
        int max = Integer.parseInt(maxSb.toString());
        boolean[] primeNum = new boolean[max];
        primeNum[0] = true;
        for (int i = 1; i < max; i++) {
            if (!primeNum[i]) {
                for (int j = (i + 1) * 2 - 1; j < max; j += i + 1) {
                    primeNum[j] = true;
                }
            }
        }
        for (int i = 1; i < max; i++) {
            if (!primeNum[i]) {
                int[] thisCount = countNum((i + 1) + "");
                if (isValid(numbersCount, thisCount)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int[] countNum(String a) {
        int[] count = new int[10];
        int len = a.length();
        for (int i = 0; i < len; i++) {
            count[a.charAt(i) - '0']++;
        }
        return count;
    }

    public static boolean isValid(int[] numbersCount, int[] thisCount) {
        for (int i = 0; i < 10; i++) {
            if (numbersCount[i] < thisCount[i]) {
                return false;
            }
        }
        return true;
    }
}