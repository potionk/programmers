function solution(s) {
    let pCount = 0, yCount = 0;
    s = s.toLowerCase();
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) == 'p') {
            pCount++;
        } else if (s.charAt(i) == 'y') {
            yCount++;
        }
    }
    var answer = pCount == yCount;
    return answer;
}

function test() {
    solution("pPoooyY");
}