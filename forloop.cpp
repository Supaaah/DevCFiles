#include <iostream>
using namespace std;

int main(){
	
	string prodname1,prodname2,prodname3,prodname4;
	int prodreg;
	cout<<"register products how many?: ";
	cin>>prodreg;
	for(int i = 0; i<prodreg; i++){
		if(i == 0){
			cout<<"prodname: ";
			cin>>prodname1;
		}
		if(i== 1){
			cout<<"prodname: ";
			cin>>prodname2;
		}
	}
	
	return 0;
}
