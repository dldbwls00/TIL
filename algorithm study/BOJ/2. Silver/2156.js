// boj 2156 포도주 시식
// dp
// https://yabmoons.tistory.com/512

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = new Array(n).fill(0);
for (let i = 0; i < n; i++) arr[i] = parseInt(input[i + 1]);
arr.splice(0, 0, 0);

let dp = new Array(n + 1).fill(0);
dp[1] = arr[1];
dp[2] = arr[1] + arr[2];

for (let i = 3; i <= n; i++) {
  const case1 = dp[i - 1]; //oox
  const case2 = dp[i - 3] + arr[i - 1] + arr[i]; //xoo
  const case3 = dp[i - 2] + arr[i]; //oxo
  dp[i] = Math.max(case1, case2, case3);
}
console.log(dp[n]);
