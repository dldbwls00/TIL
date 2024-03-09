// boj 2294 동전 2
// dp
// https://yabmoons.tistory.com/535

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
let arr = new Array(n + 1).fill(0);
for (let i = 1; i <= n; i++) arr[i] = parseInt(input[i]);

let dp = new Array(k + 1).fill(Number.MAX_SAFE_INTEGER);
dp[0] = 0;
for (let i = 1; i <= n; i++) dp[arr[i]] = 1;

// x원을 최종적으로 사용해서 k원을 만듦: k-x원을 만들 수 있는 동전의 최소 개수 + 1
// 즉, dp[k] = min(dp[k], dp[k-x]+1)
for (let i = 1; i <= n; i++) {
  for (let j = arr[i]; j <= k; j++) dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
}

if (dp[k] === Number.MAX_SAFE_INTEGER) console.log(-1);
else console.log(dp[k]);
