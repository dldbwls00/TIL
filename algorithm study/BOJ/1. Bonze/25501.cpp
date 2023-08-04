// boj 25501 재귀의 귀재
// recursion
#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;

int cnt = 0;

int recursion(const char* s, int l, int r) {
    cnt++;
    if (l >= r)
        return 1;
    else if (s[l] != s[r])
        return 0;
    else
        return recursion(s, l + 1, r - 1);
}
int isPallindrome(const char* s) {
    cout << recursion(s, 0, strlen(s) - 1) << " ";
    int temp = cnt;
    cnt = 0;
    return temp;
}
int main() {
    // ios::sync_with_stdio(false);
    // cin.tie(NULL);
    // cout.tie(NULL);
    int T = 0;
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        char S[1000];
        scanf("%s", S);
        printf("%d\n", isPallindrome(S));
    }
    return 0;
}