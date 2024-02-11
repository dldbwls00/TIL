#include <algorithm>
#include <iostream>
using namespace std;

int n;
char arr[26][3];
char ans[26][3];
void preorder(char node);
void inorder(char node);
void postorder(char node);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    // for (int i = 0; i < n; i++) cout << arr[i][0] << " " << arr[i][1] << " " << arr[i][2] << "\n";
    preorder('A');
    for (int i = 0; i < n; i++) cout << arr[1][i];
    cout << "\n";
    inorder('A');
    postorder('A');
}

void preorder(char node) {
    if (node == '.') return;
    int cnt = 0;
    ans[0][cnt] = node;
    cnt++;

    // preorder(arr[find(arr, arr + n, node)][1]);
    preorder(arr[node][2]);
};
void inorder(char node){

};
void postorder(char node){};