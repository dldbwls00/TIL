// boj 1759 암호 만들기
// backtracking
// 조합 함수 https://velog.io/@rlatp1409/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-JS-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9-%EA%B5%AC%ED%98%84-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [l, c] = input[0].split(" ").map(Number);
const arr = input[1].split(" ");
// console.log(l, c);
// console.log(arr);

const combination = (comb, rests, output) => {
  if (comb.length == l) {
    return output.push(comb);
  }
  rests.forEach((v, idx) => {
    // const rest = [...rests.slice(0,idx), ...rests.slice(idx+1)]
    const rest = rests.slice(idx + 1);
    combination([...comb, v], rest, output);
  });
};

const output = [];
combination([], arr, output);
// output.sort();
// console.log(output);

let result = [];
for (let i = 0; i < output.length; i++) {
  let vcnt = 0;
  let ccnt = 0;
  for (let j = 0; j < l; j++) {
    if (
      output[i][j] === "a" ||
      output[i][j] === "e" ||
      output[i][j] === "i" ||
      output[i][j] === "o" ||
      output[i][j] === "u"
    )
      vcnt++;
    else ccnt++;
    if (vcnt >= 1 && ccnt >= 2) {
      result.push(output[i]);
      break;
    }
  }
}
for (let i = 0; i < result.length; i++) result[i].sort();
result.sort();
// console.log(result);

let answer = "";
for (let i = 0; i < result.length; i++) {
  for (let j = 0; j < l; j++) answer += result[i][j];
  answer += "\n";
}
console.log(answer);
