// boj 1541 잃어버린 괄호
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

// 최소가 되려면 빼기 연산이 중요
// 빼기 연산 앞뒤로 전부 묶어서 수를 크게 만들고 최종으로 빼기 진행
// 첫 번째 수가 음수인 경우는 제외하고 묶어야함

let arr = input[0].split("-");

let result = 0;
if (arr[0] === "") {
  let temp = arr[1].split("+");
  for (let i = 0; i < temp.length; i++) result -= parseInt(temp[i]);
} else {
  let temp = arr[0].split("+");
  for (let i = 0; i < temp.length; i++) result += parseInt(temp[i]);
}

for (let i = 1; i < arr.length; i++) {
  let temp = arr[i].split("+");
  for (let j = 0; j < temp.length; j++) result -= parseInt(temp[j]);
}
console.log(result);
