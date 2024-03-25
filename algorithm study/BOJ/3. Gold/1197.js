// boj 1197 최소 스패닝 트리
// mst - kruskal, prim / union find
// kruskal: https://velog.io/@fldfls/%EC%B5%9C%EC%86%8C-%EC%8B%A0%EC%9E%A5-%ED%8A%B8%EB%A6%AC-MST-%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC-%ED%94%84%EB%A6%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
// union find algorithm: https://baebalja.tistory.com/317 , https://blog.naver.com/ndb796/221230967614

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const [v, e] = input[0].split(" ").map(Number);

let graph = [];
for (let i = 0; i < e; i++) {
  const [a, b, c] = input[i + 1].split(" ").map(Number);
  graph.push([c, a, b]);
}
graph.sort((a, b) => a[0] - b[0]); //weight순 정렬

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

let result = 0;
for (let i = 0; i < graph.length; i++) {
  if (sameparent(graph[i][1], graph[i][2]) === 0) {
    unionparent(graph[i][1], graph[i][2]);
    result += graph[i][0];
  }
}
console.log(result);
