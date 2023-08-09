// boj 8393 합
//
#include <iostream>
using namespace std;

int n;  // 1 ≤ n ≤ 10,000
int sum = 0;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++) sum += i;
    cout << sum;

    return 0;
}