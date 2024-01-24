// https://kau-algorithm.tistory.com/608 이걸 어떻게 생각해냄...
// boj 19951 태상이의 훈련소 생활
// prefix sum
#include <iostream>
using namespace std;

int N, M;  // 1 ≤ N, M ≤ 100,000
long long arr[100001];
long long temp[100001];  // 누적합

// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
//     cout.tie(NULL);

//     cin >> N >> M;
//     for (int i = 1; i <= N; i++) cin >> arr[i];

//     for (int i = 0; i < M; i++) {
//         long long a, b, k;  // 1 ≤ a ≤ b ≤ N, |k| ≤ 100
//         cin >> a >> b >> k;
//         for (long long j = a; j <= b; j++) temp[j] += k;
//     }
//     for (int i = 1; i <= N; i++) cout << arr[i] + temp[i] << " ";

//     return 0;
// }

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 1; i <= N; i++) cin >> arr[i];

    for (int i = 0; i < M; i++) {
        long long a, b, k;  // 1 ≤ a ≤ b ≤ N, |k| ≤ 100
        cin >> a >> b >> k;
        temp[a - 1] += k;
        temp[b] -= k;
    }

    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += temp[i];     // 명령의 누적합
        arr[i + 1] += sum;  // 누적합을 원래 배열에 더함
        cout << arr[i + 1] << " ";
    }
    return 0;
}
