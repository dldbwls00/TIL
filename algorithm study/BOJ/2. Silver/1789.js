// boj 1789 수들의 합
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = parseInt(input[0]);
let cnt = 0;
// if (n === 1) cnt = 1;
for (let i = 1; i <= n; i++) {
  if (n >= i) {
    n -= i;
    cnt++;
  }
  if (n === 0) break;
}
console.log(cnt);

// 반례
// 1 / 3 / 210

// # Output
// 0 / 1 / 19

// # Answer
// 1 / 2 / 20
