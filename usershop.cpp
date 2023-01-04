#include <iostream>
using namespace std;

int main(){
	string shopName, shopContact, shopLoc, email, address, product1, product2, product3, product4, yourName, contact, reason;
	int option, quantity1,quantity2,quantity3,quantity4, price1, price2, price3, price4, temptotal, modeP;
	int choice, action;
	string 	uiMessage = "      Where the best nuts you'll ever taste!\n      Coconut may be called a nut but this  \n      delicious nut is not a nut!\n\n     P.S So please stop asking if we have one!";
	bool isrun = false, isdata = false;
	product1 = "Cashew Nuts"; //I assigned variables which is constant for the moment
    product2 = "Walnuts";	//data inserted are fixed but you can insert anything
   	product3 = "Pistacio";	//but it will not revert the changes you apply
    product4 = "Locan Nuts"; //rather prints these fixed data if you hit view products.
    price1 = 25, price2 = 30, price3 = 35, price4 = 15;
	shopName = "Not My NUT";
	shopContact = "09123456988";
	shopLoc = "Lucban, Quezon";
	email = "Deenznut@gmail.com";
	cout<<"||==============================================||"<<endl;
    cout<<"    Enter your Full Name: ";
	getline(cin>>ws, yourName);
	cout<<"||==============================================||"<<endl;
	cout<<"            Welcome to Not My Nut Shop    \n||==============================================||"<<endl;
	cout<<uiMessage<<endl;
	cout<<"||==============================================||"<<endl;
    cout<<"      Shop information"<<endl;
    cout<<"      Shop Name:      "<<shopName<<endl;
    cout<<"      Cellphone No.:  "<<shopContact<<endl;
    cout<<"      Shop Location:  "<<shopLoc<<endl;
    cout<<"      Email:          "<<email<<endl;
	cout<<"||==============================================||"<<endl;
	cout<<"    Welcome "<<yourName<<"!"<<endl;
	cout<<"||==============================================||"<<endl;
	do{	 //run the program inside after each selected function is finished until user inputs 0 then it will end.
		cout<<"    User Funtions: \n"<<endl;
		cout<<"      [1] View Products\n      [2] Order Now\n      [3] View Order\n      [0] Exit\n"<<endl;
		cout<<"    Enter your choice: "; 
		cin>>option;
		cout<<endl;
		cout<<"||==============================================||"<<endl;
			switch(option){ // let user decide where to go
				case 1:
                	cout<<"                  View Products                   "<<endl;
					cout<<"||==============================================||"<<endl;
					cout<<"     Product      Prices\n"<<endl;
					cout<<"     "<<product1<<"    "<<price1<<endl;
					cout<<"     "<<product2<<"        "<<price2<<endl;
					cout<<"     "<<product3<<"       "<<price3<<endl;
					cout<<"     "<<product4<<"     "<<price4<<endl;
					cout<<"||==============================================||"<<endl;
					break;
				case 2:
					cout<<"                    Order Now                     "<<endl;
					cout<<"||==============================================||"<<endl;
					cout<<"\n  As NNN approaches we are offering 20% discount"<<endl;
					cout<<"  if you win our contest show your Nut Challenge"<<endl;
					cout<<"  Join Now! and have a great day shopping.\n"<<endl;
					cout<<"||==============================================||"<<endl;
					cout<<"     Order\n"<<endl;
					cout<<"     Products       Prices         Quantity"<<endl;
					for(int i = 0; i<4; i++){ //loop the product, price in Order as well its quantity so user can input the quantity he wants to product 1-4 as well compute the total
											//price he gets when he inputs the quantity
						if(i==0){
							cout<<"     "<<product1<<"      "<<price1<<"              ";
							cin>>quantity1;
							temptotal += (price1*quantity1);
						}
						if(i==1){
							cout<<"     "<<product2<<"          "<<price2<<"              ";
							cin>>quantity2;
							temptotal += (price2*quantity2);
						}
						if(i==2){
							cout<<"     "<<product3<<"         "<<price3<<"              ";
							cin>>quantity3;
							temptotal += (price3*quantity3);
						}
						if(i==3){
							cout<<"     "<<product4<<"       "<<price4<<"              ";
							cin>>quantity4;
							temptotal += (price4*quantity4);
						}
					}
					cout<<"\n  want to check out these items? [1] Y [2] N: ";
					cin>>choice;
					cout<<"||==============================================||"<<endl;
					if(choice == 1 && isdata == false){ //if there is no data he can enter one since the condition is set that it must not have data first to add order
						cout<<"    Please provide necessary information: \n"<<endl;
						cout<<"    Customer Name: "<<yourName<<endl;
						cout<<"    Contact No.:   "<<contact;
						cin>>contact;
						cout<<"    Address:       "<<address;
						getline(cin>>ws, address);
						cout<<"    Mode of Payment [1] Gcash [2] COD: ";
						cin>>modeP;
						isdata = true;
							if(modeP == 1){ //user mode of payment then prints the summary
								cout<<"\n||==============================================||"<<endl;
								cout<<"    Send your payment to this number: "<<shopContact<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"    order Request have been sent to the seller!"<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"              Summary of your order:              "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"    Customer Name: "<<yourName<<endl;
								cout<<"    Contact No.:   "<<contact;
								cout<<"\n    Address:       "<<address<<endl;
								cout<<"    Mode of Payment: Gcash\n"<<endl;
								cout<<"     Products       Prices         Quantity"<<endl;
								cout<<"     "<<product1<<"      "<<price1<<"              "<<quantity1<<endl;
								cout<<"     "<<product2<<"          "<<price2<<"              "<<quantity2<<endl;
								cout<<"     "<<product3<<"         "<<price3<<"              "<<quantity3<<endl;
								cout<<"     "<<product4<<"       "<<price4<<"              "<<quantity4<<endl;
								cout<<" ________________________________________________"<<endl;
								cout<<"      Total Price:   P"<<price1+price2+price3+price4<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"     Thank you for shopping with Not My Nut!      "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"       ";
								system("pause");
								cout<<"||==============================================||"<<endl;
							}
							else if(modeP == 2){
								cout<<"\n||==============================================||"<<endl;
								cout<<"    Please pay exact amount upon delivery!      "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"    Order Request have been sent to the seller!"<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"              Summary of your order:              "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"    Customer Name: "<<yourName<<endl;
								cout<<"    Contact No.:   "<<contact;
								cout<<"\n    Address:       "<<address<<endl;
								cout<<"    Mode of Payment: COD\n"<<endl;
								cout<<"     Products       Prices         Quantity"<<endl;
								cout<<"     "<<product1<<"      "<<price1<<"              "<<quantity1<<endl;
								cout<<"     "<<product2<<"          "<<price2<<"              "<<quantity2<<endl;
								cout<<"     "<<product3<<"         "<<price3<<"              "<<quantity3<<endl;
								cout<<"     "<<product4<<"       "<<price4<<"              "<<quantity4<<endl;
								cout<<" ________________________________________________"<<endl;
								cout<<"      Total Price:   P"<<price1+price2+price3+price4<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"     Thank you for shopping with Not My Nut!      "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"       ";
								system("pause");
								cout<<"||==============================================||"<<endl;
							}
					}
					else if(choice == 2){ //if cancelled the data will be set to false then he/she cannot accessed view order
							isdata = false;
							quantity1 = 0, quantity2 = 0, quantity3 = 0, quantity4 = 0; //all inserted data will reverted to 0 as reset
							temptotal = 0;
							cout<<"            Order have been cancelled!            "<<endl;
							cout<<"||==============================================||"<<endl;
					}
					else{
						cout<<"                 Invalid User Input"<<endl;
					}
					break;
				case 3:
					cout<<"                    View Orders                    "<<endl;
					cout<<"||==============================================||"<<endl;
					if(isdata == false){ //if there is no data it will print message no orders
						cout<<"                  No Orders Yet!                  "<<endl;
						cout<<"||==============================================||"<<endl;
						cout<<"       ";
						system("pause");
						cout<<"||==============================================||"<<endl;
					}
					else if(isdata == true){ // if there is data then print the Order request summary
						cout<<"    Status:          Waiting for approval"<<endl;
						cout<<"    Customer Name:   "<<yourName<<endl;
						cout<<"    Contact No.:     "<<contact<<endl;;
						cout<<"    Address:         "<<address<<endl;
						cout<<"    Mode of Payment: Gcash\n"<<endl;;
						cout<<"     Products       Prices         Quantity"<<endl;
						cout<<"     "<<product1<<"      "<<price1<<"              "<<quantity1<<endl;
						cout<<"     "<<product2<<"          "<<price2<<"              "<<quantity2<<endl;
						cout<<"     "<<product3<<"         "<<price3<<"              "<<quantity3<<endl;
						cout<<"     "<<product4<<"       "<<price4<<"              "<<quantity4<<endl;
						cout<<" ________________________________________________"<<endl;
						cout<<"      Total Price:   P"<<price1+price2+price3+price4<<endl;
						cout<<"||==============================================||"<<endl;
						cout<<"    Actions [1] Cancel Order [2] Exit: ";
						cin>>action;
							if(action == 1){ //if cancel Order it updates quantity 1-4 to 0 and temptotal which funtion also as a reset button
								quantity1 = 0, quantity2 = 0, quantity3 = 0, quantity4 = 0;
								temptotal = 0;
								isdata = false;
								cout<<"||==============================================||"<<endl;
								cout<<"            Order have been cancelled!            "<<endl;
								cout<<"||==============================================||"<<endl;
								cout<<"    Reason: \n"<<endl;
								cout<<"      ";
								getline(cin>>ws, reason);
								cout<<"||==============================================||"<<endl;
							}
							else if(action == 2){
								cout<<"||==============================================||"<<endl; 
							}
							else{
								cout<<"                 Invalid User Input"<<endl;
								cout<<"||==============================================||"<<endl; 
							}
							cout<<"       ";
							system("pause");
							cout<<"||==============================================||"<<endl; 
					}
					break;
				case 0:
					cout<<"    Program terminated... \n    /or ";
                    system("pause");
                    return main(); //rerun the program from the beginning.
					break;
				default:
					cout<<"                 Invalid User Input"<<endl;
					break;
			}
	}while(!isrun && option !=0);
	return 0;
}
