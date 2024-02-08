// boj 2747 피보나치 수
// recursion
#include <iostream>
using namespace std;
int arr[46];
int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    for (int i = 0; i <= n; i++) {
        if (i < 2)
            arr[i] = i;
        else
            arr[i] = arr[i - 1] + arr[i - 2];
    }
    cout << arr[n];
    return 0;
}