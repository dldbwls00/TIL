// 미해결
// boj 17390 이건 꼭 풀어야 해!
// prefix sum

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, q] = input[0].split(" ").map(Number);

let arr = input[1].split(" ").map(Number);
arr.push(0);
arr = arr.sort(); //오름차순 정렬

let temp = []; //누적합
temp[0] = 0;
temp[1] = arr[1];
for (let i = 1; i <= n; i++) temp[i] = arr[i] + temp[i - 1];

for (let i = 0; i < q; i++) {
  const [a, b] = input[i + 2].split(" ").map(Number);
  if (a === b) console.log(arr[a]);
  else console.log(temp[b] - temp[a - 1]);
}
