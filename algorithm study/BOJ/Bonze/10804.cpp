#include <iostream>
#include <algorithm>
using namespace std;

int arr[20];

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	for (int i = 1; i <= 20; i++)	arr[i - 1] = i;

	for (int i = 0; i < 10; i++) {
		int x, y;
		cin >> x >> y;
		reverse(arr + x - 1, arr + y); //[fisrt, last)의 원소를 역순으로 뒤집음
	}

	for (int i = 0; i < 20; i++) cout << arr[i] << " ";
	return 0;
}
