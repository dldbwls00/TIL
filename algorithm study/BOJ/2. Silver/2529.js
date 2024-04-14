// boj 2529 부등호
// union find, topological sorting
// 둘 다 아닌 듯? backtracking 풀이 참고 https://kangeee.tistory.com/155

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const k = parseInt(input[0]); //2 ≤ k ≤ 9
const a = input[1].split(" ");
let visited = new Array(10).fill(0);
let result = [];

function check(s) {
  for (let i = 0; i < k; i++) {
    if (a[i] === "<" && parseInt(s[i]) > parseInt(s[i + 1])) return false;
    if (a[i] === ">" && parseInt(s[i]) < parseInt(s[i + 1])) return false;
  }
  return true;
}

function recursion(cnt, s) {
  if (cnt === k + 1) {
    if (check(s)) result.push(parseInt(s));
    return;
  }

  for (let i = 0; i < 10; i++) {
    if (visited[i]) continue;
    visited[i] = 1;
    recursion(cnt + 1, s + i.toString());
    visited[i] = 0; //backtracking
  }
}

recursion(0, "");
result.sort((a, b) => a - b);

if (result[result.length - 1].toString().length !== k + 1)
  console.log(result[result.length - 1].toString().padStart(k + 1, "0"));
else console.log(result[result.length - 1]);

if (result[0].toString().length !== k + 1) console.log(result[0].toString().padStart(k + 1, "0"));
else console.log(result[0]);
