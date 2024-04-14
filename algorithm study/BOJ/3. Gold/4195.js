// boj 4195 친구 네트워크
// union find, topological sorting
const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const t = parseInt(input[0]);

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

let line = 1;
for (let i = 0; i < t; i++) {
  const f = parseInt(input[line]);

  let graph = [];
  for (let i = 0; i < f; i++) {
    const [a, b] = input[++line].split(" ").map(String);
    console.log(a, b);
    // for (let j = 0; j < temp.length; j++) if (temp[j] === 1) graph.push([i + 1, j + 1]);
  }
  line++;
}
