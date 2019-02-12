
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

// function prototype
void extract_alpha_num(char* s, char* a);
void extract_chars(char* s, char* a, char* d, char*p, char* w);

// function main which takes command line arguments
int main(int argc, char* argv[]){
   FILE* in;        // handle for input file
   FILE* out;       // handle for output file
   char* line;      // string holding input line
   char* alphabet;  // string holding all alphabetical chars
   char* number;
   char* punctuation;
   char* white;
   // check command line for correct number of arguments
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and alpha_num on the heap
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alphabet = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   number = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   punctuation = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   white = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && alphabet!=NULL && number!=NULL && punctuation!=NULL && white!=NULL);
   int count = 1;
   // read each line in input file, extract alpha-numeric characters
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_chars(line, alphabet, number, punctuation, white);
      int a = alphabet[0], n = number[0], p = punctuation[0], w = white[0];
      fprintf(out, "line %i contains:\n", count);
      fprintf(out, "%i alphabetic characters: %s\n",a , alphabet);
      fprintf(out, "%i numeric characters: %s\n",n , number);
      fprintf(out, "%i punctuation characters: %s\n",p , punctuation);
      fprintf(out, "%i whitespace characters: %s\n\n",w , white);
      count++;
   }

   // free heap memory
   free(line);
   free(alphabet);
   free(number);
   free(punctuation);
   free(white);

   // close input and output files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition
void extract_alpha_num(char* s, char* a){
   int i=0, j=0;
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( isalnum( (int) s[i]) ) a[j++] = s[i];
      i++;
   }
   a[j] = '\0';
}

void extract_chars(char* s, char* a, char* d, char*p, char* w){
    int x = 0, alph = 1, dig = 1, punc = 1, wh = 1;
    int ac = 0, dc = 0, pc = 0, wc = 0;
    while(s[x] != '\0' && x < MAX_STRING_LENGTH){
        if((s[x] >= 'a' && s[x]  <= 'z') || (s[x] >= 'A' && s[x]  <= 'Z')){
            a[alph] = s[x];
            a[0] = ac++;
            alph++;
            x++;
        }
        if(s[x] >= '0' && s[x]  <= '9'){
            d[dig] = s[x];
            d[0] = dc++;
            dig++;
            x++;
        }
        if(s[x] == ' '){
            w[wh] = s[x];
            w[0] = wc++;
            wh++;
            x++;
        }
        if((s[x] >= '!' && s[x]  <= '/') || (s[x] >= ':' && s[x]  <= '@') || (s[x] >= '[' && s[x]  <= '`') ||(s[x] >= '{' && s[x]  <= '~')){
            p[punc] = s[x];
            p[0] = pc++;
            punc++;
            x++;
        }
        x++;
    }
    a[alph] = '\0';
    d[dig] = '\0';
    w[wh] = '\0';
    p[punc] = '\0';

}
