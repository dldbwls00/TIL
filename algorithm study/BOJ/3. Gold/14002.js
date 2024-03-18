// boj 14002 가장 긴 증가하는 부분 수열 4
// tree traversal, two pointer, LIS
// dp: 비슷한 문제: https://www.acmicpc.net/problem/11722

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
const arr = input[1].split(" ").map(Number);

arr.splice(0, 0, 0);
let dp = new Array(n + 1).fill(0); //인덱스까지의 최대 길이

for (let i = 1; i <= n; i++) {
  dp[i] = 1;
  for (let j = 1; j <= i; j++) {
    // 현재 인덱스 i보다 작은 인덱스 값들과 비교
    // 1. 현재 인덱스의 값보다 큰지
    // 2. 해당 큰 값을 선택했을 때 최대 길이가 될 수 있는지
    if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
  }
}

// 반례: 1/1 입력시 0
// 반례: 4/10 30 20 30 입력시 3/10 20 30
if (n === 1) {
  console.log(0);
  return;
} else {
  let max = -1;
  for (let i = 1; i <= n; i++) max = Math.max(max, dp[i]);
  console.log(max);

  let temp = [];
  for (let i = n; i >= 1, max >= 1; i--) {
    if (dp[i] === max) {
      temp.push(arr[i]);
      max--;
    }
  }
  let result = "";
  for (let i = temp.length - 1; i >= 0; i--) result += temp[i] + " ";
  console.log(result);
  console.log(dp);
}
