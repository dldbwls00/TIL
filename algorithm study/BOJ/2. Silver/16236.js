// boj 16236 아기 상어
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let map = Array.from(Array(n), () => Array(n));
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) map[i][j] = input[i + 1].split(" ").map(Number)[j];
}

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

const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

// function dfs(x, y) {
//   visited[x][y] = 1;

//   for (let i = 0; i < 4; i++) {
//     let nx = x + dx[i];
//     let ny = y + dy[i];

//     if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] === 0) {
//       if (shark < map[nx][ny]) continue;
//       if (shark > map[nx][ny]) shark += map[nx][ny];

//       dfs(nx, ny);
//     }
//   }
// }
console.log(map);
// console.log(visited);
// console.log(shark);
