// boj 21608 상어 초등학교
// implementation
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);

let list = Array.from(Array(n ** 2));
for (let i = 0; i < n ** 2; i++) {
  const stu = input[i + 1].split(" ").map(Number)[0];
  const fav = input[i + 1].split(" ").map(Number);
  fav.shift();
  list[i] = [stu, fav];
}
// console.log(list);

let map = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));
let visited = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));

const dx = [0, 1, 0, -1]; //북, 동, 남, 서 (시계 방향)
const dy = [1, 0, -1, 0];
