// boj 1463 1로 만들기
// dp

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = parseInt(input[0]);
let dp = [];
dp.push(0);
dp.push(0);

// n을 1로 만들기 위해 필요한 최소 횟수는
// 1. n - 1을 1로 만들기 위한 최소횟수 + 1
// 또는
// 2. 2나 3으로 나누어지면, 나눠지고 남은 몫의 경우의 연산 + 1
for (let i = 2; i <= n; i++) {
  dp[i] = dp[i - 1] + 1;
  if (i % 2 === 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
  if (i % 3 === 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
}

console.log(dp[n]);
