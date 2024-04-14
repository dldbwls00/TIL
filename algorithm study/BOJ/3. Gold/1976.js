// boj 1976 여행 가자
// union find, topological sorting

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const n = parseInt(input[0]);
// const m = parseInt(input[1]);
let graph = [];
for (let i = 0; i < n; i++) {
  const temp = input[i + 2].split(" ").map(Number);
  for (let j = 0; j < temp.length; j++) if (temp[j] === 1) graph.push([i + 1, j + 1]);
}

const plan = input[n + 2].split(" ").map(Number);
console.log(plan);
// let setplan = new Set([...plan]);
// let setarrplan = new Array(...setplan);

let parent = new Array(n + 1);
for (let i = 0; i <= n; i++) parent[i] = i;

// union find
function findparent(x) {
  if (parent[x] === x) return x;
  else return (parent[x] = findparent(parent[x]));
}
function unionparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  // parent[tempy] = tempx;
  // 반례: https://www.acmicpc.net/board/view/123073 <<이거때매 틀렸습니다
  if (tempx < tempy) parent[tempy] = tempx;
  else parent[tempx] = tempy;
}
function sameparent(x, y) {
  let tempx = findparent(x);
  let tempy = findparent(y);
  if (tempx === tempy) return 1;
  else return 0;
}

for (let i = 0; i < graph.length; i++) {
  if (sameparent(graph[i][0], graph[i][1]) === 0) unionparent(graph[i][0], graph[i][1]);
}

let flag = 1;
for (let i = 1; i <= parent.length; i++) {
  if (plan.includes(i) && parent[i] !== parent[plan[0]]) {
    flag = 0;
    break;
  }
}
if (flag === 0) console.log("NO");
else console.log("YES");
