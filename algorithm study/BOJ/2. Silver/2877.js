// 참고: https://velog.io/@hygge/Python-%EB%B0%B1%EC%A4%80-2877-4%EC%99%80-7-%EA%B5%AC%ED%98%84
// boj 2877 4와 7
// implementation

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const k = input[0].split(" ").map(Number);

// function digitCalc(k) {
//   let n = 0;
//   let sum = 0;
//   for (; k >= sum; n++) sum += 2 ** n;
//   return n - 1;
// }
// const digit = digitCalc(k);
// let result = [];
// for (let i = 0; i < digit; i++) result.push(4); //initialization

// let sum = 0;
// for (let i = 1; i < digit; i++) sum += 2 ** i;
// let left = k - sum; //얼마나 더해야하는지

// left--;
// for (let i = result.length - 1; i >= 0; i--) {
//   if (left % 2 != 0) result[i] = 7; //나누기로 뒷자리부터 더함
//   if (left < 2) break;
//   left /= 2;
// }

// let ans = "";
// for (let i = 0; i < result.length; i++) ans += result[i];
// console.log(ans);

let result = (parseInt(k) + 1).toString(2);
result = result.replace(/0/g, "4").replace(/1/g, "7");
result = result.slice(1); //맨 앞자리
console.log(result);
