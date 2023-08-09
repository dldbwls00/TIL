// boj 14681 사분면 고르기
//
#include <iostream>
using namespace std;

int x, y;  // −1000 ≤ x ≤ 1000; x ≠ 0, −1000 ≤ y ≤ 1000; y ≠ 0
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> x >> y;
    if (x > 0 && y > 0)
        cout << 1;
    else if (x < 0 && y > 0)
        cout << 2;
    else if (x < 0 && y < 0)
        cout << 3;
    else
        cout << 4;
        
    return 0;
}