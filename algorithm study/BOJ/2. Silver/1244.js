// boj 1244 스위치 켜고 끄기
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number); //스위치 개수
let arr = input[1].split(" ").map(Number); //스위치
const student = input[2].split(" ").map(Number); //학생 수

function boy(number) {
  for (let i = 1; i <= Math.floor(n / number); i++) {
    if (arr[number * i - 1] === 0) arr[number * i - 1] = 1;
    else arr[number * i - 1] = 0;
  }
}
function girl(number) {
  for (let i = 1; i <= Math.min(number - 1, n - number); i++) {
    if (arr[number - 1 - i] === arr[number + i - 1]) {
      if (arr[number - 1 - i] === 0) arr[number - 1 - i] = arr[number + i - 1] = 1;
      else arr[number - 1 - i] = arr[number + i - 1] = 0;
    } else break;
  }
  if (arr[number - 1] === 0) arr[number - 1] = 1;
  else arr[number - 1] = 0;
}

for (let i = 0; i < student; i++) {
  const temp = input[i + 3].split(" ").map(Number);
  if (temp[0] === 1) boy(temp[1]);
  else girl(temp[1]);
}

let result = "";
for (let i = 0; i < n; i++) {
  result += arr[i] + " ";
  if ((i + 1) % 20 == 0) result += "\n";
}
console.log(result);
