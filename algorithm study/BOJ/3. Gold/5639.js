// boj 5639 이진 검색 트리
// tree traversal, two pointer, LIS
// tree traversal
// boj 1991 코드 활용: https://www.acmicpc.net/problem/1991

// https://www.acmicpc.net/board/view/107786
let input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n").map(Number);
// let input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n").map(Number);

let tree = {}; //객체: 노드와 자식의 값 배열을 하나로 저장
let ans = "";

//제일 처음은 root, root보다 큰 것이 나오기 전까지가 left
function maketree(node, arr) {
  if (node === ".") return;
  if (arr.length === 0) return;
  tree[node] = [];
  let root = arr.indexOf(node);
  let left = [];
  let right = [];
  for (let i = root + 1; i < arr.length; i++) {
    if (arr[i] < node) left.push(arr[i]);
    else right.push(arr[i]);
  }
  // console.log("node: " + node);
  // console.log("left: " + left);
  // console.log("right: " + right);

  if (left.length !== 0) tree[node][0] = left[0];
  else tree[node][0] = ".";
  if (right.length !== 0) tree[node][1] = right[0];
  else tree[node][1] = ".";
  // console.log(tree);
  // console.log();
  maketree(left[0], left);
  maketree(right[0], right);
}

function postorder(node) {
  if (node == ".") return;
  let [l, r] = tree[node];

  postorder(tree[node][0]);
  postorder(tree[node][1]);
  ans += node + "\n";
}
maketree(input[0], input);
postorder(input[0]);
console.log(ans.substring(0, ans.length - 1));
// console.log(ans);
