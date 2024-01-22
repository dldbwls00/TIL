// 참고 https://gundol97.tistory.com/89
// boj 10427 빚
// implementation
#include <algorithm>
#include <iostream>
using namespace std;

int N;
int arr[4001];
long long sum[4001];  // 누적합

long long calc(int j) {
    long long minimum = 999999999;
    for (int i = j; i <= N; i++) minimum = min(minimum, arr[i] * j - sum[i] + sum[i - j]);
    return minimum;
}
void solve() {
    fill_n(arr, 4001, 0);  // 초기화
    fill_n(sum, 4001, 0);
    long long ans = 0;

    cin >> N;
    for (int i = 1; i <= N; i++) cin >> arr[i];
    sort(arr, arr + N + 1);  // 최댓값 * M  - (M개의 합)이므로 M보다 작으면서 가장 큰 수들의 조합을 구함
    for (int i = 1; i <= N; i++) sum[i] = arr[i] + sum[i - 1];
    for (int i = 1; i <= N; i++) ans += calc(i);
    cout << ans << "\n";
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        solve();
    }
    return 0;
}
