#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define STACK_SIZE 100

char stack[STACK_SIZE];//연산자를 보관하는 스택 stack
int tokentop = -1;//stack의 인덱스
char out[STACK_SIZE]; //변환 과정을 담음
void infixToPostfix();
int precedence(char op);
void pushToken(char sym);
char popToken();
void printStack(char* stack, char* out); //변환 과정을 출력

typedef enum {
	open_b, close_b, plus, minus, times, divide, mod, eos, operand, blank
} priority; //0,1,2,3,4,5,6,7,8,9
int stackCalc[STACK_SIZE]; //계산가능한 postfix
int posCalc = 0; //문자열 현재 위치
char symCalc;
int symType;
int top = -1;
int calcPostfix();
void push(int item);
int pop();
char readItem();

int main() {
	infixToPostfix();
	printf("\n>>> Expression converted to postfix: %s\n\n", out);
	printf("Postfix calculation...\n\n");
	printf("result = %d\n", calcPostfix());

	getchar();
	return 0;
}

void infixToPostfix() {//infix -> postfix 변환
	char expr[50];//infix 입력받음
	char sym; //pop한 토큰을 임시로 담음
	char token;//expr을 하나씩 담음
	int pos = 0;//expr의 인덱스
	int cnt = 0;//out의 인덱스

	printf("Enter the expression: ");
	scanf("%s", expr);

	while ((token = expr[pos++]) != '\0') {//null이 아닐 때
		if (isalnum(token)) {//알파벳 또는 숫자인 경우
			if (pos > 1 && isalnum(expr[pos - 2])) {//2자리 이상의 숫자인 경우
				cnt--;
				out[cnt++] = token;
			}
			else out[cnt++] = token;
			out[cnt++] = ' ';
		}
		else if (token == '(')	pushToken(token);
		else if (token == ')') {
			while ((sym = popToken()) != '(') {
				out[cnt++] = sym;
				out[cnt++] = ' ';
			}
		}
		else { //'(', ')'가 아닌 연산자인 경우
			while (precedence(stack[tokentop]) >= precedence(token) && tokentop != -1) {
				//입력의 우선순위가 작거나 같은 경우 && not empty 
				sym = popToken();
				out[cnt++] = sym;
				out[cnt++] = ' ';
			}
			pushToken(token);
		}
		printStack(stack, out);
	}
	while (tokentop != -1) {//(문자열의 끝인 경우) 남아있는 원소 모두 출력
		//printf("%c ", popToken());
		out[cnt++] = popToken();
		out[cnt++] = ' ';
		printStack(stack, out);
		printf("\n");
	}
}
int precedence(char op) {//연산자 우선순위
	if (op == '(')	return 0;
	else if (op == '+' || op == '-')	return 1;
	else if (op == '*' || op == '/' || op == '%') return 2;
}
void pushToken(char sym) {//연산자를 stack에 보관
	if (tokentop < STACK_SIZE - 1)	stack[++tokentop] = sym;
	else printf("token stack full!\n");
}
char popToken() {//연산자를 stack에서 뽑음
	if (tokentop >= 0)	return stack[tokentop--];
	printf("token stack empty!\n");
	return ' ';
}
void printStack(char* stack, char* out) { //변환 과정을 출력
	printf("%-50s |stack| ", out);
	for (int i = 0; i <= tokentop; i++)	printf("%c ", stack[i]);
	printf("\n");
}
int calcPostfix() {
	char sym;
	int op1, op2;
	char h[5] = { '\0' };
	char* hh;
	int k = 0, num;

	sym = readItem(); //readItem()함수에서 symType 업데이트

	while (symType != eos) {
		if (symType == operand)	h[k++] = sym;
		else if (symType == blank && isalnum(out[posCalc - 2])) {
			hh = (char*)malloc(k);
			for (int i = 0; i < k; i++) hh[i] = h[i]; //자리수가 다른 숫자간의 연산을 위해
			num = atoi(hh); //atoi: 정수 변환
			push(num);
			for (int i = 0; i < strlen(h); i++)	h[i] = 0; //초기화
			k = 0;
			free(hh);
		}
		else if (symType == blank)	sym = readItem;
		else {
			op2 = pop();
			op1 = pop();
			switch (symType) {
			case plus: push(op1 + op2);		break;
			case minus: push(op1 - op2);	break;
			case times: push(op1 * op2);	break;
			case divide: push(op1 / op2);	break;
			case mod: push(op1 % op2);	break;
			}
		}
		sym = readItem();
	}
	return pop(); //최종 결과값 전달
}
char readItem() {
	char sym;

	sym = out[posCalc++]; // 현재 pos위치의 심볼을 저장한 후 한 칸 이동
	switch (sym) {
	case '(': symType = open_b;	break;
	case ')': symType = close_b;	break;
	case '+': symType = plus;		break;
	case '-': symType = minus;		break;
	case '*': symType = times;		break;
	case '/': symType = divide;	break;
	case '%': symType = mod;	break;
	case '\0': symType = eos;	break;
	case ' ': symType = blank; break;
	default: symType = operand;
	}
	return sym;
}
void push(int item) {
	if (top >= STACK_SIZE - 1) { //full 조건
		printf("stack full!\n");
		return;
	}
	stackCalc[++top] = item;
}
int pop() {
	if (top < 0) {
		printf("stack empty!\n"); //empty 조건
		return -999;
	}
	return stackCalc[top--];
}