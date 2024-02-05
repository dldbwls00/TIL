// boj 21608 상어 초등학교
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
let classroom = Array.from(Array(n), () => new Array(n));
let arr = {};
// for (let i = 0; i < n * n; i++) {
// const student = input[i + 1].split(" ").map(Number)[0];
// const list = input[i+1].split(" ").map(Number)[1]
//   arr[i]={student, []);
// }
