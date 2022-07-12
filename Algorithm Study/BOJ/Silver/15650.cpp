#include <iostream>
using namespace std;

int n, m, arr[9], check[9];

int wrong() { //15649번 문제에서 새롭게 추가한 함수
	for (int i = 0; i < m-1; i++)	if (arr[i] > arr[i + 1])	return 1;
	return 0;
}

void sol(int x) {
	if (x == m) {
		if (wrong())	return;
		for (int i = 0; i < m; i++)	cout << arr[i] << " ";
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) {//백트래킹
		if (check[i])	continue;

		check[i] = 1;
		arr[x] = i;
		
		sol(x + 1);
		check[i] = 0;
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	sol(0);

	return 0;
}
