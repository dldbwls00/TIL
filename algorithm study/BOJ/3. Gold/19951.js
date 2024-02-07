// boj 19951 태상이의 훈련소 생활
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);

let arr = [];
arr = input[1].split(" ").map(Number);

let temp = new Array(n).fill(0); //누적합
for (let i = 0; i < m; i++) {
  const [a, b, k] = input[i + 2].split(" ").map(Number);
  temp[a - 1] += k;
  temp[b] -= k;
}
let sum = 0;
for (let i = 0; i < n; i++) {
  sum += temp[i]; //명령의 누적합
  arr[i] += sum; //누적합을 원래 배열에 더함
  process.stdout.write(arr[i] + " ");
}

// const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// // const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

// const [n, m] = input[0].split(" ").map(Number);
// const arr = input[1].split(" ").map(Number);
// let result = "";
// for (let i = 0; i < m; i++) {
//   const [a, b, k] = input[i + 2].split(" ").map(Number);
//   for (let j = a - 1; j <= b - 1; j++) arr[j] += k;
// }

// for (let i = 0; i < n; i++) result += arr[i] + " ";
// console.log(result);
