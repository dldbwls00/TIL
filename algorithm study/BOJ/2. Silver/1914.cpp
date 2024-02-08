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
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;  // 1 ≤ N ≤ 100
    cin >> n;
    string total = to_string(pow(2, n));
    int idx = total.find('.');
    total = total.substr(0, idx);
    total[total.length() - 1] -= 1;
    cout << total << "\n";
    if (n <= 20) hanoi(n, 1, 2, 3);

    return 0;
}