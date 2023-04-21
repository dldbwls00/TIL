#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v;
int n;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}
	sort(v.begin(), v.end());
	
	for (int i = 0; i < v.size(); i++) cout << v[i] << "\n";
	return 0;
}
