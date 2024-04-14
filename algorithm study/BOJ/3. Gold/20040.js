// boj 20040 사이클 게임
// union find, topological sorting

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");
const [n, m] = input[0].split(" ").map(Number);
let graph = [];
for (let i = 0; i < m; i++) {
  const [a, b] = input[i + 1].split(" ").map(Number);
  graph.push([a, b]);
}
// console.log(graph);

let parent = new Array(n);
for (let i = 0; i < n; i++) parent[i] = i;

// union find
function findparent(x) {
  if (parent[x] === x) return x;
  else return (parent[x] = findparent(parent[x]));
}
function unionparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  parent[tempy] = tempx;
  //   if (tempx < tempy) parent[tempy] = tempx;
  //   else parent[tempx] = tempy;
}
function sameparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  if (tempx === tempy) return 1;
  else return 0;
}

let cycle = -1;
for (let i = 0; i < m; i++) {
  if (sameparent(graph[i][0], graph[i][1]) === 0) unionparent(graph[i][0], graph[i][1]);
  else {
    cycle = i + 1;
    break;
  }
}
// console.log(graph);
// console.log(cycle);

if (cycle === -1) console.log(0);
else console.log(cycle);
