// boj 2753 윤년
//
#include <iostream>
using namespace std;

int year;  // 1~4000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> year;
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)  // 윤년
        cout << 1;
    else
        cout << 0;
    return 0;
}