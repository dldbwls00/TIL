// 미해결
// boj 1626 두 번째로 작은 스패닝 트리
// mst - kruskal, prim / union find
const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const [v, e] = input[0].split(" ").map(Number);
let graph = [];
for (let i = 0; i < e; i++) {
  const [a, b, weight] = input[i + 1].split(" ").map(Number);
  graph.push([weight, a, b]);
}
// console.log(v, e);
graph.sort((a, b) => a[0] - b[0]); //weight 기준 오름차순 정렬
console.log(graph);

let parent = new Array(v + 1);
for (let i = 0; i <= v; i++) parent[i] = i;

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

// 두 번째로 작은 spnning tree를 찾기 위해
// 1. graph[0]과 graph[1]의 자리를 바꾸면? => 42 (mst와 같음)
// let temp = graph[0];
// graph[0] = graph[1];
// graph[1] = temp;
// console.log(graph);

// 2. graph[0]을 맨 뒤에 넣으면? => 48 (오답)
// let temp = graph.shift();
// graph.push(temp);
// console.log(graph);

// 3. graph[e-1]과 graph[e-2]의 자리를 바꾸면? => 42 (오답)
// let temp = graph[e - 2];
// graph[e - 2] = graph[e - 1];
// graph[e - 1] = temp;

// 4. graph[e-1]을 맨 앞에 넣으면? => 56 (오답)
graph.unshift(graph[e - 1]);
graph.pop();

// 5.
console.log(graph);

let result = 0;
let stcheck = 0;
// let visited = new Array(v + 1).fill(0);
// visited[0] = 1;
for (let i = 0; i < graph.length; i++) {
  if (sameparent(graph[i][1], graph[i][2]) === 0) {
    unionparent(graph[i][1], graph[i][2]);
    result += graph[i][0];
    stcheck++;
    // visited[graph[i][1]] = 1;
    // visited[graph[i][2]] = 1;
  }
}

// console.log(stcheck);
if (stcheck !== v - 1) console.log(-1); //mst가 없는 경우
// if (visited.includes(0)) console.log(-1);
else console.log(result);
