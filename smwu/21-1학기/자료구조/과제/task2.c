#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h> //srand 시드값으로 현재시간 사용
#define NUM_SHAPE 2; // 2 or 4 (2 is recommended >> 26 cards)

typedef struct node_type* node_ptr; // card tree: doubly linked list
struct node_type {
	int num; // A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
	int shape; // 0, 1, 2, 3 = {space, heart, clover, diamond} = 2 or 4 sets
	int show; // 0 = hide, 1 = show
	node_ptr llink, rlink;
};
typedef struct stack* stack_ptr;// hand card: linked stack
struct stack {
	int num;
	int shape;
	int show;
	stack_ptr link;
};
int mark[4][13]; // randomly pick cards
int sh, no; //shape, number
int sh1, sh2;
int n = NUM_SHAPE;
int enternum;

void init_card(); // 내가 가지고 있는 카드
void reset_board(); // 게임판
void show_board(); // 게임판 출력
int pop_handcard(); // -1 입력하는 경우
int pickShape();
int pickNum(int sh);

void main() {

	init_card();
	reset_board();

	while (1) {
		show_board();
		if (enternum == -1) { // no match
			pop_handcard();
			if (1/*no more card to play(empty stack)*/) {
				printf("\n You Lose.\n");
				break;
			}
		}
		if (1/*all cards removed*/) {
			printf("\n You Win. \n");
			break;
		}
	}
}

void reset_board() {// 게임판
	node_ptr list, n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
	int num;

	// 게임판 연결
	n0 = (node_ptr)malloc(sizeof(struct node_type));
	n1 = (node_ptr)malloc(sizeof(struct node_type));
	n2 = (node_ptr)malloc(sizeof(struct node_type));
	n3 = (node_ptr)malloc(sizeof(struct node_type));
	n4 = (node_ptr)malloc(sizeof(struct node_type));
	n5 = (node_ptr)malloc(sizeof(struct node_type));
	n6 = (node_ptr)malloc(sizeof(struct node_type));
	n7 = (node_ptr)malloc(sizeof(struct node_type));
	n8 = (node_ptr)malloc(sizeof(struct node_type));
	n9 = (node_ptr)malloc(sizeof(struct node_type));
	n0->show = 0;
	list = n0;
	n0->llink = n1;
	n0->rlink = n2;
	n1->show = 0;
	n1->llink = n3;
	n1->rlink = n4;
	n2->show = 0;
	n2->llink = n4;
	n2->rlink = n5;
	n3->show = 0;
	n3->llink = n6;
	n3->rlink = n7;
	n4->show = 0;
	n4->llink = n7;
	n4->rlink = n8;
	n5->show = 0;
	n5->llink = n8;
	n5->rlink = n9;
	n6->show = 1;
	n6->llink = NULL;
	n6->rlink = NULL;
	n7->show = 1;
	n7->llink = NULL;
	n7->rlink = NULL;
	n8->show = 1;
	n8->llink = NULL;
	n8->rlink = NULL;
	n9->show = 1;
	n9->llink = NULL;
	n9->rlink = NULL;

	// 게임판에 카드 할당

}
void init_card() {// 내가 가지고 있는 카드
	stack_ptr m1, m2, m3, m4, m5, m6, m7, m8, m9, m10;

	m1 = (stack_ptr)malloc(sizeof(struct stack));
	//m1->
}
void show_board() {// 게임판 출력
	int cardnum = 13 * NUM_SHAPE - 10;
	char cardshape;

	printf("    0           \n\n");
	printf("   1 2         \n\n");
	printf("  3 4 5       \n\n");
	printf(" 6 7 8 9     \n\n\n");
	printf("You have (%d) cards.\n", cardnum);
	printf("================================\n");
	//printf(" ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n\n");
	printf("Enter a number[0..9] to remove (-1 = new card) : ");
	//scanf("%d", enternum);
}

int pop_handcard() {// -1 입력하는 경우
	int newsh, newno;

	newsh = pickShape();
	newno = pickNum(sh);
}
int pickShape() {//picking shape: 선택된 모양은 mark[][0]값이 2
	srand(time(NULL));
	while (mark[sh][0] != 2)	sh = rand() % 4;
	mark[sh][0] = 2;
	return sh;
}
int pickNum(int sh) {//picking shape: 선택된 숫자는 mark[][]값이 2
	srand(time(NULL));
	while (mark[sh][no] != 2)	no = rand() % 13;
	mark[sh][no] = 2;
	return no;
}