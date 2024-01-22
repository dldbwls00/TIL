// boj 14929 귀찮아 (SIB)
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0];

let arr = input[1].split(" ").map(Number);

let sum = 0;
if (n === 1) sum = 0;
else {
  let temp = []; //누적합
  temp[0] = arr[0];
  for (let i = 1; i < n; i++) temp[i] = temp[i - 1] + arr[i];
  for (let i = 0; i < n - 1; i++) sum += arr[i] * (temp[n - 1] - temp[i]);
}
console.log(sum);
