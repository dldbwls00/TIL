// boj 1914 하노이 탑
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number); //1~100
let result = [];
function hanoi(n, start, via, end) {
  if (n == 1) {
    result.push([start, end]);
    return;
  }
  hanoi(n - 1, start, end, via); //n-1개를 장대1 -> 장대2
  result.push([start, end]);
  hanoi(n - 1, via, start, end); //n-1개를 장대2 -> 장대3
}

console.log((2n ** BigInt(input) - 1n).toString());
if (n > 20) return;
hanoi(n, 1, 2, 3);
console.log(result.join("\n"));
