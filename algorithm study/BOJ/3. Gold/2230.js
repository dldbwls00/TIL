// boj 2230 두 수의 합
// tree traversal, two pointer, LIS
// two pointer

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let arr = [];
for (let i = 0; i < n; i++) arr.push(parseInt(input[i + 1]));
arr.sort((a, b) => a - b);
// console.log(n, m);
// console.log(arr);

// 시간 초과
// let minimum = Number.MAX_SAFE_INTEGER;
// for (let i = 0; i < n - 1; i++) {
//   for (let j = i + 1; j < n; j++) {
//     let temp = arr[j] - arr[i];
//     if (temp >= m) minimum = Math.min(minimum, temp);
//   }
// }
// console.log(minimum);

let s = 0;
let e = 0;
let minimum = Number.MAX_SAFE_INTEGER;

while (s < n && e < n && s <= e) {
  let temp = arr[e] - arr[s];
  if (temp >= m) {
    minimum = Math.min(minimum, temp);
    s++;
  } else e++;
}
console.log(minimum);
