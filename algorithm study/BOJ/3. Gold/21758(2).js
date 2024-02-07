const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const t = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
arr.splice(0, 0, 0);

const prefixsum = new Array(t + 1).fill(0);
prefixsum[1] = arr[1];
for (let i = 1; i <= t; i++) prefixsum[i] = prefixsum[i - 1] + arr[i];

let maximum = -1;
//1.꿀통-벌-벌: 꿀은 1, 오른쪽 벌은 n -> 가운데 벌을 i로 돌림
for (let i = 2; i < t; i++) {
  let honey = prefixsum[i - 1] + (prefixsum[t - 1] - arr[i]);
  maximum = Math.max(maximum, honey);
}

//2. 벌-꿀통-벌: 꿀을 i로 돌림
for (let i = 2; i < t; i++) {
  let honey = prefixsum[i] - arr[1] + (prefixsum[t - 1] - prefixsum[i - 1]);
  maximum = Math.max(maximum, honey);
}

//3. 벌-벌-꿀통: 왼쪽 벌은 1, 꿀은 n -> 가운데 벌을 i로 돌림
for (let i = 2; i < t; i++) {
  let honey = prefixsum[t] - arr[1] - arr[i] + (prefixsum[t] - prefixsum[i]);
  maximum = Math.max(maximum, honey);
}
console.log(maximum);
