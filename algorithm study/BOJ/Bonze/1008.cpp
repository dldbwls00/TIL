#include <iostream>
using namespace std;

double a, b; //실수자료형, 기본 소숫점아래 6자

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> a >> b;
	cout << fixed; //소숫점 고정
	cout.precision(16); //소숫점 설정
	cout << a / b;
	return 0;
}
