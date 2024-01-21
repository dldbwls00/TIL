// boj 2167 2차원 배열의 합
// implementation
#include <iostream>
using namespace std;

int N, M;        // 배열의 크기 1 ≤ N, M ≤ 300
int K;           // 합을 구할 부분의 개수 1 ≤ K ≤ 10,000
int i, j, x, y;  // 네 개의 정수 1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int arr[301][301];

    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            int num;
            cin >> num;
            arr[i][j] = num;
        }
    }

    cin >> K;
    for (int a = 0; a < K; a++) {
        int sum = 0;
        cin >> i >> j >> x >> y;
        if (i == x & j == y) {
            sum = arr[i][j];
        } else {
            for (int b = i; b <= x; b++) {
                for (int c = j; c <= y; c++) sum += arr[b][c];
            }
        }
        cout << sum << '\n';
    }
    return 0;
}