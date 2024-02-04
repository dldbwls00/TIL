// boj 2877 4와 7
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const k = input[0].split(" ").map(Number);

function digit(k) {
  let n = 0;
  let sum = 0;
  for (; k >= sum; n++) sum += 2 ** n;
  //   console.log(n);
  //   console.log(sum);
  return n - 1;
}

digit(k);
