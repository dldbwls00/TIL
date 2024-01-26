// boj 2747 피보나치 수
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number);

let arr = [];
for (let i = 0; i <= n; i++) {
  if (i < 2) arr[i] = i;
  else arr[i] = arr[i - 1] + arr[i - 2];
}
console.log(arr[n]);
