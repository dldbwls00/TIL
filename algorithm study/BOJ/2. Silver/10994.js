// boj 10994 별 찍기 - 19
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const n = input[0].split(" ").map(Number);

const maximum = (n - 1) * 4 + 1; //가장 바깥 테두리 길이: 99*4+1=397
let map = Array.from(Array(maximum), () => Array(maximum).fill(" "));

function star(n, xy) {
  const len = (n - 1) * 4 + 1;
  if (n === 0) return;
  if (n === 1) {
    map[xy][xy] = "*";
    return;
  }
  for (let i = xy; i < xy + len; i++) {
    //가로
    map[i][xy] = "*";
    map[i][xy + len - 1] = "*";

    //세로
    map[xy][i] = "*";
    map[xy + len - 1][i] = "*";
  }
  return star(n - 1, xy + 2);
}
star(n, 0);

let result = "";
for (let i = 0; i < maximum; i++) {
  for (let j = 0; j < maximum; j++) result += map[i][j];
  result += "\n";
}
console.log(result);
