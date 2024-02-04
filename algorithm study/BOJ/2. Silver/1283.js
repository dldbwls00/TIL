// boj 1283 단축키 지정
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let n = input[0].split(" ").map(Number);
let arr = [];
let exist = [];

for (let i = 0; i < n; i++) {
  let word = input[i + 1].replace(/\r/gi, "").split(" "); //개행문자 \r 제거
  arr.push(word);
  let flag = 0; //단축키 지정 가능 유무

  //1. 단어의 첫 글자를 단축키로 지정
  for (let j = 0; j < word.length; j++) {
    const wordarr = Array.from(word[j]); //단어를 알파벳으로 쪼갬
    // console.log(wordarr);
    if (!exist.includes(word[j][0].toUpperCase())) {
      flag = 1; //단축키 지정
      exist.push(word[j][0].toUpperCase()); //대소문자 구분x

      word[j] = "[" + wordarr[0] + "]";
      for (let k = 1; k < wordarr.length; k++) word[j] += wordarr[k];
      break;
    }
  }

  //2. 모든 단어의 첫 글자가 지정된 경우 알파벳으로
  if (flag === 0) {
    for (let j = 0; j < word.length; j++) {
      const wordarr = Array.from(word[j]); //단어를 알파벳으로 쪼갬
      for (let l = 0; l < wordarr.length; l++) {
        if (!exist.includes(wordarr[l].toUpperCase())) {
          flag = 1;
          exist.push(wordarr[l].toUpperCase()); //대소문자 구분x

          if (l === 1) {
            word[j] = wordarr[0] + "[" + wordarr[l] + "]";
            for (let k = l + 1; k < wordarr.length; k++) word[j] += wordarr[k];
          } else if (l === wordarr.length - 1) {
            word[j] = "";
            for (let k = 0; k < wordarr.length - 1; k++) word[j] += wordarr[k];
            word[j] += "[" + wordarr[l] + "]";
          } else {
            word[j] = "";
            for (let k = 0; k < l; k++) word[j] += wordarr[k];
            word[j] += "[" + wordarr[l] + "]";
            for (let k = l + 1; k < wordarr.length; k++) word[j] += wordarr[k];
          }
          break;
        }
        if (flag === 1) break;
      }
    }

    //3. 단축어를 지정할 수 없는 경우 -> 그대로 놔둠
  }
}
// let result = "";
for (let i = 0; i < arr.length; i++) {
  let temp = arr[i].join(" ");
  console.log(temp);
  //   result += temp + "\n";
}
// console.log(result);
