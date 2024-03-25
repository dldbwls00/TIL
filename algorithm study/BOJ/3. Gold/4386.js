// boj 4386 별자리 만들기
// mst - kruskal, prim / union find
// boj 1197, 1922, 1647과 똑같은 문제

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");
const n = parseInt(input[0]);

let star = [];
for (let i = 0; i < n; i++) {
  const [x, y] = input[i + 1].split(" ").map(Number);
  star.push([i + 1, x, y]); //[별인덱스, x값, y값]
}
// console.log(star);

let graph = [];
for (let i = 0; i < n - 1; i++) {
  for (let j = i + 1; j < n; j++) {
    const [nun1, x1, y1] = star[i];
    const [num2, x2, y2] = star[j];
    const dist = Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
    graph.push([dist, i + 1, j + 1]);
  }
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
for (let i = 0; i < graph.length; i++) {
  if (sameparent(graph[i][1], graph[i][2]) === 0) {
    unionparent(graph[i][1], graph[i][2]);
    result += graph[i][0];
  }
}
console.log(result.toFixed(2));
