const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [r, c, q] = input[0].split(" ").map(Number);
let arr = [];

for (let i = 1; i <= r; i++) {
  arr.push(input[i].split(" ").map(Number));
}
// console.log(arr);

let prefixsum = Array.from(Array(r + 1), () => Array(c + 1).fill(0));
prefixsum[1][1] = arr[0][0];
for (let i = 1; i <= r; i++) {
  for (let j = 1; j <= c; j++) {
    prefixsum[i][j] = prefixsum[i - 1][j] + prefixsum[i][j - 1] - prefixsum[i - 1][j - 1] + arr[i - 1][j - 1];
  }
}
// console.log(prefixsum);

let result = "";
for (let i = 0; i < q; i++) {
  const [r1, c1, r2, c2] = input[r + 1 + i].split(" ").map(Number);
  let temp = prefixsum[r2][c2] - prefixsum[r2][c1 - 1] - prefixsum[r1 - 1][c2] + prefixsum[r1 - 1][c1 - 1];
  let div = Math.floor(temp / ((r2 - r1 + 1) * (c2 - c1 + 1)));
  result += div + "\n";
}
console.log(result);
