#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

void getAverage(double&ApW);
/*
reads all number in the Gaming_arr array inputed by the user and 
place their value in ApW(average per week)
*/
void inputData(double(&Gaming_arr)[7], int weeks);
/*
pre-condition: weeks is used as the limit in a loop that determines how many weeks in a month
post-condtion: Through week 1 to week 4, Gaming_arr[7] equates to the average gaming hours for weeks variable weeks
*/
void tableData(string title[2], double Gaming_arr[7],int WperM);
/*
pre-condition: read all values in title[2], Gaming_arr[7] where all values are averaged gaming hours per week, and 
weeks is used as the limit in the loop that determines how many weeks in a month
post-condition: A table will be displayed as follows by their Week and Hour average,
also the gaming hour average monthly will be displayed
*/
void getAverage(double& ApW){
	ApW = 0;
	double TpW = 0;
	int Ghours;
	
	for(int counter = 1;counter <= 7;counter++){
		cout<<"Day "<<counter<<": ";
		cin>>Ghours;
		TpW = TpW + Ghours;
	}
	cout<<endl;
	ApW = TpW/7;
	cout<<"User's average gaming hours this week is: "<<fixed<<setprecision(2)<<ApW<<endl<<endl;
}
void inputData(double(&Gaming_arr)[7], int weeks){
	for(int i = 0; i<weeks; i++){
		cout<<"Enter the gaming hours per day for week "<<i+1<<endl<<endl;
		getAverage(Gaming_arr[i]);
	}
}
void tableData(string title[2], double Gaming_arr[7],int WperM){
	double Temp = 0;
	cout<<"The average gaming hours of the user for each week this month is: \n"<<endl;
	for(int i = 0; i<2;i++){
		cout<<setw(13)<<title[i];
	}
	cout<<endl;
	for(int i = 0; i< WperM; i++){
		cout<<setw(11)<<i+1<<setw(15)<<Gaming_arr[i]<<endl;
	}
	cout<<endl;
	for(int i = 0; i<WperM; i++){
		Temp = Temp + Gaming_arr[i];
	}
	cout<<"The average gaming hours of the user for this month is: "<<(Temp/WperM)<<" Hours"<<endl;
}
int main(){
	double Gaming_arr[7]; //gaming hours per week 0 1 2 3 4 5 6 7 - 1 7 days a week
	string title[2] = {"Weeks", "Hours"};
	int WperM = 4; //4 weeks per month
	double ave = 0;
	cout<<"||=========================================||"<<endl;
	cout<<"  User's Weekly Average Gaming Hour Tracker"<<endl;
	cout<<"||=========================================||"<<endl;
	inputData(Gaming_arr, WperM);
	tableData(title, Gaming_arr, WperM);

	return 0;
}
