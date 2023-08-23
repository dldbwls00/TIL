// boj 10807 개수 세기
//
#include <iostream>
using namespace std;

int N;  // 1 ≤ N ≤ 100
int num[101];
int v;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++) cin >> num[i];
    cin >> v;

    int cnt = 0;
    for (int i = 0; i < N; i++) {
        if (num[i] == v) cnt++;
    }
    cout << cnt;
    return 0;
}