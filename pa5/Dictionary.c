#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "Dictionary.h"
#include "string.h"

#define tableSize 101

typedef struct NodeObj{
    char* key;
    char* value;
    struct NodeObj * next;
} NodeObj;

typedef NodeObj* Node;

Node newNode(char *k, char *v){
    Node N = malloc(sizeof(NodeObj));
    assert(N != NULL);
    N->key = k;
    N->value = v;
    N->next = NULL;
    return N;
}

void freeNode(Node *pN){
    if(pN != NULL && *pN != NULL){
        free(*pN);
        *pN = NULL;
    }
}

typedef struct DictionaryObj{
    Node table[tableSize];
    int numItems;
}DictionaryObj;

// Dictionary
// Exported reference type
typedef struct DictionaryObj* Dictionary;

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
    Dictionary D = calloc(tableSize, sizeof(DictionaryObj));
    assert(D != NULL);
    D-> numItems = 0;
    return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
    if(pD != NULL && *pD != NULL){
        makeEmpty(*pD);
        free(*pD);
        *pD = NULL;
    }
}

// rotate_left()
// rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) {
    int sizeInBits = 8*sizeof(unsigned int);
    shift = shift & (sizeInBits - 1);
    if ( shift == 0 )
        return value;
    return (value << shift) | (value >> (sizeInBits - shift));
}
// pre_hash()
// turn a string into an unsigned int
unsigned int pre_hash(char* input) {
    unsigned int result = 0xBAE86554;
    while (*input) {
        result ^= *input++;
        result = rotate_left(result, 5);
    }
    return result;
}
// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key){
    return pre_hash(key)%tableSize;
}

// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
    if(D->numItems == 0){
        return 1;
    }
    return 0;
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
    return D->numItems;
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){
    int hk = hash(k);
    if(D->table[hk] != NULL){
        Node temp = D->table[hk];
        while(temp != NULL){
            if(/*strcmp(temp->key, k) == 0*/ temp->key == k){
                char* val = temp->value;
                //freeNode(temp);
                return val;
            }
            temp = temp->next;
        }
    }
    return  NULL;
}

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
    int hashk = hash(k);
    if(D->table[hashk] == NULL){
        D->table[hashk] = newNode(k,v);
    }else{
        Node temp = D->table[hashk];
        D->table[hashk] = newNode(k,v);
        D->table[hashk]->next = temp;
        freeNode(temp);
    }
    D->numItems++;
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
    if (lookup(D, k) == NULL) {
        return;
    }
    Node P = NULL;
    int hashk = hash(k);
    Node temp = D->table[hashk];
    if(/*strcmp(temp->key,k) == 0*/ temp->key == k){
        D->table[hashk] = temp->next;
        freeNode(temp);
        D->numItems--;
        return;
    }else {
        while (temp != NULL) {
            if (strcmp(temp->key, k) == 0 || temp->key == k) {
                P->next = temp->next;
                freeNode(temp);
                D->numItems--;
                return;
            }else{
                P = temp;
                temp = temp->next;
            }
        }
    }

}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
    for(int x = 0; x < tableSize; x++){
        freeNode(D->table[x]);
    }
    D->numItems = 0;
}

void printNode(FILE *out, Node n) {
    fprintf(out, "%s %s\n", n->key, n->value);
}

// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){
    for (int i = 0; i < tableSize; i++) {
        if (isEmpty(D) == 0) {
            if (D->table[i] != NULL) {
                printNode(out, D->table[i]);
                if (D->table[i]->next != NULL) {
                    Node temp = D->table[i]->next;
                    while (temp != NULL) {
                        printNode(out, temp);
                        temp = temp->next;
                    }
                }
            }
        }
    }
}
