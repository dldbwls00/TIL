// boj 6497 전력난
// mst - kruskal, prim / union find
// boj 1197, 1922, 1647과 똑같은 문제
// 입력은 여러 개의 테스트 케이스로 구분되어 있다."

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

let parent = new Array(200001);
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

let line = 0;
let ans = "";
while (true) {
  const [m, n] = input[line].split(" ").map(Number);
  if (m === 0 && n === 0) break;
  let graph = [];
  line++;
  for (let i = 0; i < n; i++) {
    const [a, b, c] = input[i + line].split(" ").map(Number);
    graph.push([c, a, b]);
  }
  graph.sort((a, b) => a[0] - b[0]); //weight순 오름차순 정렬

  for (let i = 0; i <= m; i++) parent[i] = i;
  let result = 0;
  for (let i = 0; i < graph.length; i++) {
    if (sameparent(graph[i][1], graph[i][2]) === 0) unionparent(graph[i][1], graph[i][2]);
    else result += graph[i][0];
  }
  ans += result + "\n";
  //   console.log();
  line += n;
}
console.log(ans);
