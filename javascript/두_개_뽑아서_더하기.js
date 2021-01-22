function solution(numbers) {
    let arr = [];
    for (let i = 0; i < numbers.length; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            arr.push(numbers[i] + numbers[j]);
        }
    }
    let set = new Set(arr);
    var answer = [...set];
    answer.sort(function (a, b) {
        return a - b;
    });
    return answer;
}

function test() {
    let numbers = [2, 1, 3, 4, 1];
    solution(numbers);
}