// boj 10430 나머지
//
#include <iostream>
using namespace std;

int A, B, C;  // 2 ≤ A, B, C ≤ 10000
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B >> C;
    cout << (A + B) % C << "\n";
    cout << ((A % C) + (B % C)) % C << "\n";
    cout << (A * B) % C << "\n";
    cout << ((A % C) * (B % C)) % C;
    
    return 0;
}