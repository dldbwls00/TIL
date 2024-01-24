// boj 16507 어두운 건 무서워
// prefix sum
#include <iostream>
using namespace std;

int R, C, Q;  // 1 ≤ R, C ≤ 1000, 1 ≤ Q ≤ 10000
int arr[1001][1001];
int temp[1001][1001];  // 누적합

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C >> Q;
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            int K;  // 1 ≤ K ≤ 1,000
            cin >> K;
            arr[i][j] = K;
        }
    }

    for (int i = 1; i <= R; i++) temp[i][1] = arr[i][1];  // 행별 누적합
    for (int i = 1; i <= R; i++) {
        for (int j = 2; j <= C; j++) temp[i][j] = temp[i][j - 1] + arr[i][j];
    }

    for (int i = 0; i < Q; i++) {
        int sum = 0;
        int r1, c1, r2, c2;  // 1 ≤ r1 ≤ r2 ≤ R, 1 ≤ c1 ≤ c2 ≤ C
        cin >> r1 >> c1 >> r2 >> c2;

        if (r1 == r2 & c1 == c2)
            sum = arr[r1][c1];
        else {
            for (int a = r1; a <= r2; a++) {
                sum += temp[a][c2] - temp[a][c1 - 1];
            }
        }
        cout << sum / ((r2 - r1 + 1) * (c2 - c1 + 1)) << "\n";
    }
    return 0;
}