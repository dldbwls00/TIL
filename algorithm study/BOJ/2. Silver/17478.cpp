// boj 17478 ����Լ��� ������?
// recursion
#include <iostream>
using namespace std;

int N;
void printbar(int num) {
    for (int i = 0; i < N - num; i++) cout << "____";
}
void recursion(int n) {
    printbar(n);
    cout << "\"����Լ��� ������?\"\n";

    if (n == 0) {
        printbar(n);
        cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
        printbar(n);
        cout << "��� �亯�Ͽ���.\n";
        return;
    }
    printbar(n);
    cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
    printbar(n);
    cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
    printbar(n);
    cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
    recursion(n - 1);
    printbar(n);
    cout << "��� �亯�Ͽ���.\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
    recursion(N);
    return 0;
}