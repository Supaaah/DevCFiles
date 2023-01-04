#include <iostream>
using namespace std;
int main(){
	string user, pass, shopName, shopContact, shopLoc, email, product1,product2,product3,product4, uiMessage;
	string ap = "Approved", ap1 = "Approved", ap2 = "Approved", ap3 = "Approved";
	int option, ladieschoice, ladieschoice1, option1, prodreg, option2, option3, aprv;
	double price1, price2, price3,price4;
	bool islogin = false, isdata = false, isapproved = false;
	int trial = 3;
	uiMessage = "      Where the best nuts you'll ever taste!\n      Coconut may be called a nut but this  \n      delicious nut is not a nut!\n\n     P.S So please stop asking if we have one!";
	do{
		cout<<"||==============================================||"<<endl;
    	cout<<"|| Welcome to Not My Nut Online Shopping System ||"<<endl;
    	cout<<"||==============================================||"<<endl;
		cout<<"    User: "; //inputs username and password for extra security.
        cin>>user;
        cout<<"    Pass: "; 
        cin>>pass;
        cout<<"||==============================================||"<<endl;
        	if(user == "admin" && pass == "admin"){ //checks if the inputs are the admin's account if not it will loop until too many attemps message appear
                islogin = true; //updates islogin that counters the condition below so it will not run infinitely
                cout<<"\t\tWelcome "<<user<<"!\n";
                cout<<"||==============================================||"<<endl;
                { 
				shopName = "Not my NUT";
				shopContact = "09123456988";
				shopLoc = "Lucban, Quezon";
				email = "Deenznut@gmail.com";
                cout<<"      Shop information"<<endl;
                cout<<"      Shop Name:      "<<shopName<<endl;
               	cout<<"      Cellphone No.:  "<<shopContact<<endl;
                cout<<"      Shop Location:  "<<shopLoc<<endl;
                cout<<"      Email: "<<email<<endl;
				}
				do{ /*let the program loop this after each function in admin commands ended and only end this where user hit number 0
					since the condition is set where it will stop at that point*/
					cout<<"||==============================================||"<<endl;
                	cout<<"     Admin Functions: \n"<<endl;
                	cout<<"      [1] Edit Shop Information\n";
                	cout<<"      [2] Product Section\n";
                	cout<<"      [3] Edit UI Message\n";
					cout<<"      [4] Order Request\n"; 
                	cout<<"      [0] Exit/Logout\n"<<endl;
                	cout<<"      Enter your choice: ";
                	cin>>option;
                	cout<<"||==============================================||"<<endl;
                	
                		switch (option){ //let user choose what he wants to do
                        case 1:	
							cout<<"    Edit Shop Information\n";
							cout<<"    Shop Name:     ";
                            getline(cin>>ws, shopName); //it reads white spaces in string.
                            cout<<"    Cellphone No.: ";
                            cin>>shopContact;
                            cout<<"    Shop Location: ";
                            getline(cin>>ws, shopLoc);
							cout<<"    Email: ";
                            cin>>email;  
                            cout<<endl;
                            cout<<"    Do you want to apply this changes? [1]Y/ [2]N: "; //verify the admin if he wants to continue
                            cin>>ladieschoice;
                            	if(ladieschoice == 1){
                                	cout<<"||==============================================||"<<endl;
                                	cout<<"  Shop information have been successfuly changed "<<endl;
                                	cout<<"||==============================================||"<<endl;
									cout<<"      Shop information"<<endl;
                					cout<<"      Shop Name:      "<<shopName<<endl;
               						cout<<"      Cellphone No.:  "<<shopContact<<endl;
                					cout<<"      Shop Location:  "<<shopLoc<<endl;
                					cout<<"      Email:          "<<email<<endl;
                					cout<<"||==============================================||"<<endl;
                					cout<<"    To Return ";
									system("pause");//pause and runs the program when hit by any key added because it looks nice
                            		}
                            	else if(ladieschoice == 2){ 
                                	cout<<"||==============================================||"<<endl;
                               		cout<<"        Information Unsuccessfuly Changed       "<<endl;
									cout<<"||==============================================||"<<endl;
									//I assigned variables which is constant for the moment
                                	//data inserted are fixed but you can insert anything
                                	//but it will not revert the changes you apply
                                	//rather prints these fixed data if you hit view products.
									shopName = "Not my NUT"; 
									shopContact = "09123456988";
									shopLoc = "Lucban, Quezon";
									email = "Deeznut@gmail.com";
                					cout<<"      Shop information"<<endl;
                					cout<<"      Shop Name:      "<<shopName<<endl;
               						cout<<"      Cellphone No.:  "<<shopContact<<endl;
                					cout<<"      Shop Location:  "<<shopLoc<<endl;
                					cout<<"      Email:          "<<email<<endl;
									cout<<"||==============================================||"<<endl;
                                	cout<<"    To Return ";
									system("pause");		
                            		}
                            	else{
                               		cout<<endl;
									cout<<"                 Invalid User Input"<<endl;

                                	cout<<"||==============================================||\n";
                           			}		
                			break;
                		case 2:
							cout<<"    Product Section\n"<<endl;
							cout<<"    [1] Add product\n    [2] Edit product price\n    [3] View products\n"<<endl;
							cout<<"      Enter your choice: ";
                			cin>>option1;
                			cout<<"||==============================================||"<<endl;
                			if(option1==1){
                				if(isdata == false){ //will run since bool isdata is set to false
                				cout<<"    Add product\n"<<endl;
                				cout<<"  Enter how many product you want to register: ";
                				cin>>prodreg;
                				cout<<"\n";
                				for(int i = 0; i<prodreg; i++){ //let admin to enter data to each product and prices in order
                					if(i == 0){
                						cout<<"    Enter product name: ";
                						getline(cin>>ws, product1);
                						cout<<"    Enter product price: ";
                						cin>>price1;
									}
									if(i == 1){
                						cout<<"    Enter product name: ";
                						getline(cin>>ws, product2);
                						cout<<"    Enter product price: ";
                						cin>>price2;
									}
									if(i == 2){
                						cout<<"    Enter product name: ";
                						getline(cin>>ws, product3);
                						cout<<"    Enter product price: ";
                						cin>>price3;
									}
									if(i == 3){
                						cout<<"    Enter product name: ";
                						getline(cin>>ws, product4);
                						cout<<"    Enter product price: ";
                						cin>>price4;
									}
									cout<<endl;
								}
								isdata = true; //updates the bool isdata to true so we can say that there is data that can be edit/view.
								cout<<"||==============================================||"<<endl;
								cout<<"    Products have been successfuly registered     "<<endl;
								}
                				else{ //prevents updating the previous data and mix things up
                					cout<<"   Product data storage is full at the moment."<<endl;
								}	
							}
							else if(option1==2){
								if(isdata == true){ //cannot be accessed if there is no data that's what the condition do
									cout<<"    Edit product price\n"<<endl;
									cout<<"||==============================================||"<<endl; 
									cout<<"    Enter new price: "<<endl;
									for(int i = 0; i<4;i++){ //prints the fixed products by Status: and can update/edit its prices.
										if(i==0){
											cout<<"     "<<product1<<":            \tP";
											cin>>price1;
											}
										if(i==1){
											cout<<"     "<<product2<<":               \tP";
											cin>>price2;
											}
										if(i==2){
											cout<<"     "<<product3<<":               \tP";
											cin>>price3;
											}
										if(i==3){
											cout<<"     "<<product4<<":             \tP";
											cin>>price4;
											}
										cout<<endl;
										}
									cout<<"    Do you want to apply this changes? [1]Y/ [2]N: "; //verify the admin if he wants to continue the changes
                            		cin>>ladieschoice1;
                            			if(ladieschoice1 == 1){	// tells someone that it is successfully changed
											cout<<"||==============================================||"<<endl;
                                			cout<<"   Product Prices have been successfuly changed "<<endl;
											}
										else if(ladieschoice1==2){ //reverted back to the way it was
											cout<<"||==============================================||"<<endl;
                                			cout<<"      Product Prices Unsuccessfuly changed        "<<endl;
                                			product1 = "Cashew Nuts"; //I assigned variables which is constant for the moment
                                			product2 = "Walnuts";	//data inserted are fixed but you can insert anything
                                			product3 = "Pistacio";	//but it will not revert the changes you apply
                                			product4 = "Local Nuts"; //rather prints these fixed data if you hit view products.
                                			price1 = 25, price2 = 30, price3 = 35, price4 = 15;
										}
									}
									else{ //tells there is no data and needs to insert some first.
										cout<<"    Product section data storage is empty."<<endl;
									}	
								}
							if(option1 == 3){
								if(isdata == true){ //test whether there is data inserted, then prints all data inserted.
									cout<<"    View products"<<endl;
									cout<<"||==============================================||"<<endl;
									cout<<"     "<<product1<<":            \tP"<<price1<<endl;
									cout<<"     "<<product2<<":               \tP"<<price2<<endl;
									cout<<"     "<<product3<<":               \tP"<<price3<<endl;
									cout<<"     "<<product4<<":             \tP"<<price4<<endl;
								}
								else{
									cout<<"    Product section data storage is empty."<<endl;
								}
							}
							
                			break;
                		case 3:
                			cout<<"\t\tEdit UI Message\n";
							cout<<"||==============================================||"<<endl;
							cout<<"           Welcome To Not My Nut Shop    \n||==============================================||"<<endl;
							cout<<uiMessage<<endl;
							cout<<"||==============================================||"<<endl;
							cout<<"    Input new UI Message: \n"<<endl;
							cout<<"    ";                           
							getline(cin>>ws, uiMessage);
                            cout<<endl;
							cout<<"    Do you want to apply this changes? [1]Y/ [2]N: ";
							cin>>option2; 
                            	if(option2==1){ //updates and prints new ui message inserted
                            		cout<<"||==============================================||"<<endl;
                                	cout<<"    UI message have been successfuly changed "<<endl;
                                	cout<<"||==============================================||"<<endl;
									cout<<"    "<<uiMessage<<endl;
									cout<<"||==============================================||"<<endl;
									cout<<"    To Return ";//pause and runs the program when hit by a key
									system("pause");
									
								}
								else if(option2==2){ //revert anything to the old ui message.
									uiMessage = "      Where the best nuts you'll ever taste!\n      Coconut may be called a nut but this  \n      delicious nut is not a nut!\n\n     P.S So please stop asking if we have one!";
									cout<<"||==============================================||"<<endl;
                                	cout<<"        UI message unsuccessfuly changed          "<<endl;
                                	cout<<"||==============================================||"<<endl;
                                	cout<<"    To Return ";//pause and runs the program when hit by a key
									system("pause");
								}
								else{
									cout<<endl;
									cout<<"                 Invalid User Input"<<endl;
							 }
                			break;
                		case 4:
                			cout<<"\t\tOrder Request\n";
							cout<<"||==============================================||"<<endl;
							cout<<"    [1] View Order Request\n    [2] Approve/Cancel Request\n"<<endl;
							cout<<"    Enter your choice: ";
                			cin>>option3;
                				if(option3 == 1){
                					cout<<"||==============================================||"<<endl;
                					cout<<"               View Order Request                 "<<endl;
									cout<<"||==============================================||"<<endl;
									if(isdata !=false){
										if(isapproved == false){ //prints the Status: request sincec isapproved was set at false by default
										for(int i = 1; i<5; i++){ //prints the Status: request by order
											if(i == 1){
												cout<<"      Status:           Waiting for approval"<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Vladimir Putin"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Moscow, Russia"<<endl;
												cout<<"      Mode of payment:  GCASH"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<((price1*3)+(price2*2)+price3+price4)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 2){
												cout<<"      Status:           Waiting for approval"<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Joe Biden"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Washington, USA"<<endl;
												cout<<"      Mode of payment:  Paypal"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              5"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              3"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:    P"<<((price1*5)+(price2*2)+(price3*3)+price4)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 3){
												cout<<"      Status:           Waiting for approval"<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Xi Jinping"<<endl;
												cout<<"      Contact:          0615195368"<<endl;
												cout<<"      Address:          Beijing, China"<<endl;
												cout<<"      Mode of payment:  COD"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              2"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              2"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              2"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*2)+(price2*2)+(price3*2)+(price4*2)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 4){
												cout<<"      Status:           Waiting for approval"<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Volodymyr Zelenskyy"<<endl;
												cout<<"      Contact:          00125197844"<<endl;
												cout<<"      Address:          Kyiv, Ukraine"<<endl;
												cout<<"      Mode of payment:  COD"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              0"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*3)+price2+price3+(price4*1)<<endl;
											}
										}
									}
									else if(isapproved == true){ //after admin approved request it will show whether the user's Status: is approved or not
											for(int i = 1; i<5; i++){ //prints inserted output by order
											if(i == 1){
												cout<<"      Status: "<<ap<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Vladimir Putin"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Moscow, Russia"<<endl;
												cout<<"      Mode of payment:  Gcash"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<((price1*3)+(price2*2)+price3+price4)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 2){
												cout<<"      Status: "<<ap1<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Joe Biden"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Washington, USA"<<endl;
												cout<<"      Mode of payment:  Paypal"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              5"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              3"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:    P"<<((price1*5)+(price2*2)+(price3*3)+price4)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 3){
												cout<<"      Status: "<<ap2<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Xi Jinping"<<endl;
												cout<<"      Contact:          0615195368"<<endl;
												cout<<"      Address:          Beijing, China"<<endl;
												cout<<"      Mode of payment:  Bank"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              2"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              2"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              2"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*2)+(price2*2)+(price3*2)+(price4*2)<<endl;
												cout<<"||==============================================||"<<endl;
											}
											if(i == 4){
												cout<<"      Status: "<<ap3<<endl;
												cout<<"    "<<i<<"."<< "Customer Name:    Volodymyr Zelenskyy"<<endl;
												cout<<"      Contact:          00125197844"<<endl;
												cout<<"      Address:          Kyiv, Ukraine"<<endl;
												cout<<"      Mode of payment:  COD"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              0"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*3)+price2+price3+(price4*1)<<endl;
												}	
											}
										}	
									}
								}
								else if(option3 == 2){
									cout<<"||==============================================||"<<endl;
									cout<<"    Approve/Cancel Order Request"<<endl;
									if(isdata!=false){
									cout<<"||==============================================||"<<endl;
									for(int i = 1; i<5; i++){ //prints the fixed Status: request by order
										if(i == 1){
												cout<<"    "<<i<<"."<< "Customer Name:    Vladimir Putin"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Moscow, Russia"<<endl;
												cout<<"      Mode of payment:  Gcash"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<((price1*3)+(price2*2)+price3+price4)<<endl;
												cout<<"||==============================================||"<<endl;
												cout<<"    [1] Approved\n    [2] Declined\n";
												cout<<"    Enter your choice: ";
												cin>>aprv;
													if(aprv == 1){ //let admin decide to approve or not and output whatever inside that condition when true
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Information and reference number are sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else if(aprv == 2){
														ap = "Declined";
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Disapproval of Order message have been sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else{
														cout<<"                 Invalid User Input"<<endl;
													}
											} 
											if(i == 2){
												cout<<"    "<<i<<"."<< "Customer Name:    Joe Biden"<<endl;
												cout<<"      Contact:          01007195269"<<endl;
												cout<<"      Address:          Washington, USA"<<endl;
												cout<<"      Mode of payment:  Gcash"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              5"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              3"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:    P"<<((price1*5)+(price2*2)+(price3*3)+price4)<<endl;
												cout<<"||==============================================||"<<endl;
												cout<<"    [1] Approved\n    [2] Declined\n";
												cout<<"    Enter your choice: ";
												cin>>aprv;
													if(aprv == 1){
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap1<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Information and reference number are sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else if(aprv == 2){
														ap1 = "Declined";
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap1<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Disapproval of Order message have been sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else{
														cout<<"                 Invalid User Input"<<endl;
													}
											}
											if(i == 3){
												cout<<"    "<<i<<"."<< "Customer Name:    Xi Jinping"<<endl;
												cout<<"      Contact:          0615195368"<<endl;
												cout<<"      Address:          Beijing, China"<<endl;
												cout<<"      Mode of payment:  Gcash"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              2"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              2"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              2"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              2"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*2)+(price2*2)+(price3*2)+(price4*2)<<endl;
												cout<<"||==============================================||"<<endl;
												cout<<"    [1] Approved\n    [2] Declined\n";
												cout<<"    Enter your choice: ";
												cin>>aprv;
													if(aprv == 1){
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap2<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Information and reference number are sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else if(aprv == 2){
														ap2 = "Declined";
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap2<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Disapproval of Order message have been sent.\n";
														cout<<"||==============================================||"<<endl;
													}
													else{
														cout<<"                 Invalid User Input"<<endl;
													}
											}
											if(i == 4){
												cout<<"    "<<i<<"."<< "Customer Name:    Volodymyr Zelenskyy"<<endl;
												cout<<"      Contact:          00125197844"<<endl;
												cout<<"      Address:          Kyiv, Ukraine"<<endl;
												cout<<"      Mode of payment:  COD"<<endl;
												cout<<"      Orders:\n"<<endl;
												cout<<"      Products       Prices         Quantity"<<endl;
												cout<<"      "<<product1<<"      "<<price1<<"              3"<<endl;
												cout<<"      "<<product2<<"          "<<price2<<"              0"<<endl;
												cout<<"      "<<product3<<"         "<<price3<<"              0"<<endl;
												cout<<"      "<<product4<<"       "<<price4<<"              1"<<endl;
												cout<<" ________________________________________________"<<endl;
												cout<<"      Total Price:     P"<<(price1*3)+price2+price3+(price4*1)<<endl;
												cout<<"||==============================================||"<<endl;
												cout<<"    [1] Approved\n    [2] Declined\n";
												cout<<"    Enter your choice: ";
												cin>>aprv;
													if(aprv == 1){
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap3<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Information and reference number was sent.\n";
													}
													else if(aprv == 2){
														ap3 = "Declined";
														cout<<"||==============================================||"<<endl;
														cout<<"    Status: "<<ap3<<"!"<<endl;	
														cout<<"    (System is sending information to the buyer...)\n";
														cout<<"    Disapproval of Order message have been sent.\n";
													}
													else{
														cout<<"                 Invalid User Input"<<endl;
													}
											}	
										}
										isapproved = true; //sets the isapproved to true and will have accessed to view orders but with approval at the top
									}
									
								}
								else{
									cout<<"||==============================================||"<<endl;
									cout<<"    Invalid User Input/Does not have data."<<endl;
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
				}while(option!=0); // stop the do while loop when hit 0 ends the admin function and revert it back to the outer do while loop
		}
		else{
            cout<<"    Incorrect input \n    Please try again\n";
            trial--; //decrement trial until reach 0 where message appear
            	if(trial == 0){
                    cout<<"    Program Ended due to multiple login attemps"<<endl;
                	cout<<"||==============================================||\n";
            }
        }		
	}while(!islogin && trial !=0); 
	return 0;	
	
}

