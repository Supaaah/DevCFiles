#include <iostream>
#include <fstream>
#include <cstdlib>
#include <iomanip>

using namespace std;
void mergeSort(ifstream& inl1, ifstream &inl2, ofstream& l3);
//precondition: Get values from link inl1 and inl2
//postcondition: merge two list into one and sort them according to the highest to lowest
void mergeSort(ifstream& inl1, ifstream &inl2, ofstream& l3){
	int list1[5], list2[5],list3[10];
	int temp =0;
	for(int i = 1; i<=5; i++){ //input file 1 in array list1
		inl1>>list1[i];
		cout<<setw(3)<<list1[i];
	}
	cout<<endl;
	for(int i = 1; i<=5; i++){ //input file 2 in array list2
		inl2>>list2[i];
		cout<<setw(3)<<list2[i];
	}
	cout<<endl;
	for(int i = 1; i<=5; i++){ //combine array list1 and array list2
		list3[i] = list1[i];
		list3[i+5] = list2[i]; //added 5 in the current list3[i] to accomodate the size of both arrays
	}
	while(1){ //infinite loop
		bool sorted = false;
		for(int i = 1; i<=10; i++){ //sort the inputed number into descending order
			if((i+1) != 10 && list3[i] <= list3[i+1]){ 
				temp = list3[i];
				list3[i] = list3[i+1];
				list3[i+1] = temp;
				sorted = true;
			}
		} 
		if(sorted == false){ //when true break the infite loop
			break;
		}
	}
	for(int i=1;i<=10;i++){ //prints the sorted merge list
		cout<<setw(3)<<list3[i];
		l3<<setw(3)<<list3[i];
	}
}

int main(){
	ifstream inl1;
	ifstream inl2;
	ofstream l3;
	inl1.open("Flist.txt"); //10 2 4 8 6
	inl2.open("Slist.txt"); //7 9 3 5 1
	l3.open("Out.txt", ios::app);
	if(inl1.fail()){
		cout<<"First list file failed to open. \n";
		exit(1);
	}
	else if(inl2.fail()){
		cout<<"Second list file failed to open. \n";
		exit(1);
	}
	if(l3.fail()){
		cout<<"Output file failed to open. \n";
		exit(1);
	}
	
	mergeSort(inl1, inl2, l3);
	
	inl1.close();
	inl2.close();
	l3.close();
	
	return 0;
}


