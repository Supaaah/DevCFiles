#include <iostream>
#include <string>
#include <vector>
#include <conio.h>
#include <string.h>
using namespace std;

vector<vector <string> > lib;

void mainMenu();
void header();
void modify();
void editBook(vector<vector <string> > lib);
void addBook(vector<vector <string> >& lib);
void deleteBook(vector<vector <string> > lib);
void mainMenu(){
	int option;
        cout<<"\n\t----------- LIBRARY MANAGEMENT SYSTEM -----------\n";
        cout<<"\n\t\t[1] View BookList\n\n\t\t[2] Search for a Book\n\n\t\t[3] Modify Book\n\n\t\t[4] Close/Exit\n";
        cout<<"\n\t\tEnter your choice : ";
        cin>>option;
        switch(option){
            case 1:
            	system("cls");
				//viewBooks(book);
                     break;
            case 2:
            	system("cls");
				//see(2);
                     break;
            case 3:
            	system("cls");
				modify();
                     break;
            case 4:
            	system("cls");
                exit(0);
                break;
            default:cout<<"\n\t\tPlease enter correct option: ";
            getch();
            system("cls");
        	mainMenu();
        }
}
void modify(){
	int option1;
	cout<<"\n\t\tPlease Choose one option :\n";
    cout<<"\n\t\t[1] Edit A Book\n\n\t\t[2] Add New Book\n\n\t\t[3] Delete A Book\n\n\t\t[4] Go back\n";
    cout<<"\n\n\t\tEnter your choice : ";
    cin>>option1;
    switch(option1){
    	case 1:
    		system("cls");
    		//editBook(lib);
    		break;
    	case 2:
    		system("cls");
    		addBook(lib);
    		break;
    	case 3:
    		system("cls");
    		deleteBook(lib);
    		break;
    	case 4:
    		system("cls");
    		mainMenu();
    		break;
    	default:
    		cout<<"\n\t\tWrong Input.\n";
    		cout<<"\n\t\tPress any key to continue.....";
    		getch();
    		system("cls");
    		modify();
    		break;
	}
}
void addBook(vector<vector <string> >& lib){
	string input, input1, id;
	int num;
	bool flag;
	cout<<"\n\t\t------Add A Book------\n\n";
	cin.ignore();
	if(lib.empty()){
		for(int i = 0; i<1; i++){
		vector <string> temp;
		cout<<"\t\tEnter Author's Name: ";  
		getline(cin, input);
		temp.push_back(input);
			for(int j = 0; j<1;j++){
				cout<<"\t\tEnter Book's Title: ";
				getline(cin, input1);
				temp.push_back(input1);
			}
			lib.push_back(temp);
			temp.clear();
		}
		if(lib.empty()){
			cout<<"\n\t\tBook Unsuccesfully Registered!";
		}
		else{
			cout<<"\n\t\tBook Succesfully Registered!";
		}
	}
	else{
		for(int i = 0; i<1; i++){
		vector <string> temp;
		cout<<"\t\tEnter Author's Name: ";  
		getline(cin, input);
		temp.push_back(input);
			for(int j = 0; j<1;j++){
				cout<<"\t\tEnter Book's Title: ";
				getline(cin, input1);
				if(input1 == lib){
					cout<<"\n\t\tBook succesfully registered!";
					temp.push_back(input1);
					flag = false;
				}
				else{
					cout<<"\n\t\tBook already exist!";
					flag = true;
					temp.clear();
					break;
				}
			}
			if(flag == true){
				temp.clear();
				break;
			}
			else{
				lib.push_back(temp);
				temp.clear();
			}		
		}
	}
	cout<<endl<<"\n\t\t";
	system("pause");	
	system("cls");
	modify();
}
void deleteBook(vector <vector <string> > lib){
	cout<<"\n\t\t------Delete A Book------\n\n";
	for(int i = 0; i<lib.size();i++){
		for(int j = 0; j<lib[i].size();j++){
			cout<<"\t\t"<<lib[i][j];
		}
		cout<<endl;
	}
	cout<<"\n\t\t";
	system("pause");//temporary for checking
	system("cls");
	modify();
}
int main(){
	
	mainMenu();
	return 0;
}
