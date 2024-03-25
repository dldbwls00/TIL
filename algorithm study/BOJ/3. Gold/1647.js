// boj 1647 도시 분할 계획
// mst - kruskal, prim / union find
// boj 1197, 1922과 똑같은 문제

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const [n, m] = input[0].split(" ").map(Number);
// console.log(n, m);

let graph = [];
for (let i = 0; i < m; i++) {
  const [a, b, c] = input[i + 1].split(" ").map(Number);
  graph.push([c, a, b]);
}
graph.sort((a, b) => a[0] - b[0]); //weight순 오름차순 정렬
// console.log(graph);

let parent = new Array(n + 1);
for (let i = 0; i <= n; i++) parent[i] = i;

//사이클이 생기지 않도록 하기 위해 union find 이용
function findparent(x) {
  if (parent[x] === x) return x;
  else return (parent[x] = findparent(parent[x]));
}
function unionparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  parent[tempy] = tempx;
}
function sameparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  if (tempx === tempy) return 1;
  else return 0;
}

let result = 0;
let maxweight = -1;
for (let i = 0; i < graph.length; i++) {
  if (sameparent(graph[i][1], graph[i][2]) === 0) {
    unionparent(graph[i][1], graph[i][2]);
    maxweight = Math.max(maxweight, graph[i][0]);
    result += graph[i][0];
  }
}
//가중치가 가장 큰 마지막 하나만 빼주면 mst 두 개로 분리할 수 있다
console.log(result - maxweight);
