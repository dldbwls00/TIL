// boj 17478 재귀함수가 뭔가요?
// recursion
#include <iostream>
#include <string>
using namespace std;

int N;  // 1~50

void bar(int x) {
    for (int i = 0; i < x; i++) cout << "____";
}
void recursion() {
    for (int i = 1; i <= N; i++) {
        bar(i);
        cout << "재귀함수가 뭔가요?\n";
        bar(i);
        cout << "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        bar(i);
        cout << "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n ";
        bar(i);
        cout<<"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    cout << "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";

    return 0;
}