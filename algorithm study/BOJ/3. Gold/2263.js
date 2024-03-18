// boj 2263 트리의 순회
// tree traversal, two pointer, LIS
// tree traversal
// preorder -> postorder: https://www.acmicpc.net/problem/5639
// 반례: https://bingorithm.tistory.com/5

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const n = parseInt(input[0]);
const inorderarr = input[1].split(" ").map(Number);
const postorderarr = input[2].split(" ").map(Number);

// console.log("n: " + n);
// console.log("inorderarr: " + inorderarr);
// console.log("postorderarr: " + postorderarr);

//트리는 n개의 정점을 갖고, 1부터 n까지 중복 없이 번호를 가짐
//이진탐색트리가 아님: 노드의 크기 조건 없이 inorder와 postorder만 주어짐
//최초 root는 postorder의 맨 끝 값
//최초 root를 기준으로 inorder를 이용해 left, right로 나눔
//나눈 서브트리에서도 맨 끝 값이 그 서브트리의 root
//이 root를 기준으로 inorder를 이용해 left, right로 나눔

let tree = {};
let ans = "";

function maketree(node, postarr, inarr) {
  if (node === ".") return;
  if (postarr.length === 0) return;

  tree[node] = [];
  let inIdx = inarr.indexOf(node);
  let postLeft = [];
  let postRight = [];
  let inLeft = [];
  let inRight = [];

  for (let i = 0; i < inIdx; i++) {
    postLeft.push(postarr[i]);
    inLeft.push(inarr[i]);
  }
  for (let i = inIdx; i < postarr.length - 1; i++) postRight.push(postarr[i]);
  for (let i = inIdx + 1; i < postarr.length; i++) inRight.push(inarr[i]);

  if (postLeft.length !== 0) tree[node][0] = postLeft[postLeft.length - 1];
  else tree[node][0] = ".";
  if (postRight.length !== 0) tree[node][1] = postRight[postRight.length - 1];
  else tree[node][1] = ".";

  maketree(postLeft[postLeft.length - 1], postLeft, inLeft);
  maketree(postRight[postRight.length - 1], postRight, inRight);
}

function preorder(node) {
  if (node == ".") return;

  ans += node + " ";
  preorder(tree[node][0]);
  preorder(tree[node][1]);
}

maketree(postorderarr[n - 1], postorderarr, inorderarr);
preorder(postorderarr[n - 1]);
console.log(ans.substring(0, ans.length - 1));
