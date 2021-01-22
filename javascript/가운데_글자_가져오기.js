function solution(s) {
    var answer;
    if (s.length % 2 == 0) {
        answer = s.charAt(s.length / 2 - 1) + s.charAt(s.length / 2);
    } else {
        answer = s.charAt(s.length / 2);
    }
    return answer;
}

function test() {
    solution("abde");
}