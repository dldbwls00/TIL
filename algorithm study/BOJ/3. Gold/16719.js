// boj 16719 ZOAC
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const arr = input[0].split("");
let check = Array(arr.length).fill(0);
let result = "";

function recursion(left, right) {
  if (left > right) return;

  let idx = left;
  for (let i = left; i <= right; i++) {
    if (arr[idx] > arr[i]) idx = i;
  }
  check[idx] = 1;

  for (let i = 0; i < arr.length; i++) {
    if (check[i] === 1) result += arr[i];
  }
  result += "\n";

  recursion(idx + 1, right); //오른쪽
  recursion(left, idx - 1); //왼쪽
}
recursion(0, arr.length - 1);
console.log(result);
