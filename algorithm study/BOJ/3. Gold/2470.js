// boj 2470 두 용액
// tree traversal, two pointer, LIS
// two pointer

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

// 틀렸습니다??
// const n = parseInt(input[0]);
// let arr = input[1].split(" ").map(Number);
// arr.sort((a, b) => a - b);
// // console.log(arr);

// let s = 0,
//   e = n - 1;
// let liquid1 = arr[s],
//   liquid2 = arr[e],
//   mixed = arr[s] + arr[e];

// while (s < e) {
//   let temp = arr[s] + arr[e];
//   if (Math.abs(temp) < Math.abs(mixed)) {
//     mixed = temp;
//     liquid1 = arr[s];
//     liquid2 = arr[e];
//   }
//   if (mixed <= 0) s++;
//   else e--;
// }
// console.log(liquid1 + " " + liquid2);
