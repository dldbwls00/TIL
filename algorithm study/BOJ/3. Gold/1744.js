// boj 1744 수 묶기
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = [];
for (let i = 0; i < n; i++) arr.push(parseInt(input[i + 1]));

// 양수는 큰 수끼리 묶어야 함
// 음수와 양수, 0과 양수를 묶으면 안 됨
// 양수 중 1이 있으면 묶지 말고 그냥 더함
// 1. 음수가 0개인 경우: 0이 있으면 묶지 않고 그냥 더한다
// 2. 음수가 1개인 경우: 0이 있으면 음수와 묶고, 없다면 묶지 않고 그냥 더한다
// 3. 음수가 2개인 경우: 음수끼리 묶는다
// 4. 음수가 3개인 경우: 가장 작은 음수 두 개를 묶고, 0이 있으면 세 번째로 음수와 묶고, 없다면 묶지 않고 그냥 더한다
// 5. 음수가 4개인 경우: 작은 순서대로 두 개씩 묶는다
// 즉 음수가 홀수개며 0이 있다면 가장 큰 음수는 0과 묶고, 없다면 그냥 더함
// 음수가 짝수개라면 작은 수부터 차례로 두 개씩 묶음

arr.sort((a, b) => a - b);

let minus = [];
let zero = 0;
let plus = [];
for (let i = 0; i < arr.length; i++) {
  if (arr[i] < 0) minus.push(arr[i]);
  if (arr[i] === 0) zero++;
  if (arr[i] > 0) plus.push(arr[i]);
}

let result = 0;

plus.sort((a, b) => b - a); //내림차순
if (plus.length === 0) {
} else if (plus.length === 1) result += plus[0];
else {
  for (let i = 1; i < plus.length; i += 2) {
    if (plus[i - 1] === 1 || plus[i] === 1) result += plus[i - 1] + plus[i];
    else result += plus[i - 1] * plus[i];
  }
  if (plus.length % 2 === 1) result += plus[plus.length - 1];
}

if (minus.length === 0) {
} else if (minus.length === 1) {
  if (zero !== 0) zero--;
  else result += minus[0];
} else {
  for (let i = 1; i < minus.length; i += 2) result += minus[i - 1] * minus[i];
  if (minus.length % 2 === 1) {
    if (zero !== 0) zero--;
    else result += minus[minus.length - 1];
  }
}
console.log(result);
