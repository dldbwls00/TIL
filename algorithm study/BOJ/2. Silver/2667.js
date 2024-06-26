// boj 2667 단지번호붙이기
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let map = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) map[i][j] = input[i].split("").map(Number)[j - 1];
}

let visited = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
let cnt = 0;
let result = [];
const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

function dfs(x, y) {
  visited[x][y] = 1;
  cnt++;
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];
    //좌표가 범위 내에 있는지, 방문 안한 곳인지
    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && map[nx][ny] === 1 && visited[nx][ny] === 0) dfs(nx, ny);
  }
}

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    if (visited[i][j] === 0 && map[i][j] === 1) {
      cnt = 0;
      dfs(i, j);
      result.push(cnt);
    }
  }
}
console.log(result.length);
result.sort((a, b) => a - b);
for (let i = 0; i < result.length; i++) console.log(result[i]);
