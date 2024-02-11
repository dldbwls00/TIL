// boj 2178 미로 탐색
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let map = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= m; j++) map[i][j] = input[i].split("").map(Number)[j - 1];
}
let visited = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
let cnt = Array.from(Array(n + 1), () => Array(m + 1).fill(0));

const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

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
      if (nx > 0 && nx <= n && ny > 0 && ny <= m && map[nx][ny] === 1 && visited[nx][ny] === 0) {
        //좌표가 범위 내에 있는지, 방문 안한 곳인지
        cnt[nx][ny] = cnt[xx][yy] + 1;
        visited[nx][ny] = 1;
        queue.push([nx, ny]);
      }
    }
  }
}
bfs(1, 1);
console.log(cnt[n][m]);
