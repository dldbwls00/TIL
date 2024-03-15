// boj 2138 전구와 스위치
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
const original = input[1].split("");
const want = input[2].split("");
// original.pop(); //개행문자 삭제
let now;
function pushswitch(idx) {
  for (let i = idx - 1; i <= idx + 1; i++) {
    if (i < 0 || i >= n) continue;
    if (now[i] === "0") now[i] = "1";
    else now[i] = "0";
  }
}

// 첫 번째 전구 스위치를 누르는 경우와 누르지 않는 경우로 나눠 그리디 진행
// i-1번째와 비교하는데 첫 번째 전구는 비교할 대상이 없음
function bulb(stat) {
  let cnt = 0;
  now = [...original]; //깊은 복사
  // now = original.slice(); //깊은 복사

  //첫 번째 전구 스위치를 누르는 경우
  if (stat === 1) {
    pushswitch(0);
    cnt++;
  }

  for (let i = 1; i < n; i++) {
    if (now[i - 1] !== want[i - 1]) {
      pushswitch(i);
      cnt++;
    }
  }

  // 두 배열의 비교: JSON.stringify를 통해 문자열로 변경해준 뒤 비교
  if (JSON.stringify(now) !== JSON.stringify(want)) cnt = Number.MAX_SAFE_INTEGER;
  return cnt;
}

let result = Math.min(bulb(0), bulb(1));
if (result === Number.MAX_SAFE_INTEGER) console.log(-1);
else console.log(result);
