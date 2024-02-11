// boj 1697 숨바꼭질
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
let visited = new Array(100001).fill(0);
let cnt = 0;

let map = Array.from(Array(Math.max(n, k) * 2), () => []);
map[0].push(1);
for (let i = 1; i < map.length; i++) {
  let temp = [];
  temp.push(i - 1, i + 1, i * 2);
  map[i].push(...new Set(temp)); //중복제거
}
console.log(map);

let queue = [];
function bfs(v) {
  while (queue.length > 0) {
    let temp = queue.shift();
    console.log(temp);

    // for (let i = 0; i < map[temp].length; i++) {
    //   if (visited[map[temp][i]] == 0) {
    //     queue.push(map[temp][i]);
    //     visited[map[temp][i]] = 1;
    //     cnt++;
    //   }
    // //   if (visited[map[temp[i]]] === k) return;
    // }
  }
}
bfs(n);
// console.log(cnt);
