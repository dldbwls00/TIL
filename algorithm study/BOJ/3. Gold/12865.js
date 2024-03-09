// boj 12865 평범한 배낭
// dp
// https://yabmoons.tistory.com/571
// 뒤부터 풀면 일차원으로 가능 (변경하지 않은 않은 부분 참조)

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
let arr = Array.from(Array(n + 1), () => Array(2).fill(0));
for (let i = 1; i <= n; i++) [arr[i][0], arr[i][1]] = input[i].split(" ").map(Number); // arr[w][v]

// dp[a][b]=c : a번째 물건까지 왔고 가방의 무게가 b일 때 가방에 담긴 물건들의 가치는 c
let dp = Array.from(Array(n + 1), () => Array(k + 1).fill(0));

// i: 물건 / j: 무게 -> i번째 물건으로 가방의 무게 j를 만들기
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= k; j++) {
    // a를 가방에 넣을 수 있는 경우: a의 가치 + c가 b를 초과하지 않음
    // a를 담는 경우: dp[i - 1][j - arr[i][0]] + arr[i][1]
    // a를 담지 않는 경우: dp[i - 1][j]
    if (j >= arr[i][0]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
    else dp[i][j] = dp[i - 1][j];
  }
}
console.log(dp[n][k]);
