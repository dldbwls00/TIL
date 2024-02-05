const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = BigInt(input[0]); //10만 이하
const arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0); //array.splice("위치", 0, ["요소1", "요소2" ... ])

const prefixsum = new Array(n).fill(0);
for (let i = 1; i <= n; i++) {
  if (i === 1) prefixsum[i] = arr[i];
  else prefixsum[i] = prefixsum[i - 1] + arr[i];
}

let result = 0;
for (let i = 1; i < n; i++) {
  result += arr[i] * (prefixsum[n] - prefixsum[i]); //a*b + a*c = a*(b+c)
}
console.log(result);
