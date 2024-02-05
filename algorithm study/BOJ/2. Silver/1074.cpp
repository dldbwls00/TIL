// boj 1074 Z
// recursion
#include <iostream>
using namespace std;

int n, r, c;
int ans;

void z(int y, int x, int size);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> r >> c;
    z(0, 0, (1 << n));  // 2^2
    return 0;
}
void z(int y, int x, int size) {
    if (y == r && x == c) {
        cout << ans << "\n";
        return;
    }

    if (r < y + size && r >= y && c < x + size && c >= x) {  //(r, c)가 현재 사분면에 존재하는 경우
        z(y, x, size / 2);                                   // 1
        z(y, x + size / 2, size / 2);                        // 2
        z(y + size / 2, x, size / 2);                        // 3
        z(y + size / 2, x + size / 2, size / 2);             // 4
    } else
        ans += size * size;
}