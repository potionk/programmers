function solution(a, b) {
    let min = Math.min(a, b)
    let max = Math.max(a, b);
    let answer = 0;
    if (max >= 0 && min >= 0) {
        min--;
        answer = (max * (max + 1)) / 2 - (min * (min + 1)) / 2;
    } else if (max < 0 && min < 0) {
        min *= -1;
        max *= -1;
        max--;
        answer = -1 * ((min * (min + 1)) / 2 - (max * (max + 1)) / 2);
    } else {
        min *= -1;
        answer = (max * (max + 1)) / 2 - (min * (min + 1)) / 2;
    }
    return answer;
}

function test() {
    solution(-3, -5);
}