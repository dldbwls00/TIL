// boj 1520 내리막 길
// dp
// https://yabmoons.tistory.com/340

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [m, n] = input[0].split(" ").map(Number); //m: 세로, n: 가로
// let map = Array.from(Array(m), () => Array(n));
// for (let i = 0; i < m; i++) {
//   for (let j = 0; j < n; j++) map[i][j] = input[i + 1].split(" ").map(Number)[j];
// }
let map = [];
for (let i = 0; i < m; i++) map[i] = input[i + 1].split(" ").map(Number);

const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

// dp[a][b]=c : (a, b)에서 (n-1, m-1)까지 c개의 경로로 도달 가능
let dp = Array.from(Array(m), () => Array(n).fill(-1));
function dfs(x, y) {
  if (x === m - 1 && y === n - 1) return 1;
  if (dp[x][y] !== -1) return dp[x][y];

  dp[x][y] = 0;
  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[x][y] > map[nx][ny]) dp[x][y] += dfs(nx, ny);
  }
  return dp[x][y];
}
const h = dfs(0, 0);
console.log(h);
