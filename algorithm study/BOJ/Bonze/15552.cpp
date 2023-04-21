#include <iostream>
using namespace std;

int t;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> t;
	for (int i = 0; i < t; i++) {
		int x, y;
		cin >> x >> y;
		cout << x + y;
	}
	return 0;
}
