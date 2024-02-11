// boj 1697 숨바꼭질
// dfs, bfs
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);

// let map = Array.from(Array(100001), () => []);
// map[0].push(1);
// for (let i = 1; i < map.length; i++) {
//   let temp = [];
//   if (i - 1 <= 100000) temp.push(i - 1);
//   if (i + 1 <= 100000) temp.push(i + 1);
//   if (i * 2 <= 100000) temp.push(i * 2);
//   map[i].push(...new Set(temp)); //중복제거
// }
// console.log(map);

let visited = new Array(100001).fill(0);
let cnt = new Array(100001).fill(0);

function bfs(v) {
  let queue = [];
  queue.push(v);
  visited[v] = 1;
  //   console.log(queue);
  while (queue.length > 0) {
    let temp = queue.shift();
    if (temp === k) break;
    if (visited[temp - 1] === 0 && temp - 1 >= 0 && temp - 1 <= 100000) {
      queue.push(temp - 1);
      visited[temp - 1] = 1;
      cnt[temp - 1] = cnt[temp] + 1;
    }
    if (visited[temp + 1] === 0 && temp + 1 >= 0 && temp + 1 <= 100000) {
      queue.push(temp + 1);
      visited[temp + 1] = 1;
      cnt[temp + 1] = cnt[temp] + 1;
    }
    if (visited[temp * 2] === 0 && temp * 2 >= 0 && temp * 2 <= 100000) {
      queue.push(temp * 2);
      visited[temp * 2] = 1;
      cnt[temp * 2] = cnt[temp] + 1;
    }
    // console.log(queue);
  }
}
bfs(n);
// console.log(cnt);
console.log(cnt[k]);
