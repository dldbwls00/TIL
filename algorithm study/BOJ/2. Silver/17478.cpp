// boj 17478 ����Լ��� ������?
// recursion
#include <iostream>
#include <string>
using namespace std;

int N;  // 1~50
void bar(int n) {
    for (int i = 0; i < N - n; i++) cout << "____";
}
void recursion(int n) {
    bar(n);
    cout << "\"����Լ��� ������?\"\n";

    if (n == 0) {
        bar(n);
        cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
        bar(n);
        cout << "��� �亯�Ͽ���.\n";
        return;
    }
    bar(n);
    cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
    bar(n);
    cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
    bar(n);
    cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
    recursion(n - 1);
    // bar(n);
    // cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
    bar(n);
    cout << "��� �亯�Ͽ���.\n";
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
    recursion(N);
    return 0;
}