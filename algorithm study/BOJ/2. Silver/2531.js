// boj 2531 회전 초밥
// tree traversal, two pointer, LIS
// sliding window

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, d, k, c] = input[0].split(" ").map(Number);
let sushi = [];
for (let i = 0; i < n; i++) sushi.push(parseInt(input[i + 1]));
// console.log(n, d, k, c);
// console.log("sushi: " + sushi);

// let arr = sushi.slice();
// for (let i = 0; i < k - 1; i++) arr.push(sushi[i]);
// console.log("arr: " + arr);

// 시간초과
// let num = [];
// for (let i = 0; i < arr.length - k; i++) {
//   let temp = [];
//   temp.push(arr[i]);
//   for (let j = i + 1; j < i + k; j++) {
//     if (!temp.includes(arr[j])) temp.push(arr[j]);
//   }
//   num.push(temp.length);
// }

// const maximum = Math.max(...num);
// let flag = 0;
// for (let i = 0; i < n; i++) {
//   if (num[i] === maximum) {
//     let temp = [];
//     for (let j = i; j < i + k; j++) temp.push(arr[j]);
//     if (!temp.includes(c)) flag = 1;
//   }
// }
// if (flag === 1) console.log(maximum + 1);
// else console.log(maximum);

// 시간초과
// let maximum = 0;
// for (let i = 0; i < arr.length - k - 1; i++) {
//   let temp = [];
//   let coupon = 0;
//   for (let j = i; j < i + k; j++) {
//     if (!temp.includes(arr[j])) temp.push(arr[j]);
//   }
//   if (!temp.includes(c)) coupon++;
//   maximum = Math.max(maximum, temp.length + coupon);
//   // console.log("temp: " + temp);
// }
// console.log(maximum);

let maximum = 0;
let visited = new Array(d).fill(0);
for (let i = 0; i < n; i++) {
  let coupon = 1;
  let visit = 0;
  for (let j = i; j < i + k; j++) {
    if (visited[sushi[j % n]] === 1) visit++;
    else visited[sushi[j % n]] = 1;
    if (sushi[j % n] === c) coupon = 0;
  }
  // console.log(visited);
  // console.log(visit);
  maximum = Math.max(maximum, k - visit + coupon);
  visited.fill(0);
}
console.log(maximum);
