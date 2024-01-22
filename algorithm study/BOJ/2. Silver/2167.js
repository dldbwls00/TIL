// boj 2167 2차원 배열의 합
// implementation

// const input = require("fs").readFileSync("./example.txt").toString().split("\n");
const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);

let arr = [];
for (let i = 0; i < n; i++) {
  arr.push(input[i + 1].split(" ").map(Number));
}
const k = input[n + 1];

for (let a = 0; a < k; a++) {
  let sum = 0;
  let [i, j, x, y] = input[n + 2 + a].split(" ").map(Number);
  if ((i === x) & (j === y)) {
    sum = arr[i - 1][j - 1];
  } else {
    for (let b = i; b <= x; b++) {
      for (let c = j; c <= y; c++) {
        sum += arr[b - 1][c - 1];
      }
    }
  }
  console.log(sum);
}
