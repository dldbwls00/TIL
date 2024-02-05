const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = Array.from(Array(n + 1), () => new Array(m + 1).fill(0));

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= m; j++) {
    arr[i][j] = input[i].split(" ").map(Number)[j - 1];
  }
}
const prefixsum = Array.from(Array(n + 1), () => Array(m + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= m; j++) {
    if (j == 1) prefixsum[i][j] = arr[i][j];
    else prefixsum[i][j] = prefixsum[i][j - 1] + arr[i][j];
  }
}

const k = input[n + 1].split(" ").map(Number)[0];
let result = "";
for (let a = 0; a < k; a++) {
  //   const i = input[n + 2 + a].split(" ").map(Number)[0];
  //   const j = input[n + 2 + a].split(" ").map(Number)[1];
  //   const x = input[n + 2 + a].split(" ").map(Number)[2];
  //   const y = input[n + 2 + a].split(" ").map(Number)[3];
  const [i, j, x, y] = input[n + 2 + a].split(" ").map(Number);
  let sum = 0;
  if (i === x && j === y) {
    result += arr[i][j] + "\n";
    continue;
  }

  for (let a = i; a <= x; a++) sum += prefixsum[a][y] - prefixsum[a][j - 1];
  result += sum + "\n";
}

console.log(result);
