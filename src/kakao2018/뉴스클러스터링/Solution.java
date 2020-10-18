package kakao2018.뉴스클러스터링;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        return calJaccard(splitData(str1), splitData(str2));
    }

    public int calJaccard(String[] arr1, String[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        if (arr1Len == 0 && arr2Len == 0) {
            return 65536;
        } else {
            Set<String> dupCheck = new HashSet<>();
            Map<String, Integer> arr1Count = new HashMap<>();
            Map<String, Integer> arr2Count = new HashMap<>();
            for (String s : arr1) {
                arr1Count.merge(s, 1, Integer::sum);
                dupCheck.add(s);
            }
            for (String s : arr2) {
                arr2Count.merge(s, 1, Integer::sum);
                dupCheck.add(s);
            }
            int unionSize = 0;
            for (String s : dupCheck) {
                unionSize += Math.max(arr1Count.get(s) != null ? arr1Count.get(s) : 0, arr2Count.get(s) != null ? arr2Count.get(s) : 0);
            }
            int intersectionSize = arr1Len + arr2Len - unionSize;
            return (int) (((double) intersectionSize / (double) unionSize) * 65536);
        }
    }

    public String[] splitData(String str) {
        str = str.toLowerCase();
        ArrayList<String> result = new ArrayList<>();
        int strLen = str.length();
        for (int i = 0; i < strLen - 1; i++) {
            if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                result.add(str.charAt(i) + "" + str.charAt(i + 1));
            }
        }
        Object[] resultObj = result.toArray();
        String[] resultStr = new String[resultObj.length];
        for (int i = 0; i < resultObj.length; i++) {
            resultStr[i] = resultObj[i].toString();
        }
        return resultStr;
    }

    public boolean isAlphabet(char c) {
        return 65 <= c && c <= 90 || 97 <= c && c <= 122;
    }
}