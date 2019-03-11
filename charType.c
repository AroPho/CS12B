//-----------------------------------------------------------------------------
// alphaNum.c
// extracts alpha-numeric characters from each line of the input file
// and places them in the output file.
//
// Recall the program FileIO.c from lab3 used fscanf to parse words in
// a file and then process them.  However the function fscanf is not
// appropriate when you want to read an entire line from a file as a
// string.  In this program we use another IO function from stdio.h called
// fgets() for this purpose.  Its prototype is:
//
//         char* fgets(char* s, int n, FILE* stream);
//
// fgets() reads up to n-1 characters from stream and places them in
// the character array ponted to by s.  Characters are read until either
// a newline or an EOF is read, or until the specified limit is reached.
// After the characters have been read, a null character '\0' is placed
// in the array immediately after the last character read.  A newline
// character in stream will be retained and placed in s.  If successful,
// fgets() returns the string s, and a NULL pointer is returned upon
// failure.  See fgets in section 3c of the unix man pages for more.
//
//-----------------------------------------------------------------------------

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
   alpha_num = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line!=NULL && alpha_num!=NULL );
   int count = 1;
   // read each line in input file, extract alpha-numeric characters
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_chars(line, alphabet, number, punctuation, white);
      fprintf(out, "line %i contains:\n", count);
      fprintf(out, "%i alphabetic characters: %s\n",a , alpha);
      fprintf(out, "%i numeric characters: %s\n",n , num);
      fprintf(out, "%i punctuation characters: %s\n",p , punc);
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
    while(s[x] != '\0' && i < MAX_STRING_LENGTH){
        if(s[x] >= 'a' && s[x]  <= 'z' || s[x] >= 'A' && s[x]  <= 'Z'){
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
        else{
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
