// boj 11054 가장 긴 바이토닉 부분 수열
// dp
// https://yabmoons.tistory.com/143

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = parseInt(input[0]);
let arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0);
let dp = new Array(n + 1).fill(0);
let dp2 = new Array(n + 1).fill(0);

// 증가 수열
for (let i = 1; i <= n; i++) {
  dp[i] = 1;
  for (let j = 1; j <= i; j++) {
    // 현재 인덱스 i보다 작은 인덱스 값들과 비교
    // 1. 현재 인덱스의 값보다 작은지
    // 2. 해당 작은 값을 선택했을 때 최대 길이가 될 수 있는지
    if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
  }
}

// 감소 수열
for (let i = n; i >= 1; i--) {
  dp2[i] = 1;
  for (let j = n; j >= i; j--) {
    // 현재 인덱스 i보다 작은 인덱스 값들과 비교
    // 1. 현재 인덱스의 값보다 큰지
    // 2. 해당 큰 값을 선택했을 때 최대 길이가 될 수 있는지
    if (arr[i] > arr[j] && dp2[j] + 1 > dp2[i]) dp2[i] = dp2[j] + 1;
  }
}

let max = -1;
for (let i = 1; i <= n; i++) max = Math.max(max, dp[i] + dp2[i] - 1);
console.log(max);
