//
// Created by aaron on 2/21/2019.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(int argc, char* argv[]) {
    int a = 10;
    int *b = &a;
    *b = *b + 10;
    printf(strcmp("one", "two"));
}