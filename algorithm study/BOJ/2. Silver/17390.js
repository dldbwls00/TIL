// boj 17390 이건 꼭 풀어야 해!
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, q] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0);
arr.sort((a, b) => a - b);

const prefixsum = new Array(n).fill(0);
for (let i = 1; i <= n; i++) {
  if (i === 1) prefixsum[i] = arr[i];
  else prefixsum[i] = prefixsum[i - 1] + arr[i];
}

let result = "";
for (let i = 0; i < q; i++) {
  const [l, r] = input[i + 2].split(" ").map(Number);
  result += prefixsum[r] - prefixsum[l - 1] + "\n";
}
console.log(result);
