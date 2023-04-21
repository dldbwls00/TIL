#include <iostream>
#include <vector>
using namespace std;

int n;
vector <pair<int, int>> v;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(make_pair(i + 1, num)); //인덱스, 값
	}

	int now = 0, next;
	while (!v.empty()) {
		next = v[now].second;
		if (next > 0)	next--;

		cout << v[now].first;

		v.erase(v.begin() + now);
		now += next;
		n--;
		if (n <= 0)	break;
		now = (now >= 0 ? now : n + now % n); //음수모듈러
		now %= n;
		cout << " ";
	}
	return 0;
}
