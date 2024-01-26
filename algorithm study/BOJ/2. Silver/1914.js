// boj 1914 하노이 탑
// recursion
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number); //1~100

let k = 0; //옮긴 횟수
