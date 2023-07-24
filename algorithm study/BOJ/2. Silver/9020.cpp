// boj 9020 골드바흐의 추측
// brute-force
#include <iostream>
using namespace std;

int T, n;  // n은 4~10000의 짝수

bool prime(int x) {  // 소수 판별
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return false;
    }
    return true;
}
void goldbach(int x) {
    int a = 0, b = 0;
    for (int i = 2; i < x / 2 + 1; i++) {
        if (prime(i) && prime(x - i)) {
            int temp = x;
            if (x - i - i < temp) {
                a = i;
                b = x - i;
            }
        }
    }
    cout << a << " " << b << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> n;
        goldbach(n);
    }
    return 0;
}