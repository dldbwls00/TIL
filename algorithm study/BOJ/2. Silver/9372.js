// boj 9372 상근이의 여행
// mst - kruskal, prim

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

// bfs로 풀다가 포기
// let t = parseInt(input[0]);
// let tempm = 0;
// let result = "";
// const dx = [0, 1, -1];
// function bfs(arr, x) {
//   let cnt = new Array(n + 1).fill(0);
//   queue.push(x);
//   cnt[x]++;
//   while (queue.length > 0) {
//     const xx = queue.shift();
//     for (let i = 0; i < 3; i++) {
//         let nx = xx+dx[i];
//         if (nx>0 && nx<=arr.length-1; &&)
//     }
//   }
//   return cnt[arr.length - 1];
// }
// while (t--) {
//   let [n, m] = input[1 + tempm].split(" ").map(Number);
//   let plane = Array.from(Array(n + 1), () => new Array());
//   for (let i = 1; i <= m; i++) {
//     let [a, b] = input[1 + tempm + i].split(" ").map(Number);
//     plane[a].push(b);
//     plane[b].push(a);
//   }
//   tempm += m + 1;
//   console.log(plane);
// }

// 주어지는 비행 스케줄은 항상 연결 그래프를 이루며 가중치가 없음
// 연결 그래프: 모든 노드가 연결되어 있음
// spanning tree: 그래프의 최소 연결 부분 그래프(edge 수가 최소인 n-1), 사이클이 없음
// mst: spanning tree 중 간선들의 가중치 합이 최소인 트리

// 그냥 n-1만 출력해도 정답!
let t = parseInt(input[0]);
let tempm = 0;
let result = "";
while (t--) {
  let [n, m] = input[1 + tempm].split(" ").map(Number);
  // spanning tree: 그래프의 최소 연결 부분 그래프(edge 수가 최소인 n-1), 사이클이 없음
  result += n - 1 + "\n";
  tempm += m + 1;
}
console.log(result);
