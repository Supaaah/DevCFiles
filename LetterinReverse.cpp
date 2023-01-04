#include <iostream>
using namespace std;

void inputData(char letter[],int size, int &used);
/*
pre-condition: size is the declared size of the array letter[].
post-condition: used is the number of characters stored in letter[].
where 0 - size have been filled with letters except .
*/
void swap(char &a, char&b);
/*
swap the values of a and b
*/
void sortInReverse(char (&let)[10], int numArray);
/*
pre-condition: numArray is the declared size of the array let[].
reads the values from array let from [0] - [numArray]
post-condition: The characters from let[0] through let[numArray]
have been rearranged into let[0] will have the value of let[6] and so on.
*/
void printData(char let[],int numArray);
/*
pre-condition: reads the values inside the array let[] and the numArray is the
declared size that limits the outputted letters.
post-condition: all the data in let will appear on the screen in reverse order.
*/
void inputData(char letter[],int size, int &used){
	cout<<"Enter up to 10 letters and\ntoggle dot(.) to end the loop"<<endl;
	cout<<"========================================"<<endl;
	cout<<"Letters: ";
	char input;
	int index = 0;
	do{
		cin>>input;
		letter[index] = input;
		index++;
	}while((input!='.')&&(index<=size));

	cout<<"========================================"<<endl;
	cout<<"Letters in the array: ";
	for(index = 0; index<size; index++){
		if(letter[index] != '.'){
			cout<<letter[index];
		}
	}
	cout<<"\n========================================"<<endl;
	used = index;
}
void swap(char &a, char&b){
	char temp = a;
	a = b;
	b = temp;
}
void sortInReverse(char (&let)[10], int numArray){ //using selection sort
	for(int i = 0; i<numArray-1;i++){
		for(int j = i +1; j<numArray;j++){
				char temp = i;
				temp = j;
				swap(let[i], let[temp]);
			}
	}
}
void printData(char let[],int numArray){ 
	cout<<"Letters in reverse order: ";	
	for(int i = 0; i<numArray;i++){
			if(let[i] != '.' && let[i] != NULL){
				cout<<let[i];
			}
	}
	cout<<"\n========================================"<<endl;
}
int main(){
	
	char letter[10];
	int numArray;
	cout<<"========================================"<<endl;
	cout<<"This program reads 10 letters and writes \nthem back to the screen in reverse order.\n";
	cout<<"========================================"<<endl;
	
	inputData(letter,10, numArray);
	sortInReverse(letter,numArray);
	printData(letter, numArray);
	
	return 0;
}
