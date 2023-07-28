// boj 9663 N-Queen
// backtracking
#include <cmath>
#include <iostream>
using namespace std;
#define MAX 15

int N;  // 1~15
int col[MAX];
int result = 0;

bool promising(int level) {
    int i = 0;
    while (i < level) {
        if (col[level] == col[i] || abs(col[level] - col[i]) == level - i)  // 같은 열, 행, 대각선
            return false;
        i++;
    }
    return true;
}

void nQueen(int i) {
    // if (promising(i)) {
    if (i == N)  // 답을 찾은 경우
        result++;
    else {
        for (int j = 0; j < N; j++) {
            col[i] = j;
            if (promising(i)) nQueen(i + 1);  // 자식 탐색
        }
    }
    // }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    nQueen(0);
    cout << result;

    return 0;
}