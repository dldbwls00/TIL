// boj 21758 꿀 따기
// prefix sum
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    int* arr = new int[t + 1]{0};
    for (int i = 1; i <= t; i++) cin >> arr[i];
    // for (int i = 0; i <= t; i++) cout << arr[i] << " ";

    int* prefixsum = new int[t + 1]{0};
    prefixsum[1] = arr[1];
    for (int i = 1; i <= t; i++) prefixsum[i] = prefixsum[i - 1] + arr[i];
    // for (int i = 0; i <= t; i++) cout << prefixsum[i] << " ";

    int maximum = -1;
    // 1.꿀통-벌-벌: 꿀은 1, 오른쪽 벌은 n -> 가운데 벌을 i로 돌림
    for (int i = 2; i < t; i++) {
        int honey = (prefixsum[t - 1] - arr[i]) + prefixsum[i - 1];
        maximum = max(honey, maximum);
    }

    // 2. 벌-꿀통-벌: 꿀을 i로 돌림
    for (int i = 2; i < t; i++) {
        int honey = (prefixsum[i] - arr[1]) + (prefixsum[t - 1] - prefixsum[i - 1]);
        maximum = max(honey, maximum);
    }

    // 3. 벌-벌-꿀통: 왼쪽 벌은 1, 꿀은 n -> 가운데 벌을 i로 돌림
    for (int i = 2; i < t; i++) {
        int honey = (prefixsum[t] - arr[1] - arr[i]) + (prefixsum[t] - prefixsum[i]);
        maximum = max(honey, maximum);
    }

    cout << maximum;
    return 0;
}
