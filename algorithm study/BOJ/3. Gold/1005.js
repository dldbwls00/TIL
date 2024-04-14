// boj 1005 ACM Craft
// union find, topological sorting
// 위상정렬 개념: https://velog.io/@kimdukbae/%EC%9C%84%EC%83%81-%EC%A0%95%EB%A0%AC-Topological-Sorting
// https://openmynotepad.tistory.com/17

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const t = parseInt(input[0]);
let line = 1;
for (let i = 0; i < t; i++) {
  let [n, k] = input[line].split(" ").map(Number);
  let d = input[++line].split(" ").map(Number);
  d.splice(0, 0, 0);
  //   console.log(n, k);
  //   console.log(d);

  let graph = Array.from(Array(n + 1), () => []);
  //   console.log(graph);
  //   console.log(line);
  let indegree = new Array(n + 1).fill(0); // 진입차수
  for (let j = 0; j < k; j++) {
    const [x, y] = input[++line].split(" ").map(Number);
    graph[x].push(y);
    indegree[y]++;
  }
  let w = parseInt(input[++line]);

  //1. 진입 차수가 0인 모든 노드를 큐에 삽입
  let queue = [];
  for (let i = 1; i <= n; i++) if (indegree[i] === 0) queue.push(i);
  //   console.log(queue);

  //2. 큐의 노드를 하나씩 꺼내며 그 노드와 연결돼있는 간선 제거
  let result = new Array(n + 1).fill(0);
  while (indegree[w] > 0) {
    let node = queue.shift();
    let linked = graph[node];
    // console.log(linked.length);
    for (let i = 0; i < linked.length; i++) {
      indegree[linked[i]]--;
      if (indegree[linked[i]] == 0 && !queue.includes(linked[i])) queue.push(linked[i]);
      //   console.log(indegree);
      //   console.log(queue);
      result[linked[i]] = Math.max(result[linked[i]], result[node] + d[node]);
      //   console.log(result);
    }
  }
  line++;
  console.log(result[w] + d[w]);
}

// console.log(result);
