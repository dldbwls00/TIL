// boj 11660 구간 합 구하기 5
// implementation
#include <iostream>
using namespace std;

long long N, M;  // 1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000
int arr[1024][1024];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int num;
            cin >> num;
            arr[i][j] = num;
        }
    }

    for (int i = 0; i < M; i++) {
        int a, b, x, y;
        cin >> a >> b >> x >> y;
    }
    return 0;
}