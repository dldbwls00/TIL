// boj 2447 별 찍기 - 10
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
let result = "";

function star(i, j, n) {
  if (Math.floor(i / n) % 3 === 1 && Math.floor(j / n) % 3 === 1) result += " ";
  else {
    if (Math.floor(n / 3) === 0) result += "*";
    else star(i, j, n / 3);
  }
}

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) star(i, j, n);
  result += "\n";
}
console.log(result);
