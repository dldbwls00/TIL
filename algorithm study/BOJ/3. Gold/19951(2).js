const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let calc = new Array(n).fill(0);
for (let i = 0; i < m; i++) {
  const [a, b, k] = input[2 + i].split(" ").map(Number);
  calc[a - 1] += k;
  calc[b] += -k;
}

let prefixsum = new Array(n).fill(0);
prefixsum[0] = calc[0];
for (let i = 1; i < n; i++) prefixsum[i] = prefixsum[i - 1] + calc[i];

for (let i = 0; i < n; i++) arr[i] += prefixsum[i];
let result = "";
for (let i = 0; i < n; i++) result += arr[i] + " ";
console.log(result);
