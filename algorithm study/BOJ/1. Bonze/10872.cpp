// boj 10872 팩토리얼
//
#include <iostream>
using namespace std;

int N;  // 0 ≤ N ≤ 12

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    int result = 1;
    for (int i = 2; i <= N; i++) result *= i;
    cout << result;

    return 0;
}