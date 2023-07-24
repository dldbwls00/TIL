// boj 10870 피보나치 수 5
// recursion
#include <iostream>
using namespace std;

int N;  // 0~20

int fibo(int x) {
    if (x < 2) return x;
    return fibo(x - 2) + fibo(x - 1);
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    cout << fibo(N);

    return 0;
}