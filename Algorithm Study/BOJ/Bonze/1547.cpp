#include <iostream>
using namespace std;

int m;
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> m;
	int ball = 1;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		if (ball == x)	ball = y;
		else if (ball == y)	ball = x;
	}
	cout << ball;
	return 0;
}
