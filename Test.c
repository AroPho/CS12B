#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//takes in the string on one line in s, distributed for alphabetical, digits, punct, and whitespace
//in respective char pointers
void extract_chars(char* s, char* a, char* d, char* p, char* w);





int main(int argc, char* argv[]){
	FILE* in;
	FILE* out;
	char* str;
	char* alp;
	char* dig;
	char* pun;
	char* whi;
	int linecount = 0;

	//checks for proper file input on command line
	if(argc != 3){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	in = fopen(argv[1], "r");
	if (in == NULL){
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w");
	if (out == NULL){
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}
	//first time calloc, runs only once for the first line, rest is done in the loop
        str = calloc(256, sizeof(char));
	    alp = calloc(256, sizeof(char));
        dig = calloc(256, sizeof(char));
        pun = calloc(256, sizeof(char));
        whi = calloc(256, sizeof(char));

	while((fgets(str, 256, in) != NULL)){

		//call extract_chars
		extract_chars(str, alp, dig, pun, whi);
		//increment linecount for line # print
		linecount++;

		fprintf(out, "line %d contains:\n", linecount);

		//different print depending on

        fprintf(out, "%lu alphabetic characters: %s\n", strlen(alp), alp);


        fprintf(out, "%lu numeric characters: %s\n", strlen(dig), dig);


        fprintf(out, "%lu punctuation characters: %s\n", strlen(pun), pun);

        fprintf(out, "%lu whitespace characters: %s\n", strlen(whi), whi);


		//free memory
		free(str);
        free(alp);
        free(dig);
        free(pun);
        free(whi);

		//initialize memory for next run
		str = calloc(256, sizeof(char));
        alp = calloc(256, sizeof(char));
        dig = calloc(256, sizeof(char));
        pun = calloc(256, sizeof(char));
        whi = calloc(256, sizeof(char));


	}

	//if reach EOF, then free memory, no need for it
	free(str);
        free(alp);
        free(dig);
        free(pun);
        free(whi);



	fclose(in);
	fclose(out);

	return(EXIT_SUCCESS);
}

void extract_chars(char* s, char* a, char* d, char* p, char* w){
	int i = 0;
	int acount = 0;
	int dcount = 0;
	int pcount = 0;
	int wcount = 0;
	while(s[i] != '\0'){
		if(isalpha(s[i])){
			a[acount] = s[i];
			acount++;
		} else if(isdigit(s[i])){
			d[dcount] = s[i];
			dcount++;
		} else if(ispunct(s[i])){
			p[pcount] = s[i];
			pcount++;
		} else if(isspace(s[i])){
			w[wcount] = s[i];
			wcount++;
		}
		i++;
	}
}
