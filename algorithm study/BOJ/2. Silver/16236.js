// boj 16236 아기 상어
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let map = Array.from(Array(n), () => Array(n));
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) map[i][j] = input[i + 1].split(" ").map(Number)[j];
}
// console.log(map);

let X, Y; //상어 초기 위치
for (let i = 0; i < n; i++) {
  if (map[i].indexOf(9, 0) !== -1) {
    X = i;
    Y = map[i].indexOf(9, 0);
  }
}
let visited = Array.from(Array(n), () => Array(n).fill(0));
let shark = 2;
let sec = 0;

const dx = [0, -1, 0, 1]; //북, 서, 남, 동 (반시계 방향)
const dy = [1, 0, -1, 0];

let cnt = 0;
function dfs(x, y) {
  sec++;
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];

    if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] === 0) {
      if (shark <= map[nx][ny]) {
        visited[nx][ny] = 1;
        continue;
      }
      if (shark > map[nx][ny]) {
        cnt++;
        map[nx][ny] = 0;
        visited[nx][ny] = 1;
        if (cnt === shark) {
          shark++;
          cnt = 0;
        }
      }
      dfs(nx, ny);
    }
  }
}
dfs(X, Y);
// console.log(map);
console.log(sec);
