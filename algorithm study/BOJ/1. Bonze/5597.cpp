// boj 5597 과제 안 내신 분..?
//
#include <iostream>
using namespace std;

int n;  // 1 ≤ n ≤ 30
int student[31];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 28; i++) {
        cin >> n;
        student[n] = 1;
    }

    int cnt = 0;
    for (int i = 1; i <= 30; i++) {
        if (student[i] == 0) {
            cnt++;
            if (cnt > 3) break;
            cout << i << "\n";
        }
    }

    return 0;
}