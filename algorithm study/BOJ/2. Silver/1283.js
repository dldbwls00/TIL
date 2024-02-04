// boj 1283 단축키 지정
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = input[0].split(" ").map(Number);
let exist = [];

function wordcheck(word) {}
function alphacheck(alphabet) {}

for (let i = 0; i < n; i++) {
  let word = input[i + 1].replace(/\r/gi, "").split(" "); //개행문자 \r 제거
  let flag = false; //단축키 지정 가능 유무

  for (let j = 0; j < word.length; j++) {
    let wordarr = Array.from(word[j]); //단어를 알파벳으로 쪼갬

    if (!exist.includes(wordarr[j][0].toUpperCase())) {
      exist.push(word[j][0]);
      break;
    }
  }
  console.log(exist);

  let alphabet = input[i + 1].replace(/\r/gi, "").split(""); //개행문자 \r 제거
  //   console.log(word);
  //   console.log(alphabet);
  wordcheck(word);
  alphacheck(alphabet);
}

// let result = "";
// for (let i = 0; i < n; i++) {
//   for (let j = 0; j < m; j++) result += arr[i][j] + " ";
//   result += "\n";
// }
// console.log(result);
