// boj 2178 미로 탐색
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let map = new Array(n);
for (let i = 0; i < n; i++) {
  map[i] = input[i + 1].split("").map(Number);
  if (i !== n - 1) map[i].pop();
}

let visited = Array.from(Array(n), () => Array(m).fill(0));
let cnt = Array.from(Array(n), () => Array(m).fill(0));
const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];

function bfs(x, y) {
  let queue = [];
  queue.push([x, y]);
  visited[x][y] = 1;
  \
  //   console.log(queue);
  //   console.log(visited);
  //   while (queue.length > 0) {
  //     const temp = queue.shift();
  //     const x = temp[0];
  //     const y = temp[1];
  //     //     result += temp + " ";
  //     //     for (let i = 0; i < map[temp].length; i++) {
  //     //       if (visited[map[temp][i]] == 0) {
  //     //         queue.push(map[temp][i]);
  //     //         visited[map[temp][i]] = 1;
  //     //       }
  //     //     }
  //     for (let i = 0; i < 4; i++) {
  //       if (1) {
  //       }
  //     }
  //   }
}

bfs(0, 0);
console.log(cnt[n - 1][m - 1]);
