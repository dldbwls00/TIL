// boj 11022 A+B - 8
//
#include <iostream>
using namespace std;

int T;
int A, B;  // 0 < A, B < 10
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> T;
    for (int i = 1; i <= T; i++) {
        cin >> A >> B;
        cout << "Case #" << i << ": " << A << " + " << B << " = " << A + B << "\n";
    }

    return 0;
}