// boj 1105 팔
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const [l, r] = input[0].split(" ").map(Number);

// 시간 초과
// let minimum = Number.MAX_SAFE_INTEGER;
// for (let i = l; i <= r; i++) {
//   let temp = String(i).split("");
//   let count = temp.reduce((cnt, element) => cnt + ("8" === element), 0); // 특정 값 개수 세기: https://hianna.tistory.com/488
//   minimum = Math.min(minimum, count);
// }
// console.log(minimum);

let left = String(l).split("");
let right = String(r).split("");
let result;
if (left.length !== right.length) result = 0;
else {
  let cnt = 0;
  for (let i = 0; i < left.length; i++) {
    //if ((left[i] === right[i]) === "8") cnt++; 로 풀면 안 됨
    if (left[i] === right[i]) {
      if (left[i] === "8") cnt++;
    } else break;
  }
  result = cnt;
}
console.log(result);
