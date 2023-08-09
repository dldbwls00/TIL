// boj 2739 구구단
//
#include <iostream>
using namespace std;

int N;  // 1 ≤ N ≤ 100
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= 9; i++) cout << N << " * " << i << " = " << N * i << "\n";

    return 0;
}