// boj 14002 가장 긴 증가하는 부분 수열 4
// tree traversal, two pointer, LIS
// LIS
// dp: 비슷한 문제: https://www.acmicpc.net/problem/11722
// 풀이참고: https://velog.io/@arthur/14002.-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4-4-node.js-javascript
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

// const n = parseInt(input[0]);
// const arr = input[1].split(" ").map(Number);
// arr.splice(0, 0, 0);

//틀렸습니다 이유 모르겠음...
// let dp = new Array(n + 1).fill(0); //인덱스까지의 최대 길이
// for (let i = 1; i <= n; i++) {
//   dp[i] = 1;
//   for (let j = 1; j <= i; j++) {
//     // 현재 인덱스 i보다 작은 인덱스 값들과 비교
//     // 1. 현재 인덱스의 값보다 큰지
//     // 2. 해당 큰 값을 선택했을 때 최대 길이가 될 수 있는지
//     if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
//   }
// }

// // 반례: 1/1 입력시 0
// // 반례: 4/10 30 20 30 입력시 3/10 20 30
// if (n === 1) {
//   console.log(0);
//   return;
// } else {
//   let max = -1;
//   for (let i = 1; i <= n; i++) max = Math.max(max, dp[i]);
//   console.log(max);

//   let temp = [];
//   for (let i = n; i >= 1, max >= 1; i--) {
//     if (dp[i] === max) {
//       temp.push(arr[i]);
//       max--;
//     }
//   }
//   let result = "";
//   for (let i = temp.length - 1; i >= 0; i--) result += temp[i] + " ";
//   console.log(result);
//   // console.log(dp);
// }

let n = Number(input[0]);
let arr = input[1].split(" ").map(Number);

let dp = Array.from({ length: n }, () => 0);
let temp = [];

for (let i = 0; i < n; i++) {
  let maximum = 0;
  let maxidx = -1;

  for (let j = 0; j < i; j++) {
    if (arr[i] > arr[j] && dp[j] > maximum) {
      maximum = dp[j];
      maxidx = j;
    }
  }
  dp[i] = maximum + 1;
  temp[i] = maxidx !== -1 ? temp[maxidx].concat(arr[i]) : [arr[i]];
}

let answer = Math.max(...dp);

console.log(answer);
console.log(temp[dp.indexOf(answer)].join(" "));
