// boj 1931 회의실 배정
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
let arr = [];
for (let i = 0; i < n; i++) {
  let [start, end] = input[i + 1].split(" ").map(Number);
  arr.push([end, start]); //start, end 위치 바꿔서 삽입
}

// 1. 시작 시간 기준 오름차순 정렬 -> 앞부터 채우는 경우 (x)
// 2. 끝나는 시간 기준 오름차순 정렬 -> 앞부터 채우는 경우 (o)
// 3. 끝나는 시간 기준 내림차순 정렬 -> 뒤부터 채우는 경우 (x)
// 4. 끝-시작 차이를 구해서 이 시간이 짧은 순서대로 채우기? (?)

// arr[0]이 같으면 arr[1] 기준으로 오름차순 정렬
arr.sort((a, b) => {
  if (a[0] === b[0]) return a[1] - b[1];
  else return a[0] - b[0];
});

let cnt = 1;
let index = 0;
for (let i = 1; i < n; i++) {
  if (arr[index][0] > arr[i][1]) continue; //회의 안 끝남
  index = i;
  cnt++;
}
console.log(cnt);
