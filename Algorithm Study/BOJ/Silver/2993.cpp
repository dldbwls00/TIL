#include <iostream>
#include <string>
#include <algorithm> //reverse
using namespace std;

string s;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> s;
	
	string result = "~"; //아스키 맨 끝
	for (int i = 0; i < s.size() - 2; i++) {
		for (int j = i + 1; j < s.size() - 1; j++) {
			string temp = s;
			reverse(temp.begin(), temp.begin() + i + 1);
			reverse(temp.begin() + i + 1, temp.begin() + j + 1);
			reverse(temp.begin() + j + 1, temp.end());
			result = min(result, temp);
		}
	}
	cout << result;
	return 0;
}
