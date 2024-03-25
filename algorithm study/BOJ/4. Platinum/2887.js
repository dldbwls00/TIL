// boj 2887 행성 터널
// mst - kruskal, prim / union find

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const n = parseInt(input[0]);

let planet = [];
for (let i = 0; i < n; i++) {
  const [x, y, z] = input[i + 1].split(" ").map(Number);
  planet.push([i + 1, x, y, z]);
}
// console.log(planet);

// boj 4386처럼 풀면 메모리 초과
// let graph = [];
// for (let i = 0; i < n - 1; i++) {
//   for (let j = i + 1; j < n; j++) {
//     const [x1, y1, z1] = planet[i];
//     const [x2, y2, z2] = planet[j];
//     const cost = Math.min(Math.abs(x1 - x2), Math.abs(y1 - y2), Math.abs(z1 - z2));
//     graph.push([cost, i, j]);
//   }
// }
// graph.sort((a, b) => a[0] - b[0]); //weight순 오름차순 정렬
// // console.log(graph);
// planet = null;

// let parent = new Array(n + 1);
// for (let i = 0; i <= n; i++) parent[i] = i;

// //사이클이 생기지 않도록 하기 위해 union find 이용
// function findparent(x) {
//   if (parent[x] === x) return x;
//   else return (parent[x] = findparent(parent[x]));
// }
// function unionparent(x, y) {
//   let tempx = findparent(x);
//   let tempy = findparent(y);
//   parent[tempy] = tempx;
// }
// function sameparent(x, y) {
//   let tempx = findparent(x);
//   let tempy = findparent(y);
//   if (tempx === tempy) return 1;
//   else return 0;
// }

// let result = 0;
// for (let i = 0; i < graph.length; i++) {
//   if (sameparent(graph[i][1], graph[i][2]) === 0) {
//     unionparent(graph[i][1], graph[i][2]);
//     result += graph[i][0];
//   }
// }
// console.log(result);

// x, y, z좌표끼리 정렬 후 한 배열에 때려넣고 n-1개 고를 때까지 반복
let xsort = planet.map((v) => [...v]).sort((a, b) => a[1] - b[1]);
let ysort = planet.map((v) => [...v]).sort((a, b) => a[2] - b[2]);
let zsort = planet.map((v) => [...v]).sort((a, b) => a[3] - b[3]);
console.log(xsort);
console.log(ysort);
console.log(zsort);
