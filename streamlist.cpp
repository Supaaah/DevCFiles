#include <iostream>
#include <fstream>
#include <cstdlib>

using namespace std;

void findBigSmall(ifstream& list, ofstream& out);
//pre-condition: instream and outstream has been connected to the input and output file with open
// assigned the contents of the input file in each variable
//post-condition: the smallest and highest number is printed on the screen and have been written to the connected output file.
void findBigSmall(ifstream& list, ofstream& out){
	int num1,num2,num3,num4,num5, large,small;
	while(list>>num1>>num2>>num3>>num4>>num5){
		/*if(num1<num2){
			num1 = num2;
		}
		if(num1<num3){
			num1 = num3;
		}
		if(num1<num4){
			num1 = num4;
		}
		if(num1<num5){
			num1 = num5;
		}
		if(num5>num1){
			num5 = num1;
		}
		if(num5>num2){
			num5 = num2;
		}
		if(num5>num3){
			num5 = num3;
		}
		if(num5>num4){
			num5 = num4;
		}
	}
	out<<" The largerst value is: "<<num1<<endl;
	out<<" The smallest value is: "<<num5<<endl;
	cout<<" The largerst value is: "<<num1<<endl;
	cout<<" The smallest value is: "<<num5<<endl;
	*/
}
int main(){
	ifstream list;
	ofstream out;
	
	list.open("smallbig.txt"); //68 17 88 37 100 
	if(list.fail()){
		cout<<"list file failed to open. \n";
		exit(1);
	}
	out.open("op.txt");
	if(out.fail()){
		cout<<"Output file failed to open. \n";
		exit(1);
	}
	findBigSmall(list, out);
	
	list.close();
	out.close();
}
