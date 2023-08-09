// boj 1001 A-B
//
#include <iostream>
using namespace std;

int A, B;  // 0 < A, B < 10
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B;
    cout << A - B;

    return 0;
}