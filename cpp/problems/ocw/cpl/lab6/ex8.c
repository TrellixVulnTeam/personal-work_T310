#include <string.h> //memcmp
#include <stdio.h>
 
struct comp_ex {
    char c;
    int i;
    short s;
};

int main() {
     struct comp_ex sa, sb;

     //sa = sb;     
 
     // toate câmpurile din a și b sunt inițializate 
     sa.c = sb.c = 1;
     sa.i = sb.i = 2;
     sa.s = sb.s = 3;
 
     if (0 == memcmp(&sa, &sb, sizeof(struct comp_ex)))
         printf("structurile sunt identice\n");
     else
         printf("structurile sunt diferite\n");
 
     return 0;
}
