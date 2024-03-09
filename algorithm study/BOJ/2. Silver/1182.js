// boj 1182 부분수열의 합
// backtracking :  dfs에서 뒤에서부터 모든 순열을 다 조합
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, s] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
let cnt = 0;

function dfs(sum, input) {
  if (sum === s && input !== 0) cnt++;
  if (input === n) return; //모든 수를 다 더한 경우
  for (let i = input; i < n; i++) dfs(sum + arr[i], i + 1); //해당 숫자가 들어감
}

dfs(0, 0);
console.log(cnt);

// -7
// -7 -3
// -7 -3 -2
// -7 -3 -2 5
// -7 -3 -2 5 8
// -7 -3 -2 8
// -7 -3 5
// -7 -3 5 8
// -7 -3 8
// -7 -2
// -7 -2 5
// -7 -2 5 8
// -7 -2 8
// -7 5
// -7 5 8
// -7 8
// -3
// -3 -2
// -3 -2 5
// -3 -2 5 8
// -3 -2 8
// -3 5
// -3 5 8
// -3 8
// -2
// -2 5
// -2 5 8
// -2 8
// 5
// 5 8
// 8
