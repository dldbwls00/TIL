// boj 1987 알파벳
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [r, c] = input[0].split(" ").map(Number);
let board = Array.from(Array(r), () => Array(c));
for (let i = 0; i < r; i++) {
  for (let j = 0; j < c; j++) board[i][j] = input[i + 1].split("")[j];
}

let visited = new Array(26).fill(0); //A:65 ~ Z:90
visited[board[0][0].charCodeAt(0) - 65] = 1;
let maximum = -1;
const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

function dfs(x, y, cnt) {
  maximum = Math.max(maximum, cnt);
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];
    //좌표가 범위 내에 있는지, 방문 안한 곳인지
    if (nx >= 0 && nx < r && ny >= 0 && ny < c && visited[board[nx][ny].charCodeAt(0) - 65] === 0) {
      visited[board[nx][ny].charCodeAt(0) - 65] = 1;
      dfs(nx, ny, cnt + 1);
      visited[board[nx][ny].charCodeAt(0) - 65] = 0; //원상복구
    }
  }
}

dfs(0, 0, 1);
console.log(maximum);
