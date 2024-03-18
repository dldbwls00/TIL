// boj 1806 부분합
// tree traversal, two pointer, LIS
// two pointer, prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, s] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
// console.log(n, s);
// console.log(arr);

// 메모리 초과: 투포인터 사용해야함
// let prefixsum = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
// for (let i = 1; i <= n; i++) {
//   for (let j = i; j <= n; j++) prefixsum[i][j] = prefixsum[i][j - 1] + arr[j - 1];
// }
// let minimum = Number.MAX_SAFE_INTEGER;
// for (let i = 1; i <= n; i++) {
//   for (let j = i; j <= n; j++) {
//     if (prefixsum[i][j] >= s) minimum = Math.min(minimum, j - i + 1);
//   }
// }
// if (minimum === Number.MAX_SAFE_INTEGER) console.log(0);
// else console.log(minimum);

// 시간 초과: 매번 sum 구하지 말고 누적합 그대로 사용해야함
// let start = 0;
// let end = 0;
// let minimum = Number.MAX_SAFE_INTEGER;
// let temp = 0;
// while (start < n && end < n && start <= end) {
//   temp += arr[end];
//   //   console.log("start: " + start + ", end: " + end + ", temp: " + temp);
//   if (temp >= s) {
//     minimum = Math.min(minimum, end - start + 1);
//     start++;
//     end = start;
//     temp = 0;
//   } else end++;
// //   console.log(minimum);
// }
// if (minimum === Number.MAX_SAFE_INTEGER) console.log(0);
// else if (arr[n - 1] >= s) console.log(1);
// else console.log(minimum);

let start = 0;
let end = 0;
let minimum = Number.MAX_SAFE_INTEGER;
let temp = 0;
//반례 5 10 / 1 2 3 4 5 때문에 end <= n
while (end <= n && start <= end) {
  console.log("start: " + start + ", end: " + end + ", temp: " + temp);
  if (temp >= s) {
    minimum = Math.min(minimum, end - start);
    temp -= arr[start];
    start++;
  } else {
    temp += arr[end];
    end++;
  }
  console.log(minimum);
}

if (arr.length == 1 && arr[0] >= s) console.log(1);
else if (minimum === Number.MAX_SAFE_INTEGER) console.log(0);
else console.log(minimum);
