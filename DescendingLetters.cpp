#include <iostream>

using namespace std;

void inputData(char (&letter)[10], string (PostIndi)[10], int &numArrayused){
	cout<<"Enter up to 10 letters.\nToggle dot(.) to end the loop"<<endl;
	cout<<"======================================="<<endl;
	char input;
	int i = 0;
	cout<<PostIndi[i];
	cin>>input;
	while((input!='.')&&(i<10)){
		letter[i] = input;
		i++;
		cout<<PostIndi[i];
		cin>>input;
	}
	cout<<"======================================="<<endl;
	for(int i = 0; i<10; i++){
		if(letter[i] != '.'&& letter[i] != NULL){
			cout<<letter[i];
		}
	}
	cout<<"\n======================================="<<endl;
}
void BubbleSort(char (&letter)[10]){
}
void printData(char letter[],int size){
	cout<<"Letters in Descending Order: ";
	for(int i = size; i>0;i--){
		if(letter[i] != '.' && letter[i] != NULL){
			cout<<letter[i];
		}
	}
	cout<<endl;
	cout<<"======================================="<<endl;
}

int main(){
	char letter[10];
	int numArrayused;
	string PostIndi[11] = {"1st Letter: ","2nd Letter: ","3rd Letter: ","4th Letter: ","5th Letter: ","6th Letter: ","7th Letter: ","8th Letter: ","9th Letter: ","10th Letter: ","11th Letter: "};
	cout<<"======================================="<<endl;
	cout<<"This program reads 10 letters and write \nthem back to screen in descending order.\n";
	cout<<"======================================="<<endl;
	
	inputData(letter, PostIndi, numArrayused);
	BubbleSort(letter);
	printData(letter, 10);
	return 0;
}
