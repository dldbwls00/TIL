#include <stdio.h>

int main(int argc, char *argv[]) {

	FILE *fp;
	int c;

	if (argc < 2)
		fp = stdin;
	else
		fp = fopen(argv[1], "r");

	if (fp == NULL) {
		fprintf(stderr, "파일 열기 오류 %s\n", argv[1]);
		exit(1);
	}

	c = fgetc(fp);
	while (c != EOF) {
		fputc(c, stdout);
		c = fgetc(fp);
	}
	
	fclose(fp);
	return 0;
}
