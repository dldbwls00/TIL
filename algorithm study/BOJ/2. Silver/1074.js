// boj 1074 Z
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const temp = input[0].split(" ").map(Number);
const n = temp[0];
const r = temp[1];
const c = temp[2];

