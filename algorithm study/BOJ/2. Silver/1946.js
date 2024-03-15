// boj 1946 신입 사원
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const t = parseInt(input[0]);
let result = "";
let arr = [];
let idx = 1;
let n;

// 주어진 숫자는 점수가 아니라 순위
// 서류 점수 순서대로 오름차순 정렬 -> 서류 점수 일등의 면접 점수를 저장함
// 아래로 내려가면서 이 사람의 면접 점수보다 높으면 뽑힐 수 있음
// 뽑히면 저장된 면접 점수 갱신: 내려갈수록 뽑힌 사람보다 서류 점수가 낮으므로 이 사람의 면접 점수보다 높아야하니까

function pick(arr) {
  // arr[0]이 같으면 arr[1] 기준으로 오름차순 정렬
  arr.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    else return a[0] - b[0];
  });

  let standard = arr[0][1];
  let cnt = 1;
  for (let i = 1; i < arr.length; i++) {
    if (arr[i][1] < standard) {
      cnt++;
      standard = arr[i][1];
    }
  }
  result += cnt + "\n";
}

for (let i = 0; i < t; i++) {
  n = parseInt(input[idx++]);
  for (let i = 0; i < n; i++) {
    let [resume, interview] = input[idx + i].split(" ").map(Number);
    arr.push([resume, interview]);
  }
  idx += n;
  pick(arr);
  arr = [];
}
console.log(result);
