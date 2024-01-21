// boj 17390 이건 꼭 풀어야 해!
// implementation
#include <algorithm>
#include <iostream>
using namespace std;

int N, Q;  // 1 ≤ N, Q ≤ 300,000

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> Q;
    int* arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
        int num;
        cin >> num;
        arr[i] = num;
    }
    sort(arr, arr + N + 1);  // 오름차순 정렬: (배열의 포인터, 배열의 포인터 + 배열의 크기)

    int* temp = new int[N + 1];  // 누적합
    temp[1] = arr[1];
    for (int i = 1; i <= N; i++) temp[i] = arr[i] + temp[i - 1];

    for (int i = 0; i < Q; i++) {
        int a, b;
        cin >> a >> b;
        if (a == b)
            cout << arr[a];
        else
            cout << temp[b] - temp[a - 1];
        cout << "\n";
    }
    return 0;
}