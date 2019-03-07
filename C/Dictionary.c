//-----------------------------------------------------------------------------
// List.c
// Linked List implementation of an indexed List of Strings ADT in C, where 
// indices range from 1 to length of List. This is basically a translation
// of the IntegerList ADT (based on a singly linked List) into C, and holding
// C strings instead of ints. Functions remove() and removeAll() were changed
// to delete() and deleteAll() because stdio.h already contains a function
// called remove().
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

// private types and functions ------------------------------------------------

// NodeObj
typedef struct NodeObj{
   char* value;
   char* key;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor for private Node type
Node newNode(char* k, char* v) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return N;
}

// freeNode()
// destructor for private Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}

// ListObj
typedef struct DictionaryObj{
   Node head;
   int numItems;
} DictionaryObj;

// find()
// returns a reference to the Node at position index in L
// pre: 1 <= index <= numItems
Node findKey(Dictionary L, char* k){
   Node N = L->head;
   int i;
   for( i=1; i<= L->numItems; i++){
     if(strcmp(L->key, k) == 0){
       return N;
     }
     N = N-> next;
   }
   return NULL;
}


// public ADT operations ------------------------------------------------------

// newList()
// constructor for the List type
Dictionary newDictionary(void){
   Dictionary L = malloc(sizeof(DictionaryObj));
   assert(L!=NULL);
   L->head = NULL;
   L->numItems = 0;
   return L;
}

// freeList()
// destructor for the List type
void freeDictionary(Dictionary* pL){
   if( pL!=NULL && *pL!=NULL ){
      deleteAll(*pL);
      free(*pL);
      *pL = NULL;
   }
}

// isEmpty()
// returns 1 (true) if List L is empty, 0 (false) otherwise
int isEmpty(Dictionary L){
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling isEmpty() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   return L->numItems==0 ;
}

// size()
// returns the number of elements in L
int size(Dictionary L){
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling size() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   return L->numItems;
}

// get()
// pre: 1 <= index <= size()
// returns string in L at position index
char* lookup(Dictionary L, char* k){
   Node N = NULL;
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling get() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   N = findKey(L, k);
   if(N->key != NULL && strcmp(N->key,k)){  
     return N->value;
   }else{
     return NULL;
   }
}

// add()
// insert string s into L at position index
// pre: 1 <= index <= size()+1
void insert(Dictionary L, char* k, char* v){
   Node N = NULL, P=NULL, C=NULL;
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling add() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   if(L->numItems == 0){
      L = newNode(k, v);
   }else{
      P = find(L, index-1); // at this point index >= 2
      C = P->next;
      P->next = newNode(k,v);
      P = P->next;
      P->next = C;
   }
   L->numItems++;
}

// delete()
// deletes string from position index
// pre: 1 <= index <= size()
void delete(Dictionary L, int index){
   Node N=NULL, P=NULL;
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling delete() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   if( index<1 || index>(L->numItems) ){
      fprintf(stderr, 
         "List Error: calling delete() on invalid index: %d\n", index);
      exit(EXIT_FAILURE);
   }
   if(index==1){
      N = L->head;
      L->head = L->head->next;
      N->next = NULL;
      freeNode(&N);
   }else{
      P = findKey(L, index-1);
      N = P->next;
      P->next = N->next;
      N->next = NULL;
      freeNode(&N);
   }
   L->numItems--;
}

// deleteAll()
// reset L to the empty state
void makeEmpty(Dictionary L){
   Node N=NULL;
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling deleteAll() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   while( L->numItems > 0 ){
      N = L->head;
      L->head = L->head->next;
      N->next = NULL;
      freeNode(&N);
      L->numItems--;
   }
}

// printList()
// prints a text representation List L to the file pointed to by out
void printDictionary(FILE* out, Dictionary L){
   Node N=NULL;
   if( L==NULL ){
      fprintf(stderr, 
         "List Error: calling printList() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   N = L->head;
   while( N!=NULL ){
      fprintf(out, "%s ",N->key + " " + N->value);
      N = N->next;
   }
}

// equals()
// returns true (1) if L and R are matching sequences of strings, and returns
// false (0) otherwise
/*int equals(List L, List R){
   Node N=NULL, M=NULL;
   int eq;
   if( L==NULL || R==NULL ){
      fprintf(stderr, 
         "List Error: calling equals() on NULL List reference\n");
      exit(EXIT_FAILURE);
   }
   N = L->head;
   M = R->head;
   eq = (L->numItems==R->numItems);
   while( eq && N!=NULL && M!=NULL ){
      eq = ( strcmp(N->item, M->item)==0 );
      N = N->next;
      M = M->next;
   }
   return eq;
}*/
