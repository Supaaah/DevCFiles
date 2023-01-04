#include <iostream>
#include <string>
using namespace std;
void mainMenu(struct student &stud,bool &isempty);
void inputData(struct student &stud,bool &isempty);
void viewGrades(struct student &stud);

class student{
	public:
	string name;
	double pfmtsk;
	double recit;
	double quiz;
	double exam;
	double gwa;
};
void computation(struct student &stud){
	stud.gwa = (stud.pfmtsk+stud.recit+stud.quiz+stud.exam)*0.625+37.5;
}

void inputData(struct student &stud,bool &isempty){
	double pscore1,pscore2,pscore3,pscore4;
	double score1,score2,score3,score4;
	double temp1,temp2,temp3,temp4;
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\t\t\t\tInput Data\n";
	cout<<"\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\t\tTotal Score for performance task: ";
	cin>>pscore1;
	cout<<"\n\t\tTotal Score for recitation: ";
	cin>>pscore2;
	cout<<"\n\t\tTotal Score for quiz: ";
	cin>>pscore3;
	cout<<"\n\t\tTotal Score for examination: ";
	cin>>pscore4;
	cout<<"\n\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\t\t\tname: ";
	cin>>stud.name;
	cout<<"\n\t\t\tperformance task score: ";
	cin>>score1;
	cout<<"\n\t\t\trecitation: ";
	cin>>score2;
	cout<<"\n\t\t\tquiz score: ";
	cin>>score3;
	cout<<"\n\t\t\texam score: ";
	cin>>score4;
	isempty = false;
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -";
	cout<<"\n\n\t\t\t";
	temp1 = (score1/pscore1)*0.40*100;
	temp2 = (score2/pscore2)*0.15*100;
	temp3 = (score3/pscore3)*0.20*100;
	temp4 = (score4/pscore4)*0.25*100;
	
	stud.pfmtsk = temp1;
	stud.recit = temp2;
	stud.quiz =temp3;
	stud.exam = temp4;
	computation(stud);
	
	system("pause");
	mainMenu(stud,isempty);
}
void viewGrade(struct student stud,bool isempty){
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\t\t\t\tView Computed Grade\n";
	cout<<"\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\t\tStudent Name: "<<stud.name;
	cout<<"\n\t\tGWA (term)  : "<<stud.gwa;
	if(stud.gwa>=75){
		cout<<"\n\t\tStatus: PASSED!";
	}
	else{
		cout<<"\n\t\tStatis: FAILED!";
	}
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n\t\t";
	system("pause");
	system("cls");
	mainMenu(stud,isempty);
}
void mainMenu(struct student &stud, bool &isempty){
	int option;
	system("cls");
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\t\t\tTerm Grade Calculator\n";
	cout<<"\t\t- - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\n\t\t\t[1] Input Data\n\n";
	cout<<"\t\t\t[2] View Computed Grades";
	cout<<"\n\n\t\t\t[3] Exit/Terminate\n";
	cout<<"\n\n\t\t- - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\t\tEnter your preferred choice: ";
	cin>>option;
	switch(option){
		case 1:
			system("cls");
			inputData(stud, isempty);
			break;
		case 2:
			if(isempty == true){
				system("cls");
				cout<<"\n\t\tData is empty please fill out first!\n\t\t";
				system("pause");
				mainMenu(stud, isempty);
			}
			else{
				system("cls");
				viewGrade(stud,isempty);
			}
			break;
		case 3:
			system("cls");
			cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - -\n";
			cout<<"\t\tProgram Terminated. Thank you!.";
			cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - -";
			break;
		default:
			system("cls");
			cout<<"\n\t\tInvalid choise please choose again!\n";
			system("pause");
			mainMenu(stud, isempty);
			break;
	}
}
int main(){
	struct student stud;
	bool isempty = true;
	mainMenu(stud, isempty);
	return 0;
}
