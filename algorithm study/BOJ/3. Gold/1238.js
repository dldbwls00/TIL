// boj 1238 파티
// shortest path: bellman-ford, dijkstra, floyd-warshall
// dijkstra
// 반례: https://joey09.tistory.com/76
// a->x + x->a

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const [n, m, x] = input[0].split(" ").map(Number);
if (n === 1) {
  console.log(0);
  return;
}

let visited = new Array(n + 1).fill(0);
let dist = new Array(n + 1).fill(Number.MAX_SAFE_INTEGER);

let map = Array.from(Array(n + 1), () => new Array(n + 1).fill(Number.MAX_SAFE_INTEGER));
for (let i = 0; i < m; i++) {
  const [a, b, c] = input[i + 1].split(" ").map(Number); //a->b의 가중치가 c
  if (map[a][b] === Math.MAX_SAFE_INTEGER) map[a][b] = c; // 간선이 여러 개일 수 있음
  else map[a][b] = Math.min(map[a][b], c);
}

function clear() {
  for (let i = 0; i < dist.length; i++) dist[i] = Number.MAX_SAFE_INTEGER;
  for (let i = 0; i < visited.length; i++) visited[i] = 0;
}

function findminidx() {
  let mindist = Number.MAX_SAFE_INTEGER;
  let minidx = Number.MAX_SAFE_INTEGER;
  for (let i = 1; i <= n; i++) {
    if (visited[i] === 1) continue;
    if (dist[i] < mindist) {
      mindist = dist[i];
      minidx = i;
    }
  }
  return minidx;
}

function dijkstra(s) {
  for (let i = 1; i <= n; i++) if (map[s][i] !== Number.MAX_SAFE_INTEGER) dist[i] = map[s][i]; //시작지점부터의 거리 초기화
  visited[s] = 1;

  for (let i = 0; i < n - 1; i++) {
    let node = findminidx();
    if (node === Number.MAX_SAFE_INTEGER) break;
    visited[node] = 1;

    for (let j = 1; j <= n; j++) {
      if (visited[j] === 1) continue;
      if (map[node][j] !== Number.MAX_SAFE_INTEGER) dist[j] = Math.min(dist[j], dist[node] + map[node][j]);
    }
  }
}

dijkstra(x);
let distx = dist.slice();
for (let j = 1; j <= n; j++) {
  if (distx[j] == Number.MAX_SAFE_INTEGER) distx[j] = 0;
}
clear();

// console.log(map);
// console.log(distx);
// console.log();

let maximum = -1;
for (let i = 1; i <= n; i++) {
  dijkstra(i);
  for (let j = 1; j <= n; j++) if (dist[j] == Number.MAX_SAFE_INTEGER) dist[j] = 0;
  maximum = Math.max(distx[i] + dist[x], maximum);
  clear();
}
console.log(maximum);
