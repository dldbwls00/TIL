// boj 2565 전깃줄
// dp

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = [];
for (let i = 0; i < n; i++) arr[i] = input[i + 1].split(" ").map(Number);
arr.sort((a, b) => {
  if (a[0] === b[0]) return a[1] - b[1];
  else return a[0] - b[0];
}); //오름차순
// console.log(arr);

let nummax = 0;
for (let i = 0; i < n; i++) nummax = Math.max(arr[n - 1][0], arr[i][1]);
// console.log(nummax);

// 전깃줄이 교차하는 조건: a1 < b1일 때 a2 > b2
// 어떤 전깃줄부터 없애야하는지? -> 겹치는 게 많은 줄부터

// let cross = new Array(nummax + 1).fill(0);
// for (let i = 0; i < n - 1; i++) {
//   for (let j = i + 1; j < n; j++) {
//     if (arr[i][1] > arr[j][1]) {
//       cross[arr[i][0]]++;
//       cross[arr[j][0]]++;
//     }
//   }
// }

// cross[겹치는 횟수][번호]
let cross = Array.from(Array(nummax + 1), () => Array(2).fill(0));
for (let i = 1; i <= nummax; i++) cross[i][1] = i;
for (let i = 0; i < n - 1; i++) {
  for (let j = i + 1; j < n; j++) {
    if (arr[i][1] > arr[j][1]) {
      cross[arr[i][0]][0]++;
      cross[arr[j][0]][0]++;
    }
  }
}
cross.sort((a, b) => {
  if (a[0] === b[0]) return b[1] - a[1];
  else return b[0] - a[0];
});
for (let i = cross.length - 1; i >= 0; i--) {
  if (cross[i][0] === 0) cross.splice(i, 1);
}
console.log(cross);

let dp = new Array(nummax + 1).fill(-1);
for (let i = 0; i < n; i++) dp[arr[i][0]] = 0;
// console.log(dp);
let mincut = 0;

for (let i = 1; i <= n; i++) {
  // for (let j=arr[i][0]; j)
}
