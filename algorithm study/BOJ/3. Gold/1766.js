// boj 1766 문제집
// union find, topological sorting
// 위상정렬 개념: https://velog.io/@kimdukbae/%EC%9C%84%EC%83%81-%EC%A0%95%EB%A0%AC-Topological-Sorting
// 우선순위큐 구현: min heap https://nyang-in.tistory.com/153

const input = require("fs").readFileSync("./example.txt").toString().trimEnd().split("\n");
// const input = require("fs").readFileSync("/dev/stdin").toString().trimEnd() .split("\n");

const [n, m] = input[0].split(" ").map(Number);
let graph = Array.from(Array(n + 1), () => []);
let indegree = new Array(n + 1).fill(0); // 진입차수
for (let i = 0; i < m; i++) {
  const [a, b] = input[i + 1].split(" ").map(Number);
  graph[a].push(b);
  indegree[b]++;
}
let result = "";

// 큐를 정렬해서 사용하는 방법 - 메모리 초과
// //1. 진입 차수가 0인 모든 노드를 큐에 삽입
// let queue = [];
// for (let i = 1; i <= n; i++) if (indegree[i] === 0) queue.push(i);

// //2. 큐의 노드를 하나씩 꺼내며 그 노드와 연결돼있는 간선 제거
// while (queue.length !== 0) {
//   let node = queue.shift();
//   let linked = graph[node];
//   result += node + " ";
//   for (let i = 0; i < linked.length; i++) {
//     indegree[linked[i]]--;
//     if (indegree[linked[i]] == 0 && !queue.includes(linked[i])) queue.push(linked[i]);
//     queue.sort((a, b) => a - b);
//   }
// }
// console.log(result);

class Heap {
  constructor() {
    // index의 시작은 0으로 계산의 편의성을 위해 첫 번째를 비워둔다. (1번이 1번 index)
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

  push(value) {
    this.heap.push(value);
    let curIdx = this.heap.length - 1;
    let parIdx = (curIdx / 2) >> 0;

    // 부모가 노드가 제일 작아야 하므로, 부모노드가 현재노드보다 큰 지  반복하여 체크한다.
    while (curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]) {
      // 구조분해 할당을 이용해 부모와 자식을 swap 한다.
      this.swap(parIdx, curIdx);
      curIdx = parIdx;
      parIdx = (curIdx / 2) >> 0;
    }
  }

  pop() {
    // 배열 첫 원소를 비워두므로 root는 heap[1]에 항상 위치한다.
    const min = this.heap[1];

    /*  
            배열 마지막 원소를 root 위치에 배치 과정.
            if-else로 분기되는 이유는 추후 heap이 비었는지 아닌지 확인하기 위해 
            size 체크 함수를 만들때 -1을 통해 0을 만들어주기 때문.
        */
    if (this.heap.length <= 2) this.heap = [null];
    else this.heap[1] = this.heap.pop();

    let curIdx = 1;
    let leftIdx = curIdx * 2;
    let rightIdx = curIdx * 2 + 1;

    if (!this.heap[leftIdx]) return min;
    // 왼쪽 자식이 없다는 것은 오른쪽 자식도 없는, 즉 루트만 있는 상태이므로 바로 반환!
    if (!this.heap[rightIdx]) {
      if (this.heap[leftIdx] < this.heap[curIdx]) {
        // 오른쪽 자식이 없다면 왼쪽 자식하나만 있다는 것을 의미한다.
        this.swap(leftIdx, curIdx);
      }
      return min;
    }

    // 위에 조건에 걸리지 않는 경우 왼쪽과 오른쪽 자식이 모두 있는 경우이다.
    // 따라서 현재 노드가 왼쪽 또는 오른쪽 보다 큰 지 작은지를 검사하며 반복한다.
    while (this.heap[leftIdx] < this.heap[curIdx] || this.heap[rightIdx] < this.heap[curIdx]) {
      // 왼쪽과 오른쪽 자식 중에 더 작은 값과 현재 노드를 교체하면 된다.
      const minIdx = this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx;
      this.swap(minIdx, curIdx);
      curIdx = minIdx;
      leftIdx = curIdx * 2;
      rightIdx = curIdx * 2 + 1;
    }

    return min;
  }
}
//1. 진입 차수가 0인 모든 노드를 큐에 삽입
let pq = new Heap();
for (let i = 1; i <= n; i++) {
  if (indegree[i] === 0) pq.push(i);
}
// console.log(pq.heap);

// console.log(indegree);
// console.log(graph);
//2. 큐의 노드를 하나씩 꺼내며 그 노드와 연결돼있는 간선 제거
while (pq.size() !== 0) {
  let node = pq.pop();
  //   console.log(pq.heap);

  let linked = graph[node];
  //   console.log(linked);
  result += node + " ";
  if (linked.length === 0) continue;
  for (let i = 0; i < linked.length; i++) {
    indegree[linked[i]]--;
    if (indegree[linked[i]] == 0) pq.push(linked[i]);
    // console.log(pq.heap);
    // console.log();
  }
}
console.log(result);
