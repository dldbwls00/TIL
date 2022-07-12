#include <iostream>
using namespace std;

int n, m, arr[9], check[9];

void sol(int x) {
	if (x == m) {
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
