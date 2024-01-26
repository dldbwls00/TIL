// boj 17478 재귀함수가 뭔가요?
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number); //1~50
console.log("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

function printbar(num) {
  for (let i = 0; i < n - num; i++) process.stdout.write("____");
}

function recursion(i) {
  printbar(i);
  console.log('"재귀함수가 뭔가요?"');
  if (i == 0) {
    printbar(i);
    console.log('"재귀함수는 자기 자신을 호출하는 함수라네"');
    printbar(i);
    console.log("라고 답변하였지.");
    return;
  }
  printbar(i);
  console.log('"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.');
  printbar(i);
  console.log("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
  printbar(i);
  console.log('그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."');

  recursion(i - 1);

  printbar(i);
  console.log("라고 답변하였지.");
}

recursion(n);
