#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLENGTH 80                           //maximum word length

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	char rmchr(char *str, char garbage);
	int getline(char line[], int max);
	
	FILE * fp = fopen("assign11.txt", "a+");
	
	if (fp == NULL)
		printf("Error opening file");
	else
	{
	char line[MAXLENGTH];                        //user's string input
	printf("Enter a string.\n");
	getline(line, MAXLENGTH);
	char * str = malloc(strlen(line)+1);         //allocate string container
	printf("The string you input was %s\n", line);
    strcpy(str, line);
    printf("Enter the charecter you would like to remove from your string.\n");
    char rmv = rmchr(str, getchar());            //rmv to print removed char
    printf("The letter %c removed from %s is %s\n", rmv, line, str);
    fprintf(fp, "The letter %c removed from %s is %s\nn", rmv, line, str);
    free(str);
	}
    if(fclose(fp) != 0)
    	printf("Error closing file.");
	return 0;
	
}

char rmchr(char *str, char garbage)               //removes charecter from string
{

    char *src, *dst;                              //source and destination string pointers
    for (src = dst = str; *src != '\0'; src++) 
	{
        *dst = *src;
        if (*dst != garbage) dst++;
    }
    *dst = '\0';
    return garbage;
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
