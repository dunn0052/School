#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLENGTH 80                           //maximum word length

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	void rmchr(char *strg, char garbage);
	int getline(char line[], int max);
	
	char line[MAXLENGTH];                    //user's string input
	printf("Enter a string.\n");
	getline(line, MAXLENGTH);
	char * str = malloc(strlen(line));         //allocate string container
	printf("The string you input was %s\n", line);
    strcpy(str, line);
    printf("Enter the charecter you would like to remove from your string.\n");
    rmchr(str, getchar());
    printf("Your new string is %s", str);
    free(str);
    return 0;
	
}

void rmchr(char *strg, char garbage)               //removes charecter from string
{

    char *src, *dst;                              //source and destination string pointers
    for (src = dst = str; *src != '\0'; src++) 
	{
        *dst = *src;
        if (*dst != garbage) dst++;
    }
    *dst = '\0';
}

int getline(char line[], int max)                  // takes in line and stores to string
{
	int c;
	int i = 0;
	while ((c = getchar()) != '\n' && c != EOF)
	   if(i < max)
	      line[i++] = c;
	line[i] = '\0';
	return (c == EOF) ? -1 : i;
}
