// boj 3273 두 수의 합
// tree traversal, two pointer, LIS
// two pointer

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
const arr = input[1].split(" ").map(Number);
const x = parseInt(input[2]);
arr.sort((a, b) => a - b);

// 시간초과
// let result = [];
// for (let i = 0; i < arr.length; i++) {
//   if (arr.includes(x - arr[i])) result.push([arr[i], x - arr[i]]);
// }
// for (let i = 0; i < result.length; i++) result[i].sort((a, b) => a - b);

// // let setarr = [...new Set(result)]; //2차원배열 중복 제거 불가
// // 2차원 배열 중복 제거: https://velog.io/@pdg03092/Javascript-%EB%B0%B0%EC%97%B4%EC%9D%98-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0
// function removeDup(arr) {
//   return [...new Set(arr.join("|").split("|"))].map((v) => v.split(",")).map((v) => v.map((a) => +a));
// }
// let setarr = removeDup(result);
// console.log(setarr.length);

let s = 0;
let e = arr.length - 1;
let cnt = 0;
while (s < e) {
  if (arr[s] + arr[e] === x) {
    s++;
    e--;
    cnt++;
  } else if (arr[s] + arr[e] > x) e--;
  else s++;
}
console.log(cnt);
