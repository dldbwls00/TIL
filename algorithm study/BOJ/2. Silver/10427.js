// 참고 https://gundol97.tistory.com/89
// boj 10427 빚
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let sum = new Array(4001).fill(0);
let cnt = 0;
const t = input[0].split(" ").map(Number);
for (let i = 0; i < t; i++) {
  cnt++;
  const temp = input[cnt].split(" ").map(Number);
  const board = new Array(temp[0] + 1).fill(0);
  const sum = new Array(temp[0] + 1).fill(0);

  for (let j = 1; j <= temp[0]; j++) board[j] = temp[j];

  // 최댓값 * M  - (M개의 합)이므로 M보다 작으면서 가장 큰 수들의 조합을 구함
  board.sort((a, b) => a - b); //오름차순 정렬

  let ans = 0;
  for (let j = 1; j <= temp[0]; j++) sum[j] = board[j] + sum[j - 1];
  for (let j = 1; j <= temp[0]; j++) {
    let minimum = 9999999999;
    for (let k = j; k <= temp[0]; k++) {
      minimum = Math.min(minimum, board[k] * j - sum[k] + sum[k - j]);
    }
    ans += minimum;
  }
  console.log(ans);
}
