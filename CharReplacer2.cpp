#include <iostream>
#include <string>
#include <vector>
#include <conio.h>
#include<stdlib.h>

using namespace std;
int main();
void enterSentence();
void replaceVowels(vector<char>& word);
void replaceWords(vector<char>& word);

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
	cout<<"\n\n\t\t[2] replace word";
	cout<<"\n\n\t\t[3] Exit";
	cout<<"\n\n\t\tEnter your choice: ";
	cin>>option1;
	switch(option1){
		case 1:
			system("cls");
			replaceVowels(word);
			break;
		case 2:
			system("cls");
			replaceWords(word);
		case 3:
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

void replaceWord(vector<char>& word){
	string opt1;
	char wor;
	char worRep;
	do{
		cout<<"\n\t\t------Replace a character------";
		cout<<"\n\n\t\tYour sentence:\n\n\t\t";
		for(int i = 0;i<word.size();i++){
			cout<<word.at(i);
		}
		cout<<"\n\n\t\tWhat character you want to replace?: ";
		cin>>wor;
		cout<<"\t\tReplace it with what?: ";
		cin>>worRep;
		for(int i = 0; i<word.size();i++){
			if(wor == word.at(i)){
				word.at(i) = worRep;
			}
		}
		cout<<"\n\t\tYour new sentence: \n\n\t\t";
		for(int i = 0;i<word.size();i++){
			cout<<word.at(i);
		}
		cout<<"\n\n\t\tdo you want to replace character again? y/n: ";
		cin>>opt1;
		system("cls");
	}while(opt1.compare("y")==0);
	main();
}
int main(){
	enterSentence();
}
