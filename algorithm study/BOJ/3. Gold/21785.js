// boj 21758 꿀 따기
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = input[0].split(" ").map(Number); //3~100,000

let arr = [];
arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0);

let temp = []; //누적합
temp[0] = arr[0];
for (let i = 1; i <= n; i++) temp[i] = temp[i - 1] + arr[i];
// console.log(arr);
// console.log(temp);

let maximum = -1;
//1.꿀통-벌-벌: 꿀은 1, 오른쪽 벌은 n -> 가운데 벌을 i로 돌림
for (let i = 2; i < n; i++) {
  let honey = temp[n - 1] - arr[i] + temp[i - 1];
  maximum = Math.max(maximum, honey);
}

//2. 벌-꿀통-벌: 꿀을 i로 돌림
for (let i = 2; i < n; i++) {
  let honey = temp[i] - arr[1] + (temp[n - 1] - temp[i - 1]);
  maximum = Math.max(maximum, honey);
}

//3. 벌-벌-꿀통: 왼쪽 벌은 1, 꿀은 n -> 가운데 벌을 i로 돌림
for (let i = 2; i < n; i++) {
  let honey = temp[n] - arr[1] - arr[i] + (temp[n] - temp[i]);
  maximum = Math.max(maximum, honey);
}
console.log(maximum);
