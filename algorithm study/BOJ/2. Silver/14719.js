// boj 14719 빗물
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const h = input[0].split(" ").map(Number)[0];
const w = input[0].split(" ").map(Number)[1];
const arr = input[1].split(" ").map(Number);
// arr.push(0); //마지막 블록이 벽인지 확인

// let wall = [];
// for (let i = 0; i < w; i++) {
//   if (arr[i] > arr[i + 1]) wall.push(i);
// }

// let rain = 0;
// for (let i = 0; i < wall.length - 1; i++) {
//   const height = Math.min(arr[wall[i]], arr[wall[i + 1]]);
//   for (let j = wall[i] + 1; j < wall[i + 1]; j++) rain += height - arr[j];
// }
// console.log(rain);

let rain = 0;
for (let i = 1; i < w - 1; i++) {
  let left = 0,
    right = 0;

  for (let j = 0; j < i; j++) {
    if (arr[i] < arr[j]) left = Math.max(left, arr[j]); //왼쪽 벽
  }
  for (let j = i + 1; j < w; j++) {
    if (arr[i] < arr[j]) right = Math.max(right, arr[j]); //오른쪽 벽
  }

  if ((left !== 0) & (right !== 0)) rain += Math.min(left, right) - arr[i];
}
console.log(rain);
