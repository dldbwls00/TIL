// boj 2468 안전 영역
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let map = Array.from(Array(n), () => Array(n));
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) map[i][j] = input[i + 1].split(" ").map(Number)[j];
}
let mapmax = -1;
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) mapmax = Math.max(mapmax, map[i][j]);
}
let visited = Array.from(Array(n), () => Array(n).fill(0));
let notdrown = Array.from(Array(n), () => Array(n).fill(0));

const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

function dfs(x, y, rain) {
  visited[x][y] = 1;
  if (map[x][y] > rain) notdrown[x][y] = 1;
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];
    //좌표가 범위 내에 있는지, 방문 안한 곳인지
    if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] === 0) {
      dfs(nx, ny, rain);
    }
  }
}

let cnt = 0;
function raindfs(x, y) {
  visited[x][y] = 1;
  cnt++;
  for (let i = 0; i < 4; i++) {
    let nx = x + dx[i];
    let ny = y + dy[i];
    if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] === 0 && notdrown[nx][ny] === 1) {
      raindfs(nx, ny);
    }
  }
}
function clear(arr) {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) arr[i][j] = 0;
  }
}

let result = [];
for (let i = 0; i <= mapmax; i++) {
  dfs(0, 0, i);
  clear(visited);
  let temp = [];
  for (let j = 0; j < n; j++) {
    for (let k = 0; k < n; k++) {
      if (visited[j][k] === 0 && notdrown[j][k] === 1) {
        cnt = 0;
        raindfs(j, k);
        temp.push(cnt);
      }
    }
  }
  result.push(temp.length);
  clear(notdrown);
  clear(visited);
}
result.sort((a, b) => a - b);
console.log(result[result.length - 1]);
