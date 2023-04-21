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

/*
	n 3
m 2
arr 	0 0 0 0 0 0 0 0 0 
check	0 0 0 0 0 0 0 0 0

sol(0) //0 != 2
i 1
arr 	1 0 0 0 0 0 0 0 0 
check	0 1 0 0 0 0 0 0 0
	sol(1) //1 != 2
	i 1 //continue
	i 2
	arr 	1 2 0 0 0 0 0 0 0 
	check	0 1 1 0 0 0 0 0 0
		sol(2) //2 == 2
		//출력 1 2
	arr 	1 2 0 0 0 0 0 0 0 
	check	0 1 0 0 0 0 0 0 0
	i 3
	arr 	1 3 0 0 0 0 0 0 0 
	check	0 1 0 1 0 0 0 0 0
		sol(2) //2 == 2
		//출력 1 3
	arr 	1 3 0 0 0 0 0 0 0 
	check	0 1 0 0 0 0 0 0 0

i 2
arr 	2 2 0 0 0 0 0 0 0 
check	0 1 1 0 0 0 0 0 0
	sol(1) //1 != 2
	i 1 //continue
	i 2 //continue
	i 3
	arr 	2 3 0 0 0 0 0 0 0 
	check	0 1 1 1 0 0 0 0 0
		sol(2) //2 == 2
		//출력 2 3
	arr 	2 3 0 0 0 0 0 0 0 
	check	0 1 1 0 0 0 0 0 0

i 3
arr 	3 3 0 0 0 0 0 0 0 
check	0 1 1 1 0 0 0 0 0
	sol(1) //1 != 2
	i 1 //continue
	i 2 //continue
	i 3 //continue

~~~sol(0) 종료
~~~main() 종료
*/
