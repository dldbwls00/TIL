// boj 18108 1998년생인 내가 태국에서는 2541년생?!
//
#include <iostream>
using namespace std;

int y;  // 1000 ≤ y ≤ 3000

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> y;
    cout << y - 543;
    return 0;
}