// boj 1074 Z
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const temp = input[0].split(" ").map(Number);
const n = temp[0];
const r = temp[1];
const c = temp[2];
let ans = 0;

function z(y, x, size) {
  if (y == r && x == c) {
    console.log(ans);
    return;
  }

  if (r < y + size && r >= y && c < x + size && c >= x) {
    //(r, c)가 현재 사분면에 존재하는 경우
    z(y, x, size / 2); // 1
    z(y, x + size / 2, size / 2); // 2
    z(y + size / 2, x, size / 2); // 3
    z(y + size / 2, x + size / 2, size / 2); // 4
  } else ans += size * size;
}

z(0, 0, 2 ** n);
