// boj 11660 구간 합 구하기 5
// prefix sum
#include <iostream>
using namespace std;

long long N, M;  // 1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000
int arr[1025][1025];
long long temp[1025][1025];  // 누적합

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            int num;
            cin >> num;
            arr[i][j] = num;
        }
    }

    for (int i = 1; i <= N; i++) temp[i][1] = arr[i][1];  // 행별로 누적합
    for (int i = 1; i <= N; i++) {
        for (int j = 2; j <= N; j++) {
            temp[i][j] = temp[i][j - 1] + arr[i][j];
        }
    }

    for (int i = 0; i < M; i++) {
        long long sum = 0;
        int x1, y1, x2, y2;  // x1 ≤ x2, y1 ≤ y2
        cin >> x1 >> y1 >> x2 >> y2;
        if (x1 == x2 & y1 == y2)
            sum = arr[x1][y1];
        else {
            for (int a = x1; a <= x2; a++) {
                sum += temp[a][y2] - temp[a][y1 - 1];
            }
        }
        cout << sum << "\n";
    }

    return 0;
}