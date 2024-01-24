// boj 16507 어두운 건 무서워
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [r, c, q] = input[0].split(" ").map(Number);

let arr = [];
for (let i = 1; i < r + 1; i++) arr.push(input[i].split(" ").map(Number));
let temp = Array.from(Array(r + 1), () => new Array(c + 1).fill(0));

for (let i = 1; i <= r; i++) temp[i][1] = arr[i - 1][0];
//행별 누적합이 아닌 좌표별 누적합
for (let i = 1; i < r + 1; i++) {
  for (let j = 1; j < c + 1; j++) {
    temp[i][j] = arr[i - 1][j - 1] + temp[i][j - 1] + temp[i - 1][j] - temp[i - 1][j - 1];
  }
}

for (let i = 0; i < q; i++) {
  let [x1, y1, x2, y2] = input[r + i + 1].split(" ").map(Number);

  //겹치는 부분 빼기, 두 번 뺀 부분 더하기
  let sum = temp[x2][y2] - temp[x1 - 1][y2] - temp[x2][y1 - 1] + temp[x1 - 1][y1 - 1];
  let div = (x2 - x1 + 1) * (y2 - y1 + 1);

  console.log(Math.floor(sum / div));
}
