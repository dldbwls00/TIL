// boj 2438 별 찍기 - 1
//
#include <iostream>
using namespace std;

int N;  // 1 ≤ N ≤ 100
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 0; j < i; j++) cout << "*";
        cout << "\n";
    }
    return 0;
}