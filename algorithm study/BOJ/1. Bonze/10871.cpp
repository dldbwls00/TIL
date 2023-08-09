// boj 10871 X보다 작은 수
//
#include <iostream>
using namespace std;

int N, X;  // 1 ≤ N, X ≤ 10,000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> X;
    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        if (num < X) cout << num << " ";
    }
    return 0;
}