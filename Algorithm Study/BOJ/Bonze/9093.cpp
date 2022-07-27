#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int t;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> t;
	cin.ignore(); //getline을 사용하기 위해 입력 버퍼를 지워줘야함

	for (int i = 0; i < t; i++) {
		string s, temp;
		getline(cin, s); //공백포함 문장을 입력받기 위함
		s += ' '; //마지막 단어도 reverse하기 위함

		for (int j = 0; j < s.length(); j++) {
			if (s[j] != ' ')	temp += s[j];
			else {
				reverse(temp.begin(), temp.end());
				cout << temp << ' ';
				temp.clear();
			}
		}
	}
	return 0;
}
