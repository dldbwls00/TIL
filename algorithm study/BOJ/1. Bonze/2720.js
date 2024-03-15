// boj 2720 세탁소 사장 동혁
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const t = parseInt(input[0]);

let result = "";
for (let i = 0; i < t; i++) {
  let quarter = 0;
  let dime = 0;
  let nickel = 0;
  let penny = 0;
  let money = parseInt(input[i + 1]);
  if (Math.floor(money / 100) > 0) {
    quarter = Math.floor(money / 100) * 4;
    money = money % 100;
  }
  if (Math.floor(money / 10) > 0) {
    if (money >= 25) {
      quarter += Math.floor(money / 25);
      money -= Math.floor(money / 25) * 25;
    }
    dime = Math.floor(money / 10);
    money = money % 10;
  }
  if (money >= 5) {
    nickel = 1;
    money -= 5;
  }
  penny = money;
  result += quarter + " " + dime + " " + nickel + " " + penny + "\n";
}
console.log(result);
