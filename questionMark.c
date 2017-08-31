#include <stdio.h>
#include <string.h>
char str[1000];
int main(int argc, char *argv[argc]) {
    if (argc == 1)
        printf("Please run with your name on the command line.\n");
    else {
        for (unsigned int i = 1; i < argc; ++i) {
            unsigned int j;
            for (j = 0; j < strlen(argv[i]); ++j) {
                char ch = argv[i][j];
                if (('A' <= ch) && (ch <= 'Z')) {
                    unsigned int o = ch - 'A';
                    str[j] = 'Z' - o;
                } else if (('a' <= ch) && (ch <= 'z')) {
                    unsigned int o = ch - 'a';
                    str[j] = 'z' - o;
                } else {
                    str[j] = ch;
                }
            }
            str[j] = 0;
            printf("%s ", str);
        }
        printf("\n");
    }
  return 0;
}
