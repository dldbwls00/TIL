// boj 1911 트리 순회
// recursion

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = input[0].split(" ").map(Number); //1~26

let tree = {}; //객체: 노드와 자식의 값 배열을 하나로 저장
for (let i = 1; i <= n; i++) {
  const [node, left, right] = input[i].replace(/\r/gi, "").split(" "); //개행문자 \r 제거
  tree[node] = [left, right];
}
// console.log(tree);
// console.log(tree["A"]);

let ans = "";
function preorder(node) {
  if (node == ".") return;
  let [l, r] = tree[node];

  ans += node;
  preorder(tree[node][0]);
  preorder(tree[node][1]);
}
function inorder(node) {
  if (node == ".") return;
  let [l, r] = tree[node];

  inorder(tree[node][0]);
  ans += node;
  inorder(tree[node][1]);
}
function postorder(node) {
  if (node == ".") return;
  let [l, r] = tree[node];

  postorder(tree[node][0]);
  postorder(tree[node][1]);
  ans += node;
}

preorder("A");
ans += "\n";
inorder("A");
ans += "\n";
postorder("A");
ans += "\n";
console.log(ans);
