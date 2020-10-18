package dfsbfs.타겟넘버;

class Solution {
    static int size, answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        dfs(numbers, 0, numbers[0], target);
        dfs(numbers, 0, -1 * numbers[0], target);
        return answer;
    }

    public void dfs(int[] numbers, int idx, int result, int target) {
        if (idx == size - 1 && result == target) {
            answer++;
        }
        if (idx + 1 < size) {
            dfs(numbers, idx + 1, result + numbers[idx + 1], target);
            dfs(numbers, idx + 1, result + -1 * numbers[idx + 1], target);
        }
    }
}