// boj 10869 사칙연산
//
#include <iostream>
using namespace std;

int A, B;  // 1 ≤ A, B ≤ 10,000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B;

    cout << A + B << "\n";
    cout << A - B << "\n";
    cout << A * B << "\n";
    cout << A / B << "\n";
    cout << A % B;

    return 0;
}