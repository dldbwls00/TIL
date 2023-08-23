// boj 10951 A+B - 4
//
#include <iostream>
using namespace std;

int A, B;  // 0 < A, B < 10
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 종료 조건이 없다?!
    // 참고 https://st-lab.tistory.com/257
    while (cin >> A >> B) {
        cout << A + B << "\n";
    };
    return 0;
}