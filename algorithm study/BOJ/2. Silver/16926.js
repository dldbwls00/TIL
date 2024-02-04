// boj 16926 배열 돌리기 1
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let temp = input[0].split(" ").map(Number);
const n = temp[0];
const m = temp[1];
const r = temp[2];

let arr = new Array(n);
for (let i = 0; i < arr.length; i++) arr[i] = new Array(m);
for (let i = 0; i < n; i++) {
  let temp2 = input[i + 1].split(" ").map(Number);
  for (let j = 0; j < m; j++) arr[i][j] = temp2[j];
}

const square = Math.min(n, m) / 2; //min(n, m) mod 2 = 0이므로 min(n, m)/2개의 사각형을 돌린다
function rotate() {
  for (let i = 0; i < square; i++) {
    let temp3 = arr[i][i]; //시작점(좌상단값)

    for (let j = i; j < m - i - 1; j++) arr[i][j] = arr[i][j + 1]; //왼쪽으로
    for (let j = i; j < n - 1 - i; j++) arr[j][m - i - 1] = arr[j + 1][m - i - 1]; //위로
    for (let j = m - i - 1; j > i; j--) arr[n - 1 - i][j] = arr[n - 1 - i][j - 1]; //오른쪽으로
    for (let j = n - i - 1; j > i; j--) arr[j][i] = arr[j - 1][i]; //아래로
    arr[i + 1][i] = temp3;
  }
}
for (let i = 0; i < r; i++) rotate();

let result = "";
for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) result += arr[i][j] + " ";
  result += "\n";
}
console.log(result);
