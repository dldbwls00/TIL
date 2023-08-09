// boj 10952 A+B - 5
//
#include <iostream>
using namespace std;

int A, B;  // 0 < A, B < 10
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B;
    while (true) {
        if (A == 0 && B == 0) break;
        cout << A + B << "\n";
        cin >> A >> B;
    }

    return 0;
}