// boj 2252 줄 세우기
// union find, topological sorting
// 위상정렬 개념: https://velog.io/@kimdukbae/%EC%9C%84%EC%83%81-%EC%A0%95%EB%A0%AC-Topological-Sorting

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");
const [n, m] = input[0].split(" ").map(Number);

let graph = Array.from(Array(n + 1), () => []);
let indegree = new Array(n + 1).fill(0); // 진입차수
for (let i = 0; i < m; i++) {
  const [a, b] = input[i + 1].split(" ").map(Number);
  graph[a].push(b);
  indegree[b]++;
}
let result = "";

//1. 진입 차수가 0인 모든 노드를 큐에 삽입
let queue = [];
for (let i = 1; i <= n; i++) if (indegree[i] === 0) queue.push(i);

//2. 큐의 노드를 하나씩 꺼내며 그 노드와 연결돼있는 간선 제거
while (queue.length !== 0) {
  let node = queue.shift();
  let linked = graph[node];
  result += node + " ";
  for (let i = 0; i < linked.length; i++) {
    indegree[linked[i]]--;
    if (indegree[linked[i]] == 0) queue.push(linked[i]);
  }
}

console.log(result);
