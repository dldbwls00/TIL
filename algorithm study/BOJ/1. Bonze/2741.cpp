// boj 2741 N 찍기
//
#include <iostream>
using namespace std;

int N;  // 1~100,000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= N; i++) cout << i << "\n";

    return 0;
}