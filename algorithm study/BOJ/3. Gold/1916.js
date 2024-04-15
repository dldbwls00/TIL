// boj 1916 최소비용 구하기
// shortest path: bellman-ford, dijkstra, floyd-warshall
// dijkstra: 음의 가중치가 없으므로 사용 가능
// 반례: https://www.acmicpc.net/board/view/129219

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const n = parseInt(input[0]);
const m = parseInt(input[1]);
if (n === 1) {
  console.log(0);
  return;
}
let visited = new Array(n + 1).fill(0);
let dist = new Array(n + 1).fill(Number.MAX_SAFE_INTEGER);

let map = Array.from(Array(n + 1), () => new Array(n + 1).fill(-1));
for (let i = 0; i < m; i++) {
  const [a, b, w] = input[i + 2].split(" ").map(Number); //a->b의 가중치가 w
  if (map[a][b] === -1) map[a][b] = w; // 간선이 여러 개일 수 있음
  else map[a][b] = Math.min(map[a][b], w);
}
const [s, e] = input[m + 2].split(" ").map(Number);

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
  //   return dist.indexOf(mindist);
  return minidx;
}

function dijkstra(s) {
  //   dist[s] = 0; //시작지점의 거리 0
  for (let i = 1; i <= n; i++) if (map[s][i] !== -1) dist[i] = map[s][i]; //시작지점부터의 거리 초기화
  visited[s] = 1;
  //   console.log("startnode: " + s);
  //   console.log("visited: " + visited);
  //   console.log("dist: " + dist);
  //   console.log();

  for (let i = 0; i < n - 1; i++) {
    let node = findminidx();
    if (node === Number.MAX_SAFE_INTEGER) break;
    visited[node] = 1;
    // console.log("node: " + node);
    // console.log("visited: " + visited);
    // console.log("dist: " + dist);
    // console.log();
    for (let j = 1; j <= n; j++) {
      if (visited[j] === 1) continue;
      if (map[node][j] !== -1) {
        dist[j] = Math.min(dist[j], dist[node] + map[node][j]);
        // visited[j] = 1;
      }
    }
  }
}
dijkstra(s);
// console.log(dist);
// console.log(map);
// console.log(visited);
console.log(dist[e]);
