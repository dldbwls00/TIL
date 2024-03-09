// boj 2580 스도쿠
// backtracking
// https://cryptosalamander.tistory.com/59
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let cnt = 0;
let found = false; //판 완성 flag
let zero = []; // 빈칸 위치 저장

let board = [];
for (let i = 0; i < 9; i++) board[i] = input[i].split(" ").map(Number);
for (let i = 0; i < 9; i++) {
  for (let j = 0; j < 9; j++) {
    if (board[i][j] === 0) {
      cnt++;
      zero.push([i, j]);
    }
  }
}
// console.log(zero);

function check(p) {
  let x = Math.floor(p[0] / 3); //구역 나누기
  let y = Math.floor(p[1] / 3);

  for (let i = 0; i < 9; i++) {
    //같은 행에 같은 숫자가 있는 경우
    if (board[p[0]][i] === board[p[0]][p[1]] && i !== p[1]) return false;
    //같은 열에 같은 숫자가 있는 경우
    if (board[i][p[1]] === board[p[0]][p[1]] && i !== p[0]) return false;
  }
  for (let i = 3 * x; i < 3 * x + 3; i++) {
    for (let j = 3 * y; j < 3 * y + 3; j++) {
      //같은 구역에 같은 숫자가 있는 경우
      if (board[i][j] === board[p[0]][p[1]] && i !== p[0] && j !== p[1]) return false;
    }
  }
  return true;
}

let result = "";
function sudoku(n) {
  if (n === cnt) {
    for (let i = 0; i < 9; i++) {
      for (let j = 0; j < 9; j++) result += board[i][j] + " ";
      result += "\n";
    }
    found = true;
    return;
  }

  for (let j = 1; j <= 9; j++) {
    board[zero[n][1]][zero[n][1]] = j;
    if (check(zero[n])) sudoku(n + 1); //다음 빈칸 채우기
    if (found) return; //스도쿠가 완성된 경우
  }

  board[zero[n][0]][zero[n][1]] = 0; //최적해가 없는 경우
  return;
}

sudoku(0);
console.log(result);
