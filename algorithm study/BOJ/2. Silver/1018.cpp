// boj 1018 체스판 다시 칠하기
// brute-force
#include <iostream>
using namespace std;

int N, M;
char board[51][51];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) cin >> board[i][j];
    }

    int ans = 2500;

    for (int i = 0; i <= N - 8; i++) {  // 전체 체스판 탐색
        for (int j = 0; j <= M - 8; j++) {
            // 좌상단이 B인 경우: 맞을 때 cnt1 증가, 틀릴 때 cnt2 증가
            // 좌상단이 W인 경우: 맞을 때 cnt2 증가, 틀릴 때 cnt1 증가
            int cnt1 = 0, cnt2 = 0;

            for (int a = i; a < i + 8; a++) {
                for (int b = j; b < j + 8; b++) {
                    // board[i][j]가 W인 경우 좌상단이 W
                    if (board[a][b] == 'B') {  // 한 칸 건너뛰며 반복되므로 행, 열의 합이 짝수/홀수인 경우로 나눔
                        if ((a + b) % 2 == 0)
                            cnt1++;
                        else
                            cnt2++;
                    } else {
                        if ((a + b) % 2 == 0)
                            cnt2++;
                        else
                            cnt1++;
                    }
                }
            }
            int temp = min(cnt1, cnt2);
            ans = min(ans, temp);
        }
    }
    cout << ans;
    return 0;
}