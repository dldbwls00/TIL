#include <iostream>
#include <queue>
using namespace std;

int n, m;
int map[1001][1001];
int visited[1001][1001];
int cnt[1001][1001];
// int dx[4] = {0, 1, 0, -1};  // 북, 동, 남, 서 (시계 방향)
// int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, -1, 0, 1};  // 북, 서, 남, 동 (반시계방향)
int dy[4] = {1, 0, -1, 0};
int punch = 0;

void bfs(int x, int y);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf("%1d", &map[i][j]);
        }
    }
    bfs(1, 1);

    if (cnt[n][m] == 0)
        cout << -1;
    else
        cout << cnt[n][m];

    return 0;
}
void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    visited[x][y] = 1;
    cnt[x][y]++;
    while (!q.empty()) {
        int xx = q.front().first;
        int yy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = xx + dx[i];
            int ny = yy + dy[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && visited[nx][ny] == 0) {
                if (map[nx][ny] == 1 && punch == 1)
                    continue;
                else if (map[nx][ny] == 1 && punch == 0)
                    punch++;
                cnt[nx][ny] = cnt[xx][yy] + 1;
                visited[nx][ny] = 1;
                q.push(make_pair(nx, ny));
            }
        }
    }
}