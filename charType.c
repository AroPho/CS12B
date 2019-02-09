#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

#define MAX_STRING_LENGTH 100

void extract_chars(char* s, char* a, char* d, char* p, char* w);

int main(int argc, char* argv[]){
    FILE* in; /* file handle for input */
    FILE* out; /* file handle for output */
    char* line;     // string holding input line
    char* alpha;    // string holding all alphabetical
    char* num;      // string holding all Numbers
    char* punc;     // string holding all Punctuation
    char* white;    // string holding all WhiteSpace
    /* check command line for correct number of arguments */
    if( argc != 3 ){
        printf("Usage: %s <input file> <output file>\n", argv[0]);
        exit(EXIT_FAILURE);
    }
 /* open input file for reading */
    in = fopen(argv[1], "r");
    if( in==NULL ){
        printf("Unable to read from file %s\n", argv[1]);
        exit(EXIT_FAILURE);
    }
 /* open output file for writing */
    out = fopen(argv[2], "w");
    if( out==NULL ){
        printf("Unable to write to file %s\n", argv[2]);
        exit(EXIT_FAILURE);
    }

    // allocate strings line and alpha_num on the heap
    line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    alpha = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    num = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    punc = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    white = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
    assert( line!=NULL && alpha!=NULL && num!=NULL && punc!=NULL && white!=NULL );

 /* read words from input file, print on separate lines to output file*/
    int count = 0;
    while( fscanf(in, " %s", line) != EOF ){
        extract_chars(line, alpha, num, punc, white)
        int a = alpha[0],n = num[0] ,p = punc[0],w = white[0];
        fprintf(out, "line %i contains:\n");
        fprintf(out, "%i alphabetic characters: %s\n",a , alpha);
        fprintf(out, "%i numeric characters: %s\n",n , num);
        fprintf(out, "%i punctuation characters: %s\n",p , punc);
        fprintf(out, "%i whitespace characters: %s\n",w , white);
    }

    free(line);
    free(alpha);
    free(num);
    free(punc);
    free(white);

 /* close input and output files */
    fclose(in);
    fclose(out);
    return(EXIT_SUCCESS);
}

void extract_chars(char* s, char* a, char* d, char*p, char* w){
    int x = 0, alph = 1, dig = 1, punc = 1, wh = 1;
    int ac = 0, dc = 0, pc = 0, wc = 0;
    while(s[x] != '\0' && i < MAX_STRING_LENGTH){
        if(s[x] >= 'a' && s[x]  <= 'z' || s[x] >= 'A' && s[x]  <= 'Z'){
            a[alph] = s[x];
            a[0] = ac++;
            a++;
        }
        if(s[x] >= '0' && s[x]  <= '9'){
            d[dig] = s[x];
            d[0] = dc++;
            dig++;
        }
        if(s[x] == ' '){
            w[wh] = s[x];
            w[0] = wc++;
            wh++;
        }
        else{
            p[punc] = s[x];
            p[0] = pc++;
            punc++;
        }
        x++;
    }
}
