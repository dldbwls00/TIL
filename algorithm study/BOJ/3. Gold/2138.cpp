#include <iostream>
#include <string>
using namespace std;
// 첫 번째 전구 스위치를 누르는 경우, 안누르는 경우로 나눠서 풀기

int n, result;
string now, original, want;

void pushswitch(int index) {
    for (int i = index - 1; i <= index + 1; i++) {
        if (i < 0 || i >= n) continue;
        if (now[i] == '0')
            now[i] = '1';
        else
            now[i] = '0';
    }
}
int bulb(bool stat) {
    int cnt = 0;
    now = original;  // 초기화

    if (stat) {  // 첫 번째 전구 스위치를 누르는 경우
        pushswitch(0);
        cnt++;
    }

    for (int i = 1; i < n; i++) {
        if (now[i - 1] != want[i - 1]) {
            pushswitch(i);
            cnt++;
        }
    }

    if (now != want) cnt = 100001;
    return cnt;
}
int main() {
    cin >> n >> original >> want;
    now = original;

    result = min(bulb(true), bulb(false));
    if (result == 100001)
        cout << "-1";
    else
        cout << result;
    return 0;
}