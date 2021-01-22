function solution(s) {
    if (isNaN(s)) {
        return false;
    }
    return (1000 <= s && s <= 9999) || (100000 <= s && s <= 999999);
}

function test() {
    let result = solution("1234");
}