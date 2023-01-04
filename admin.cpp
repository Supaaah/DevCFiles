#include <iostream>

using namespace std;
int main(){
    int choice;
    int ladieschoice;
    int prodchoice;
    int regProd;
    string prodName = "";
    string user = "";
    string pass = "";
    string shopName, shopContact, shopLoc;
    bool islogin = false;
    int trial = 3;

    cout<<"||==============================================||"<<endl;
    cout<<"|| Welcome to Not My Nut Online Shopping System ||"<<endl;
    cout<<"||==============================================||"<<endl;
    do{ 
        cout<<"    User: ";
        cin>>user;
        cout<<"    Pass: ";
        cin>>pass;
        cout<<"||==============================================||"<<endl;
            if(user == "admin" && pass == "admin" && trial !=0){ //checks if the inputs are the admin's account
                islogin = true; //updates islogin that counters the condition below so it will not run infinitely
                
                shopName = "Not My Nut";
                shopContact = "09123456988";
                shopLoc = "Lucban";
                cout<<"     Welcome "<<user<<"!\n"<<endl;
                cout<<"      Shop information"<<endl;
                cout<<"      Shop Name:      "<<shopName<<endl;
                cout<<"      Cellphone No.:  "<<shopContact<<endl;
                cout<<"      Shop Location:  "<<shopLoc<<endl;
                cout<<"||==============================================||"<<endl;
                cout<<"     Admin Functions: \n"<<endl;
                cout<<"      [1] Shop Information Section\n";
                cout<<"      [2] Product Section\n";
                cout<<"      [3] Order Section\n";
                cout<<"      [4] Exit/Logout\n"<<endl;
                cout<<"    Enter your choice: ";
                cin>>choice;
                cout<<"||==============================================||"<<endl;

                    switch (choice){ //let user choose what he wants to do
                        case 1:
                            cout<<"    Edit Shop Information\n"<<endl;
                            cout<<"    Shop Name:     ";
                            cin>>shopName;
                            cout<<"    Cellphone No.: ";
                            cin>>shopContact;
                            cout<<"    Shop Location: ";
                            cin>>shopLoc;
                            cout<<endl;
                            cout<<"    Do you want to apply this changes? [1]Y/ [2]N: ";
                            cin>>ladieschoice;
                            if(ladieschoice == 1){
                                cout<<"||==============================================||"<<endl;
                                cout<<"  Shop information have been successfuly changed "<<endl;
                                cout<<"||==============================================||"<<endl;
                                cout<<"    To View Changes "<<system("pause")<<endl;//pause and runs the program when hit by a key
                                cout<<"||==============================================||"<<endl;
                                cout<<"      New Shop Information"<<endl;
                                cout<<"      Shop Name:          "<<shopName<<endl;
                                cout<<"      Cellphone No.:      "<<shopContact<<endl;
                                cout<<"      Shop Location:      "<<shopLoc<<endl;
                                cout<<"||==============================================||\n";
                            }
                            else if(ladieschoice == 2){ 
                                /*buffer cin.ignore && cin.clear can be used to clear 
                                and ignore changes from the previous input for a while 
                                still need to assigned something so it will revert back 
                                to the original information.*/
                                shopName = "Not my nut"; 
                                shopContact = "09123456900";
                                shopLoc = "Lucban";
                                cout<<"||==============================================||"<<endl;
                                cout<<"        Information Unsuccessfuly Changed       "<<endl;
                                cout<<"||==============================================||"<<endl;
                                cout<<"      Shop information"<<endl;
                                cout<<"      Shop Name:      "<<shopName<<endl;
                                cout<<"      Cellphone No.:  "<<shopContact<<endl;
                                cout<<"      Shop Location:  "<<shopLoc<<endl;
                                cout<<"||==============================================||"<<endl;
                            }
                            else{
                                cout<<endl;
                                cout<<"    Invalid Input!";
                                cout<<"||==============================================||\n";
                            }
                        break;
                        case 2:
                            cout<<"    View/Edit Products";
                          
                        break;
                        case 3:
                        break;
                        case 4:
                            return main(); //rerun the program back to the beginning
                            break;
                        default:
                            cout<<endl;
                            cout<<"    Invalid Input!";
                            cout<<"||==============================================||\n";
                            break;
                    } 
            }
            else{
                cout<<"    Incorrect input \n    Please try again\n";
                trial--;
                if(trial == 0){
                    cout<<"    Program Ended due to multiple login attemps"<<endl;
                    cout<<"||==============================================||\n";
                }
            }
    }while(!islogin && trial != 0); //runs the program 3 times if inputs are incorrect.

    return 0;
}