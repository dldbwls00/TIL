// boj 15686 치킨 배달
// implementation
const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let map = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));
let house = [];
let chicken = [];
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= n; j++) {
    map[i][j] = input[i].split(" ").map(Number)[j - 1];
    if (map[i][j] === 1) house.push([i, j]);
    if (map[i][j] === 2) chicken.push([i, j]);
  }
}

function calcdist(x1, y1, x2, y2) {
  return Math.abs(x1 - x2) + Math.abs(y1 - y2);
}

let dist = [];
for (let j = 0; j < chicken.length; j++) {
  let temp = [];
  for (let i = 0; i < house.length; i++) {
    temp.push(calcdist(house[i][0], house[i][1], chicken[j][0], chicken[j][1]));
  }
  dist.push(temp);
}
// console.log(dist);

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
for (let i = 1; i <= m; i++) {
  let temp = combi(dist, i);
  for (let j = 0; j < temp.length; j++) combiresult.push(temp[j]);
}
console.log(combiresult);

let sum = [];
for (let i = 0; i < combiresult.length; i++) {
  let combisum = 0;
  for (let k = 0; k < house.length; k++) {
    if (combiresult[i].length === 1) {
      combisum += combiresult[i][0][k];
    } else {
      let min = combiresult[i][0][k];
      for (let j = 0; j < combiresult[i].length; j++) {
        min = Math.min(min, combiresult[i][j][k]);
      }
      combisum += min;
    }
  }
  sum.push(combisum);
}
sum.sort((a, b) => a - b);
console.log(sum[0]);
