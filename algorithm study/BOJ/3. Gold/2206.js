const input = require("fs").readFileSync("./example.txt").toString().split("\n");
//const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let map = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= m; j++) map[i][j] = input[i].split("").map(Number)[j - 1];
}
let visited = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
let cnt = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
let punch = 0;

// const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
// const dy = [1, 0, -1, 0];
const dx = [0, -1, 0, 1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];
let wall = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
// function dfs(x, y) {
//   if (visited[x][y]) return;
//   visited[x][y] = 1;
//   for (let i = 0; i < 4; i++) {
//     // let bx = x - dx[i];
//     // let by = y - dy[i];
//     let nx = x + dx[i];
//     let ny = y + dy[i];
//     //좌표가 범위 내에 있는지, 방문 안한 곳인지
//     if (nx > 0 && nx <= n && ny > 0 && ny <= n && visited[nx][ny] === 0) {
//       if (map[nx][ny] === 1) donotpunch[x][y]++;
//       dfs(nx, ny);
//     }
//   }
// }
function findwall() {
  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      for (let k = 0; k < 4; k++) {
        const nx = i + dx[k];
        const ny = j + dy[k];

        if (map[nx][ny] === 1) wall[i][j]++;
      }
    }
  }
}

function bfs(x, y) {
  let queue = [];
  queue.push([x, y]);
  visited[x][y] = 1;
  cnt[x][y]++;
  while (queue.length > 0) {
    const temp = queue.shift();
    const xx = temp[0];
    const yy = temp[1];
    for (let i = 0; i < 4; i++) {
      let nx = xx + dx[i];
      let ny = yy + dy[i];
      if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && visited[nx][ny] === 0) {
        if (map[nx][ny] === 1 && punch === 1) continue;
        if (map[nx][ny] === 1 && punch === 0) punch++;
        cnt[nx][ny] = cnt[xx][yy] + 1;
        visited[nx][ny] = 1;
        queue.push([nx, ny]);
      }
    }
  }
}
// bfs(1, 1);
// console.log(visited);
// console.log(cnt);

// if (cnt[n][m] === 0) console.log(-1);
// else console.log(cnt[n][m]);

findwall();
console.log(wall);
