#include <iostream>
#include <queue>
using namespace std;

int n, k;
queue<int> q;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	for (int i = 1; i <= n; i++)	q.push(i);
	cout << "<";

	int temp = 1;
	while (q.size() > 1) {
		if (temp % k == 0) {
			cout << q.front() << ", ";
			q.pop();
		}
		else {
			q.push(q.front()); //맨 앞을 뒤로 넣기
			q.pop();
		}
		temp++;
	}
	cout << q.front() << ">";
	return 0;
}

// 마지막 출력 때 \b\b를 사용하면 맞왜틀? 매번 풀 때마다 같은 방식으로 틀린다...
