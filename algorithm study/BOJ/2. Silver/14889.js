// boj 14889 스타트와 링크
// backtracking
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = [];
for (let i = 1; i <= n; i++) arr.push(input[i].split(" ").map(Number));
let visited = new Array(n).fill(0); //1: start, 0: link
let answer = Number.MAX_SAFE_INTEGER;

function dfs(x, next) {
  // 팀 조합이 완성됨
  if (x === Math.floor(n / 2)) {
    let start = 0;
    let link = 0;
    for (let i = 0; i < n; i++) {
      for (let j = i + 1; j < n; j++) {
        if (visited[i] === 1 && visited[j] === 1) start += arr[i][j] + arr[j][i];
        if (visited[i] === 0 && visited[j] === 0) link += arr[i][j] + arr[j][i];
      }
    }
    answer = Math.min(Math.abs(start - link), answer);
    return;
  }

  //backtracking, 중복 주의
  for (let i = next; i < n; i++) {
    visited[i] = 1;
    dfs(x + 1, i + 1);
    visited[i] = 0;
  }
}

dfs(0, 1);
console.log(answer);
