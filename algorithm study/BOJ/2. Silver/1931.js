// boj 1931 회의실 배정
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = [];
for (let i = 0; i < n; i++) {
  let [start, end] = input[i + 1].split(" ").map(Number);
  arr.push([start, end]);
}
