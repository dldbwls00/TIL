// boj 14929 귀찮아 (SIB)
// implementation
#include <iostream>
using namespace std;

int n;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    long long *arr = new long long[n];
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        arr[i] = num;
    }

    long long sum = 0;  // 누적합(prefix sum): a*b + a*c = a*(b+c)
    if (n == 1)
        sum = 0;
    else {
        long long *temp = new long long[n];  // 누적합
        temp[0] = arr[0];
        for (int i = 1; i < n; i++) temp[i] = temp[i - 1] + arr[i];
        for (int i = 0; i < n - 1; i++) sum += arr[i] * (temp[n - 1] - temp[i]);
    }
    cout << sum;
    return 0;
}