// // boj 9663 N-Queen
// // backtracking
// #include <cmath>
// #include <iostream>
// using namespace std;
// #define MAX 15

// int N;  // 1~15
// int col[MAX];
// int result = 0;

// bool promising(int i) {
//     int k = 1;  // 인덱스

//     while (k < i) {
//         if (col[i] == col[k] || abs(col[i] - col[k]) == i - k)  // 같은 열, 행, 대각선
//             return false;
//         k++;
//     }
//     return true;
// }

// void nQueen(int i) {
//     if (promising(i)) {
//         if (i == N)  // 답을 찾은 경우
//             result++;
//         else {
//             for (int j = 0; j < N; j++) {
//                 col[i] = j;
//                 nQueen(i + 1);  // 자식 탐색
//             }
//         }
//     }
// }

// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
//     cout.tie(NULL);

//     cin >> N;
//     nQueen(0);
//     cout << result;

//     return 0;
// }