function solution(n) {
    let answer = 0;
    let primeNum = new Array(n + 1).fill(true);
    for (let i = 2; i * i <= n; i++) {
        if (primeNum[i]) {
            for (let j = i + i; j <= n; j += i) {
                primeNum[j] = false;
            }
        }
    }
    for (let i = 2; i < n + 1; i++) {
        if (primeNum[i]) {
            answer++;
        }
    }
    return answer;
}

function test() {
    let result = solution(10);
}