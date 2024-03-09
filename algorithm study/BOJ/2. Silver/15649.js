// boj 15649 N과 M (1)
// backtracking
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);

// console.log(n, m);

let arr = new Array(9);
let check = new Array(9);
let result = "";

function solution(x) {
  if (x === m) {
    for (let i = 0; i < m; i++) result += arr[i] + " ";
    result += "\n";
    return;
  }

  //backtracking
  for (let i = 1; i <= n; i++) {
    if (check[i]) continue;
    check[i] = 1;
    arr[x] = i;
    solution(x + 1);
    check[i] = 0;
  }
}

solution(0);
console.log(result);
