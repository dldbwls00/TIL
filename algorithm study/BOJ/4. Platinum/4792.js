// 미해결
// boj 4792 레드 블루 스패닝 트리
// mst - kruskal, prim / union find
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
  const [n, m, k] = input[line].split(" ").map(Number);
  if (n === 0 && m === 0 && k === 0) break;
  let graph = [];
  line++;
  for (let i = 0; i < m; i++) {
    let [c, f, t] = input[i + line].split(" ");
    f = parseInt(f);
    t = parseInt(t);
    graph.push([c, f, t]);
  }
  //   console.log(graph);
  //   graph.sort((a, b) => a[0] - b[0]); //weight순 오름차순 정렬

  for (let i = 0; i <= n; i++) parent[i] = i;
  let result = 0;
  let cnt = 0; //파란색 간선 count
  for (let i = 0; i < graph.length; i++) {
    if (sameparent(graph[i][1], graph[i][2]) === 0) {
      unionparent(graph[i][1], graph[i][2]);
      if (graph[i][0] === "B") cnt++;
      result++;
    }
    // else result += graph[i][0];
  }
  //   ans += result + "\n";
  //   console.log();
  line += m;
  if (k === cnt && result === n - 1) ans += 1 + "\n";
  else ans += 0 + "\n";
}
console.log(ans);
