function solution(arr) {
    let answer = [];
    for (let i = 0; i < arr.length; i++) {
        answer.push(arr[i]);
        let nextIdx = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] === arr[j]) {
                nextIdx++;
            } else {
                break;
            }
        }
        i = nextIdx;
    }
    return answer;
}

function test() {
    solution([1,1,3,3,0,1,1]);
}