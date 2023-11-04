#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define STACK_SIZE 100

char stack[STACK_SIZE];//�����ڸ� �����ϴ� ���� stack
int tokentop = -1;//stack�� �ε���
char out[STACK_SIZE]; //��ȯ ������ ����
void infixToPostfix();
int precedence(char op);
void pushToken(char sym);
char popToken();
void printStack(char* stack, char* out); //��ȯ ������ ���

typedef enum {
	open_b, close_b, plus, minus, times, divide, mod, eos, operand, blank
} priority; //0,1,2,3,4,5,6,7,8,9
int stackCalc[STACK_SIZE]; //��갡���� postfix
int posCalc = 0; //���ڿ� ���� ��ġ
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

void infixToPostfix() {//infix -> postfix ��ȯ
	char expr[50];//infix �Է¹���
	char sym; //pop�� ��ū�� �ӽ÷� ����
	char token;//expr�� �ϳ��� ����
	int pos = 0;//expr�� �ε���
	int cnt = 0;//out�� �ε���

	printf("Enter the expression: ");
	scanf("%s", expr);

	while ((token = expr[pos++]) != '\0') {//null�� �ƴ� ��
		if (isalnum(token)) {//���ĺ� �Ǵ� ������ ���
			if (pos > 1 && isalnum(expr[pos - 2])) {//2�ڸ� �̻��� ������ ���
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
		else { //'(', ')'�� �ƴ� �������� ���
			while (precedence(stack[tokentop]) >= precedence(token) && tokentop != -1) {
				//�Է��� �켱������ �۰ų� ���� ��� && not empty 
				sym = popToken();
				out[cnt++] = sym;
				out[cnt++] = ' ';
			}
			pushToken(token);
		}
		printStack(stack, out);
	}
	while (tokentop != -1) {//(���ڿ��� ���� ���) �����ִ� ���� ��� ���
		//printf("%c ", popToken());
		out[cnt++] = popToken();
		out[cnt++] = ' ';
		printStack(stack, out);
		printf("\n");
	}
}
int precedence(char op) {//������ �켱����
	if (op == '(')	return 0;
	else if (op == '+' || op == '-')	return 1;
	else if (op == '*' || op == '/' || op == '%') return 2;
}
void pushToken(char sym) {//�����ڸ� stack�� ����
	if (tokentop < STACK_SIZE - 1)	stack[++tokentop] = sym;
	else printf("token stack full!\n");
}
char popToken() {//�����ڸ� stack���� ����
	if (tokentop >= 0)	return stack[tokentop--];
	printf("token stack empty!\n");
	return ' ';
}
void printStack(char* stack, char* out) { //��ȯ ������ ���
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

	sym = readItem(); //readItem()�Լ����� symType ������Ʈ

	while (symType != eos) {
		if (symType == operand)	h[k++] = sym;
		else if (symType == blank && isalnum(out[posCalc - 2])) {
			hh = (char*)malloc(k);
			for (int i = 0; i < k; i++) hh[i] = h[i]; //�ڸ����� �ٸ� ���ڰ��� ������ ����
			num = atoi(hh); //atoi: ���� ��ȯ
			push(num);
			for (int i = 0; i < strlen(h); i++)	h[i] = 0; //�ʱ�ȭ
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
	return pop(); //���� ����� ����
}
char readItem() {
	char sym;

	sym = out[posCalc++]; // ���� pos��ġ�� �ɺ��� ������ �� �� ĭ �̵�
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
	if (top >= STACK_SIZE - 1) { //full ����
		printf("stack full!\n");
		return;
	}
	stackCalc[++top] = item;
}
int pop() {
	if (top < 0) {
		printf("stack empty!\n"); //empty ����
		return -999;
	}
	return stackCalc[top--];
}