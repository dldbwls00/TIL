// boj 12101 1, 2, 3 더하기 2
// backtrackinh

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
// console.log(n, k);

let solution = [];
function dfs(sum, arr) {
  if (sum === n) {
    solution.push(arr);
    return;
  }
  if (sum + 1 <= n) dfs(sum + 1, arr + 1);
  if (sum + 2 <= n) dfs(sum + 2, arr + 2);
  if (sum + 3 <= n) dfs(sum + 3, arr + 3);
}

dfs(0, []);
solution.sort();
// console.log(solution);

if (solution.length < k) console.log(-1);
else {
  let temp = "";
  for (let i = 0; i < solution[k - 1].length - 1; i++) temp += solution[k - 1][i] + "+";
  temp += solution[k - 1][solution[k - 1].length - 1];
  console.log(temp);
}
