#include <iostream>
#include <string>
using namespace std;

class studGrade{
	public:
		void mainMenu();
		void inputData(bool &isempty, string& name, double& pfmtsk,double& recit,double& quiz,double& exam,double& gwa);
		void viewGrades(string name, double gwa, double &gequal);
		
	private:
		bool isempty;
		string name;
		double pfmtsk;
		double recit;
		double quiz;
		double exam;
		double gwa;
		double gequal;
		double computation(double pfmtsk,double recit,double quiz,double exam,double& gwa);
		double GradeEquivalent(double gwa, double &gequal);
};

double studGrade::computation(double pfmtsk,double recit,double quiz,double exam,double& gwa){
	gwa = (pfmtsk+recit+quiz+exam)*0.625+37.5;
	return gwa;
}
double studGrade::GradeEquivalent(double gwa, double &gequal){
	if(gwa>=98 && gwa<=100){
		gequal= 1.00;
	}
	if(gwa>=95 && gwa<=97){
		gequal= 1.25;
	}
	if(gwa>=92 && gwa<=94){
		gequal= 1.50;
	}
	if(gwa>=89 && gwa<=91){
		gequal= 1.75;
	}
	if(gwa>=86 && gwa<=88){
		gequal= 2.00;
	}
	if(gwa>=83 && gwa<=85){
		gequal= 2.25;
	}
	if(gwa>=80 && gwa<=82){
		gequal= 2.50;
	}
	if(gwa>=77 && gwa<=79){
		gequal = 2.75;
	}
	if(gwa>=75 && gwa<=76){
		gequal= 3.00;
	}
	if(gwa>=70 && gwa<=74){
		gequal= 4.00;
	}
	if(gwa>=37.5 && gwa<=69){
		gequal= 5.00;
	}
	return gequal;
}
void studGrade::viewGrades(string name, double gwa, double &gequal){
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\t\t\t\tView Computed Grade\n";
	cout<<"\t\t- - - - - - - - - - - - - - - - - - - - - -\n";
	cout<<"\n\t\tStudent Name: "<<name;
	cout<<"\n\t\tGWA (term)  : "<<gwa;
	cout<<"\n\t\tEquivalent Grade: "<<gequal;
	if(gwa>=75 && gequal<= 3.00){
		cout<<"\n\t\tStatus: Passed!";
	}
	else{
		cout<<"\n\t\tStatus: Failed!";
	}
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -\n\t\t";
	system("pause");
	system("cls");
	mainMenu();
}
void studGrade::inputData(bool &isempty, string& name, double& pfmtsk,double& recit,double& quiz,double& exam,double& gwa){
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
	cout<<"\n\t\tname: ";
	cin>>name;
	cout<<"\n\t\tperformance task score: ";
	cin>>score1;
	cout<<"\n\t\trecitation: ";
	cin>>score2;
	cout<<"\n\t\tquiz score: ";
	cin>>score3;
	cout<<"\n\t\texam score: ";
	cin>>score4;
	isempty = false;
	cout<<"\n\t\t- - - - - - - - - - - - - - - - - - - - - -";
	cout<<"\n\n\t\t\t";
	temp1 = (score1/pscore1)*0.40*100;
	temp2 = (score2/pscore2)*0.15*100;
	temp3 = (score3/pscore3)*0.20*100;
	temp4 = (score4/pscore4)*0.25*100;
	
	pfmtsk = temp1;
	recit = temp2;
	quiz =temp3;
	exam = temp4;
	computation(pfmtsk, recit, quiz, exam, gwa);
	GradeEquivalent(gwa,gequal);
	system("pause");
	mainMenu();
}
void studGrade::mainMenu(){
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
			inputData(isempty,name,pfmtsk,recit,quiz,exam,gwa);
			break;
		case 2:
			if(isempty == true){
				system("cls");
				cout<<"\n\t\tData is empty please fill out first!\n\t\t";
				system("pause");
				mainMenu();
			}
			else{
				system("cls");
				viewGrades(name,gwa,gequal);
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
			cout<<"\n\t\tInvalid choise please choose again!\n\t\t";
			system("pause");
			mainMenu();
			break;
	}
}
int main(){
	studGrade stud;
	stud.mainMenu();
}
