// boj 1260 DFS와 BFS
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m, v] = input[0].split(" ").map(Number);
let arr = new Array(m);
for (let i = 0; i < m; i++) arr[i] = input[i + 1].split(" ").map(Number);

let map = Array.from(Array(n + 1), () => []);
for (let i = 0; i < m; i++) {
  map[arr[i][0]].push(arr[i][1]);
  map[arr[i][1]].push(arr[i][0]);
}
for (let i = 0; i < map.length; i++) map[i].sort((a, b) => a - b);

let visited = new Array(n + 1).fill(0);
let result = "";

function dfs(v) {
  if (visited[v]) return;
  visited[v] = 1;
  result += v + " ";
  for (let i = 0; i < map[v].length; i++) dfs(map[v][i]);
}

function bfs(v) {
  let queue = [];
  queue.push(v);
  visited[v] = 1;

  while (queue.length > 0) {
    let temp = queue.shift();
    result += temp + " ";
    for (let i = 0; i < map[temp].length; i++) {
      if (visited[map[temp][i]] == 0) {
        queue.push(map[temp][i]);
        visited[map[temp][i]] = 1;
      }
    }
  }
}

dfs(v);
result += "\n";
for (let i = 0; i < visited.length; i++) visited[i] = 0; //reset
bfs(v);
console.log(result);
