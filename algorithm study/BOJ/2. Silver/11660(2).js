const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let arr = Array.from(Array(n + 1), () => Array(n + 1).fill(0));

for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    arr[i][j] = input[i].split(" ").map(Number)[j - 1];
  }
}

let prefixsum = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    if ((i === j) === 1) prefixsum[i][j] = arr[i][j];
    else {
      // prefixsum[i][j] =
    }
  }
}

let result = "";
for (let i = 0; i < m; i++) {
  const [x1, y1, x2, y2] = input[n + 1 + i].split(" ").map(Number);
}
console.log(result);
