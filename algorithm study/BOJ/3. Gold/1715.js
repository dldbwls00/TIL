// boj 1715 카드 정렬하기
// greedy

const input = require("fs").readFileSync("./example.txt").toString().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = parseInt(input[0]);
if (n === 0) {
  console.log(0);
  return;
}

// 틀린 시도: 오름차순 정렬 후 작은 것부터 합치는 게 가장 적은 비교 횟수
// 반례: [10, 10, 10, 10, 10]의 경우 (10+10)+(10+10)+(10+20)+(20+30) = 120
// let arr = [];
// for (let i = 0; i < n; i++) arr.push(parseInt(input[i + 1]));
// arr.sort((a, b) => a - b);
// let sumarr = new Array(n - 1);
// sumarr[0] = arr[0];
// for (let i = 1; i < n; i++) sumarr[i] = sumarr[i - 1] + arr[i];
// let sum = 0;
// for (let i = 1; i < n; i++) sum += sumarr[i];
// console.log(sum);

// 메모리 초과: 가장 작은 수 두 개를 더한 다음 배열에 다시 담기를 반복
// 힙을 이용해 구현한다
// let arr = [];
// for (let i = 0; i < n; i++) arr.push(parseInt(input[i + 1]));
// let result = 0;
// while (arr.length > 1) {
//     arr.sort((a, b) => a - b);
//     let temp1 = arr.shift();
//     let temp2 = arr.shift();
//     let temp3 = temp1 + temp2;
//     arr.push(temp3);
//     result += temp3;
// }
// console.log(result);

// 힙 구현 참고: https://velog.io/@longroadhome/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-JS%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-HEAP
class MinHeap {
  constructor() {
    this.heap = [null];
  }
  size() {
    return this.heap.length - 1;
  }
  getMin() {
    return this.heap[1] ? this.heap[1] : null;
  }
  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
  heappush(value) {
    this.heap.push(value);
    let curIdx = this.heap.length - 1;
    let parIdx = (curIdx / 2) >> 0;

    while (curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]) {
      this.swap(parIdx, curIdx);
      curIdx = parIdx;
      parIdx = (curIdx / 2) >> 0;
    }
  }
  heappop() {
    const min = this.heap[1];
    if (this.heap.length <= 2) this.heap = [null];
    else this.heap[1] = this.heap.pop();

    let curIdx = 1;
    let leftIdx = curIdx * 2;
    let rightIdx = curIdx * 2 + 1;

    if (!this.heap[leftIdx]) return min;
    if (!this.heap[rightIdx]) {
      if (this.heap[leftIdx] < this.heap[curIdx]) {
        this.swap(leftIdx, curIdx);
      }
      return min;
    }

    while (this.heap[leftIdx] < this.heap[curIdx] || this.heap[rightIdx] < this.heap[curIdx]) {
      const minIdx = this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx;
      this.swap(minIdx, curIdx);
      curIdx = minIdx;
      leftIdx = curIdx * 2;
      rightIdx = curIdx * 2 + 1;
    }
    return min;
  }
}

let arr = new MinHeap();
for (let i = 0; i < n; i++) arr.heappush(parseInt(input[i + 1]));

let result = 0;
while (arr.size() > 1) {
  let temp = arr.heappop() + arr.heappop();
  arr.heappush(temp);
  result += temp;
}
console.log(result);
