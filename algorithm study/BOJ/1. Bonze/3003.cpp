// boj 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
//
#include <iostream>
using namespace std;

int king, queen, rook, bishop, knight, pawn;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> king >> queen >> rook >> bishop >> knight >> pawn;
    cout << 1 - king << " " << 1 - queen << " " << 2 - rook << " " << 2 - bishop << " " << 2 - knight << " " << 8 - pawn;
    
    return 0;
}