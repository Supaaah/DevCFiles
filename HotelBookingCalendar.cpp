#include <iostream>
#include <iomanip>

using namespace std;

const int days = 7, weeks = 5, monthday =31, year = 2022;
string day[7] ={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
int cal[weeks][days];

void title();
//prints out title included in the void function

void printDays(string (day)[7]);
/*
pre-condition: on each index in array day[7] contains the following days in a week
post-condition: print all the string in the array day[7] in the following order
sun mon tue wed thu fri sat
*/

void headCalendar(int (&cal)[weeks][days]);
/*
pre-condition: Global constants weeks and days are the dimensions of the array
for each index weeks and days contains the number of days in each week
post-condition: all data on cal[weeks][days] have been displayed
 1  2  3  4  5  6 
 7  8  9 10 11 12 
13 14 15 16 17 18 19 
20 21 22 23 24 25 26 
27 28 29 30 31
*/

void markBook(int (&cal)[weeks][days], int book);
/*
pre-condition: Global constants weeks and days are the dimensions of the array
for each index weeks and days contains the number of days in each week and store
user input into variable book that will be used to search for and mark the target
date when found in the array
post-condition: display printDays and the calendar itself but now with the target(booked date)
marked.
*/
char remarkNow(int (cal)[weeks][days], int book);
/*
pre-condition: Global constants weeks and days are the dimensions of the array,
the variable book is used to store the user input that verify if that input(target)
exist within the array cal[weeks][days]
post-condition: return a character of 'A' when target is found in the array and is not marked
else nothing will return
*/
void remarBook(int (&cal)[weeks][days],int book);
/*
pre-condition: called and updates the values in array cal and used the global constants
weeks and days as dimension of the array, while variable book used to store the user input
which used as condition to find the target value in the array
post-condition: either there is return 'A' in the remarknow function therefore it will rerun void markBook
that will marked the target date inputed by user and display it or display the message that it is already 
been booked.
*/
void title(){
	cout<<" ===================================="<<endl;
	cout<<"    Abrigo's Online Booking System"<<endl;
	cout<<" ===================================="<<endl;
	cout<<"  Note: X - date already been booked"<<endl;
	cout<<" ===================================="<<endl;
}
void printDays(string (day)[7]){
	cout<<" - - - - - -Calendar "<<year<<"- - - - - -"<<endl;
	cout<<"            Month of May"<<endl;
	cout<<" - - - - - - - - - - - - - - - - - -"<<endl;
	for(int i = 0; i<7;i++){ //prints dayss
		cout<<setw(5)<<day[i];
	}
	cout<<endl;
}
void headCalendar(int (&cal)[weeks][days]){
	int firstday = 1;
	printDays(day);
	cout<<endl;
	for(int i = 0; i<weeks;i++){ //input numbers into array
		for(int j = 0; j<days; j++){
			cal[i][j] = firstday;
			firstday++;
			if(firstday-1>monthday){
				break;
			}
			cout<<setw(5)<<cal[i][j];
        	if (j == 6) {
            	cout<<endl;
            	// 1  2  3  4  5  6  7 
				// 8  9 10 11 12 13 14
            }
		}
	}
	cout<<endl;
	cout<<" ===================================="<<endl;
}
void markBook(int (&cal)[weeks][days], int book){
	for(int i = 0; i<weeks;i++){
		for(int j = 0; j<days;j++){
			if(book == cal[i][j]){
				cal[i][j] = 88;
			}
		}
	}
	printDays(day);
	for(int i = 0; i<weeks;i++){
		for(int j = 0; j<days;j++){
			if((cal[i][j] <32&&cal[i][j]>0)|| cal[i][j] == 88){
				if(cal[i][j]==88){
					cout<<setw(5)<<static_cast<char>(cal[i][j]);
				}
				else{
					cout<<setw(5)<<cal[i][j];
				}
       			if (j == 6){
            		cout<<endl;
            	}
			}
		}
	}
	cout<<endl;
	cout<<" ===================================="<<endl;
}
char remarkNow(int (cal)[weeks][days], int book){
	for(int i = 0; i<weeks;i++){
		for(int j = 0; j<days;j++){
			if(book == cal[i][j] && cal[i][j] != 'X'){
				return 'A';
			} 
		}
	}
}
void remarkBook(int (&cal)[weeks][days], int book){
	char marked;
	marked = remarkNow(cal, book);
	if(marked == 'A'){
		markBook(cal,book);
	}
	else{
		cout<<"  Date has already been booked!"<<endl;
		cout<<" ===================================="<<endl;
	}
}
void bookNow(int (&cal)[weeks][days], char &option, int &book){
	char option1;
	cout<<"  Do you want to book? (y/n): ";
	cin>>option;
	cout<<" ===================================="<<endl;
	switch(option){
		case 'y':
			cout<<"  Date to be booked: ";
			cin>>book;
			cout<<" ===================================="<<endl;
			markBook(cal, book);
			do{
				cout<<"  Do you want to book again?(y/n): ";
   				cin>>option1;
   				cout<<" ===================================="<<endl;
    			switch(option1){
    				case 'y':
    					cout<<"  Date to be booked: ";
						cin>>book;
						cout<<" ===================================="<<endl;
						remarkBook(cal, book);
    					break;
    				case 'n':
    					cout<<"        Thank you for Booking!"<<endl;
    					cout<<" ===================================="<<endl;
    					break;
    				default:
    					cout<<"  Invalid Input! Please try again."<<endl;
    					cout<<" ===================================="<<endl;
	    				break;
				}
			}while(option1 !='n' && option1 != 'N');
			break;
		case 'n':
			cout<<"          Program Terminated!"<<endl;
			cout<<" ===================================="<<endl;
			break;
		default:
			cout<<"  Invalid Input! Please try again."<<endl;
			cout<<" ===================================="<<endl;
			break;
	}
}

int main(){
	int book;
	char option;
	title();
	headCalendar(cal);
	bookNow(cal, option, book);

	return 0;
}

