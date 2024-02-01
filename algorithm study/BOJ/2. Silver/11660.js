// 시간초과 미해결
// boj 11660 구간 합 구하기 5
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);

let arr = input.slice(1, n + 1).map((str) => str.split(" ").map(Number));
let temp = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));

for (let i = 1; i <= n; i++) temp[i][1] = arr[i - 1][0];
//행별 누적합이 아닌3 좌표별 누적합
for (let i = 1; i < n + 1; i++) {
  for (let j = 1; j < n + 1; j++) {
    temp[i][j] = arr[i - 1][j - 1] + temp[i][j - 1] + temp[i - 1][j] - temp[i - 1][j - 1];
  }
}

let sum = [];
for (let i = 0; i < m; i++) {
  const [x1, y1, x2, y2] = input[n + i + 1].split(" ").map(Number);

  //겹치는 부분 빼기, 두 번 뺀 부분 더하기
  sum[i] = temp[x2][y2] - temp[x1 - 1][y2] - temp[x2][y1 - 1] + temp[x1 - 1][y1 - 1];
}

for (let i = 0; i < m; i++) console.log(sum[i]);
