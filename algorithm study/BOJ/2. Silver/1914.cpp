// boj 1914 하노이 탑
// recursion
#include <cmath>
#include <iostream>
using namespace std;

void hanoi(int n, int start, int via, int end) {
    if (n == 1) {
        cout << start << " " << end << "\n";
        return;
    }
    hanoi(n - 1, start, end, via);
    cout << start << " " << end << "\n";
    hanoi(n - 1, via, start, end);
    return;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int num = pow(2, n) - 1;
    if (n > 20) {
        cout << num;
        return 0;
    } else {
        cout << num << "\n";
        hanoi(n, 1, 2, 3);
    }
    return 0;
}