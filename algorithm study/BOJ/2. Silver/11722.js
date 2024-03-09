// boj 11722 가장 긴 감소하는 부분 수열
// dp
// https://yabmoons.tistory.com/112

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = parseInt(input[0]);
let arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0);
let dp = new Array(n + 1).fill(0); //인덱스까지의 최대 길이
// console.log(n);
// console.log(arr);

for (let i = 1; i <= n; i++) {
  dp[i] = 1;
  for (let j = 1; j <= i; j++) {
    // 현재 인덱스 i보다 작은 인덱스 값들과 비교
    // 1. 현재 인덱스의 값보다 큰지
    // 2. 해당 큰 값을 선택했을 때 최대 길이가 될 수 있는지
    if (arr[i] < arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
  }
}
// console.log(dp);

let max = -1;
for (let i = 1; i <= n; i++) max = Math.max(max, dp[i]);
console.log(max);
