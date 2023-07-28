// boj 11403 경로 찾기
// floyd-warshall
#include <iostream>
using namespace std;

#define MAX 101
int N;  // 정점의 개수, 1~100
int graph[MAX][MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) cin >> graph[i][j];
    }

    for (int k = 0; k < N; k++) {  // floyd-warshall
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) cout << graph[i][j] << " ";
        cout << "\n";
    }

    return 0;
}