const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const t = input[0].split(" ").map(Number);
let result = "";

for (let i = 0; i < t; i++) {
  let arr = input[i + 1].split(" ").map(Number);
  const n = arr[0];
  arr[0] = 0;
  arr.sort((a, b) => a - b);

  let prefixsum = new Array(n + 1).fill(0);
  prefixsum[1] = arr[1];
  for (let j = 1; j <= n; j++) prefixsum[j] = prefixsum[j - 1] + arr[j];

  let ans = 0;
  for (let j = 1; j <= n; j++) {
    let minimum = 9999999999;
    for (let k = j; k <= n; k++) {
      minimum = Math.min(minimum, arr[k] * j - prefixsum[k] + prefixsum[k - j]);
    }
    ans += minimum;
  }
  result += ans + "\n";
}
console.log(result);
