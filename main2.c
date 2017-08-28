//This program prints out employee data from a struct
//and prints it using both by value and pointer
//Hopefully phone number length doesn't change
//before this program is out of date
#include <stdio.h>
#include <stdlib.h>

#define MAXNAME 20                 //max name length



struct phone_number                //phone struct
	{
		char area_code[4];         //area code string
		char first[4];             //first 3 digits
		char last[5];		       //last 4 digits
	};
	

struct employee                     // employee information
	{
		long number;                //employee number
		char name[MAXNAME];         //emplyoee name
		struct phone_number phone;  //adds phone number
		int age;                    //employee age
	};

int main() {
	
	
	
    void prEmps(struct employee table[], int n);
    void prEmps2(struct employee *ptr, int n);
	
	struct employee table[] =
	{
		{1001, "Smith, Christa", {"555","341","4321"}, 21},
		{1002, "Alec, Austin", {"612", "555","4242"}, 23},
		{1003, "D'Marco, Mac", {"432","217","5152"}, 25},
		{1004, "Dunn, Kevin", {"555","541","7364"}, 27},	
	};
	
	prEmps(table, sizeof(table)/sizeof(table[0]));
	
	prEmps2(table, sizeof(table)/sizeof(table[0]) );
	
	return 0;
}

void prEmps( struct employee table[], int n)             //print employee data by value                
{
	int i;                                              //index counter
	printf("This is a print out of employee table using values.\n\n");
	for (i = 0; i < n; i++)
	   printf("Number: %-5li Name: %-20s Phone Number (%s)-%s-%s Age: %2i\n",
	   table[i].number, table[i].name, table[i].phone.area_code,
	   table[i].phone.first, table[i].phone.last, table[i].age);
	   printf("\n");
}

void prEmps2(struct employee *ptr, int n)                //print employee data by pointer
{
	printf("This is a print out of employee table using pointers.\n\n");
	
	struct employee *endptr = ptr + n;                   //end pointer
	
	for(; ptr <endptr; ptr++)
	   printf("Number: %-5li Name: %-20s Phone Number (%s)-%s-%s Age: %2i\n", 
	   ptr->number, ptr->name, 
	   ptr->phone.area_code, ptr->phone.first, ptr->phone.last, ptr->age);
	   printf("\n");
}
