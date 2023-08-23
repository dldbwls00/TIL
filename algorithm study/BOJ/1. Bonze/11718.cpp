// boj 11718 그대로 출력하기
//
#include <iostream>
#include <string>
using namespace std;

string s;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (getline(cin, s)) {  // 공백 포함 한 줄 입력 받기: getline
        cout << s << "\n";
    }
    return 0;
}