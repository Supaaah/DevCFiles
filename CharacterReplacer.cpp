#include <iostream>
#include <string>
#include <vector>
#include <conio.h>

using namespace std;
int main();

void enterSentence();
/*
let's user enter sentence, and let the program turn that inputs into vector of characters
and output the number of words and it's lenght. 
*/
void replaceVowels(vector<char>& word);
/*
reads every single character in the vector word and search the user's target and
replace it with the another inputed character of the user to that specific chara
cter
*/
void enterSentence(){
	string str;
	int count = 1;
	char option;
	int option1;
	cin.ignore();
	cout<<"\n\t\t------Word counter and lenght------\n\n\t\t";
	cout<<"Your sentence:\n\n\t\t";
	getline(cin, str);
	vector<char> word(str.begin(), str.end()); //convert inputed string from beginning to end into vector of characters
	for(int i = 0; i<word.size();i++){
		if(word[i] == ' '){
			count++;
		}
		else{
			count = count;
		}
	}
	cout<<"\n\t\tYour sentence have "<<count<<" words"<<endl;
	cout<<"\n\t\tand have a lenght of "<<word.size();
	cout<<"\n\n\t\tAlter your sentence: ";
	cout<<"\n\n\t\t[1] replace character";
	cout<<"\n\n\t\t[2] Exit";
	cout<<"\n\n\t\tEnter your choice: ";
	cin>>option1;
	switch(option1){
		case 1:
			system("cls");
			replaceVowels(word);
			break;
		case 2:
			system("cls");
			exit(0);
			break;
		default:
			system("cls");
			cout<<"\n\t\tPlease enter correct option: ";
            getch();
            system("cls");
        	enterSentence();	
	}
}
void replaceVowels(vector<char>& word){
	char vow;
	char rep;
	string opt;
	do{
	cout<<"\n\t\t------Replace a character------";
	cout<<"\n\n\t\tYour sentence:\n\n\t\t";
	for(int i = 0;i<word.size();i++){
		cout<<word.at(i);
	}
	cout<<"\n\n\t\tWhat character you want to replace?: ";
	cin>>vow;
	cout<<"\t\tReplace it with what?: ";
	cin>>rep;
	for(int i = 0; i<word.size();i++){
		if(vow == word.at(i)){
			word.at(i) = rep;
		}
	}
	cout<<"\n\t\tYour new sentence: \n\n\t\t";
	for(int i = 0;i<word.size();i++){
		cout<<word.at(i);
	}
	cout<<"\n\n\t\tdo you want to replace character again? y/n: ";
	cin>>opt;
	system("cls");
	}while(opt.compare("y")==0);
	main();
}
int main(){
	enterSentence();
	return 0;
}
