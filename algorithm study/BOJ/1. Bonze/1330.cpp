// boj 1330 두 수 비교하기
//
#include <iostream>
using namespace std;

int A, B;  // -10,000 ≤ A, B ≤ 10,000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B;
    if (A > B)
        cout << ">";
    else if (A < B)
        cout << "<";
    else
        cout << "==";

    return 0;
}