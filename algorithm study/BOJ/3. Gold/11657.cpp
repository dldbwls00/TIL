// boj 11657 타임머신
// bellman-ford
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>
using namespace std;

#define INF 2100000000
int N, M;                          // 도시의 개수, 버스 노선의 개수 (1 <= N <= 500, 1 <= M <= 6000)
int A, B, C;                       // A는 시작, B는 도착 도시, C는 이동 시간 (1 <= A, B <= N, -10,000 <= C <= 10,000)
long long dist[501];               // N과 M이 최댓값인 경우 int형의 범위를 넘어감
vector<pair<int, int>> edge[501];  // 인접리스트 -> 벡터배열 사용

void bellmanford() {
    fill(dist, dist + N + 1, INF);  // dist 배열을 INF로 초기화
    dist[1] = 0;
    bool cycle = false;

    for (int k = 1; k <= N; k++) {  // 벡터배열을 동일한 형태로 정의해 해결한 코드를 참고해 수정함
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < edge[i].size(); j++) {
                int next = edge[i][j].first;
                int cost = edge[i][j].second;

                if (dist[i] != INF && dist[next] > dist[i] + cost) {
                    dist[next] = dist[i] + cost;
                    if (k == N) cycle = true;  // 음의 사이클 확인
                }
            }
        }
    }

    if (cycle) {  // 음수 사이클이 있는 경우
        cout << "-1\n";
        return;
    }

    for (int i = 2; i <= N; i++) {
        if (dist[i] == INF)
            cout << "-1\n";
        else
            cout << dist[i] << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        cin >> A >> B >> C;
        edge[A].push_back(make_pair(B, C));
    }
    bellmanford();

    return 0;
}