// boj 9663 N-Queen
// backtracking
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let col = new Array(n).fill(0);
let result = 0;
function promising(level) {
  let i = 0;
  while (i < level) {
    //같은 열, 행, 대각선
    if (col[level] == col[i] || Math.abs(col[level] - col[i]) === level - i) return false;
    i++;
  }
  return true;
}
function nQueen(i) {
  if (i == n) result++; //답을 찾은 경우
  else {
    for (let j = 0; j < n; j++) {
      col[i] = j;
      if (promising(i)) nQueen(i + 1); //자식 탐색
    }
  }
}

nQueen(0);
console.log(result);
