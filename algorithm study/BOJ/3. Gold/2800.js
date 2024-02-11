// boj 2800 괄호 제거
// recursion
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const arr = input[0].split("");

let bracket = [];
let index = [];
for (let i = 0; i < arr.length; i++) {
  if (arr[i] === "(") bracket.push(i);
  if (arr[i] === ")") index.push([bracket.pop(), i]);
}

//https://nyang-in.tistory.com/212
const combi = (array, selectNumber) => {
  const results = [];
  if (selectNumber === 1) {
    return array.map((element) => [element]);
  }
  array.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = combi(rest, selectNumber - 1);
    const attached = combinations.map((combination) => [fixed, ...combination]);
    results.push(...attached);
  });
  return results;
};

let combiresult = [];
for (let i = 1; i <= index.length; i++) {
  let temp = combi(index, i);
  for (let j = 0; j < temp.length; j++) combiresult.push(temp[j]);
}

let result = [];
for (let i = 0; i < combiresult.length; i++) {
  let temp = [...arr]; //깊은 복사
  for (let j = 0; j < combiresult[i].length; j++) {
    temp[combiresult[i][j][0]] = "";
    temp[combiresult[i][j][1]] = "";
    result.push(temp);
  }
}

let ans = [];
for (let i = 0; i < result.length; i++) {
  let string = "";
  for (let j = 0; j < result[i].length; j++) {
    string += result[i][j];
  }
  ans.push(string);
}
ans = [...new Set(ans)]; //중복제거
ans.sort();

let final = "";
for (let i = 0; i < ans.length; i++) final += ans[i] + "\n";
console.log(final);
