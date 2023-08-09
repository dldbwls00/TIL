// boj 1008 A/B
//
#include <iostream>
using namespace std;

double A, B;  // 0 < A, B < 10
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> A >> B;

    // 실제 정답과 출력값의 절대오차 또는 상대오차가 10^(-9) 이하면 정답
    // 소숫점 아래 9자리까지는 값을 출력해줘야 오차가 허용범위 안에 들어옴
    // float는 소숫점 아래 6자리까지, double은 소숫점 아래 15자리까지 나오므로 double 사용
    cout.precision(10);  // 소숫점 아래 유효숫자 고정
    cout << A / B;

    return 0;
}