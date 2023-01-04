/*Determines the best buy or the minimum price of each product in different restaurants 
in Lucban, Quezon especially between Mustiola's, Buddy's and Patakim's based on 
the given input of the user through ratings,budget, time and by person.
*/
#include <iostream>
using namespace std;
string pancitResto(int person, double budget,double rating, double regPancit1, double regPancit2, double regPancit3, double bilPancit1, double bilPancit2, double bilPancit3);
/*Precondition: person, budget, rating  are set as the user's preference for a product and 
restaurant and regPancit1-3 and bilPancit1-3 are used to store the prices for each designated 
product and to compute  for the best buy for that specific person, budget and rating.
Postcondition: returns the recommended pancit based from the user's preference*/
string isShop(int H, int M, string minShopP);
/*Precondition: H and M variables are used to store the user's inputed time 
minShopP to store the returned value in pancitRestoand used them to compare 
to he various condition set in the program.
PostCondition: returns wheter the shop is closed or open based from minShopP returned value*/
string pataResto(int person, double budget, double rating, double pata1, double pata2, double pata3, double pata2L);
/*Precondition: person, budget, rating  are set as the user's preference for a product 
and restaurant and used to store values for each samely named variables and pata1-3 are 
used to store the prices for each designated product and to compute for the best buy for 
that specific person, budget and rating.
Postcondition: returns the recommended pata based from the user's preference*/
string isShop1(int H, int M, string pataMin);
/*Precondition: H and M variables are used to store the user's inputed time 
Patamin to store the returned value in pancitRestoand used them to compare 
to he various condition set in the program.
PostCondition: returns wheter the shop is closed or open based from patamin returned value*/
void userInput(double &budget, int &person, int &H,int&M, double &rating, int &option, string prodname1, string prodname2);
/*Precondition: ask the user to input budget, person, H, M, rating, option and display prodname1 and prodname2
Postcondition: the values inserted by the user in budget, person, H, M, rating and option have been set to each variable
*/
void userOption1(int person, double budget, double rating,double regPancit1,double regPancit2,double regPancit3,double bilPancit1,double bilPancit2,
double bilPancit3, string &minShopP, string &shopStat,int H, int M);
/*Precondition: Used to call the variables declared and assigned in main and different function and used them to compute and compare for the 
best buy pancit hab hab in Lucban, Quezon and compare the time set by the user with the Opening/Closing time of the restaurant
Postcondition: returns the recommended shop to buy pancit habhab and returns whether that shop is closed or open.
*/
void printOption1(string minShopP, string shopStat);
/*Precondition: minShop tells the recommended shop to buy Pancit habhab
shopStat tells whether that shop is closed or open
Postcondition: It display the minShopP and shopStat to the screen
*/
void userOption2(int person, double budget, double rating, double pata1, double pata2, double pata2L, double pata3, string &pataMin, string &shopStat1,int H,int M);
/*Precondition: Used to call the variables declared and assigned in main and different function and used them to compute and compare for the 
best buy Crispy Pata in Lucban, Quezon and compare the time set by the user with the Opening/Closing time of the restaurant
Postcondition: returns the recommended shop to buy Crispy Pata and returns whether that shop is closed or open.
*/
void printOption2(string pataMin, string shopStat1);
/*Precondition: minShop tells the recommended shop to buy Pancit habhab
shopStat tells whether that shop is closed or open
Postcondition: It display the pataMin and shopStat1 to the screen
*/
void endProgram();
/*Postcondition: display message program terminated or rerun through press to continue
*/
void invalidInput();
/*Postcondition: display messsage Invalid Input
*/
string pancitResto(int person, double budget,double rating, double regPancit1, double regPancit2, double regPancit3, double bilPancit1, double bilPancit2, double bilPancit3){
	double minimum; 
	string shop;
    if(person>0 && person<4){
        if(rating>=3.5 && rating <=4){
            	minimum = min(min(regPancit1,regPancit3),min(bilPancit1,bilPancit3));
                if(budget >= minimum){
				    if(minimum == regPancit1){
					    shop = "    Mustiola's Regular Pancit Habhab\n    is the best choice for you!";
					    return shop;
				    }
				    else if(minimum == regPancit3){
                        shop = "    Patakim's Regular Pancit Habhab\n    is the best choice for you!";
                        return shop;
				    }
				    if(minimum == bilPancit1){
					    shop = "    Mustiola's Bilao Pancit Habhab\n    is the best choice for you!";
					    return shop;
				    }
				    else if(minimum == bilPancit3){
				    	shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					}
			    }
			    else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
        }
        else if(rating >= 4 && rating <=4.5){
            minimum = min(min(regPancit2,regPancit3),min(bilPancit2,bilPancit3));
            if(budget >= minimum){
				    if(minimum == regPancit2){
					    shop = "    Buddy's Regular Pancit Habhab\n    is the best choice for you!";
					    return shop;
				    }
				    else if(minimum == regPancit3){
                        shop = "    Patakim's Regular Pancit Habhab\n    isthe best choice for you!";
                        return shop;
					}
					if(minimum == bilPancit2){
					    shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
					    return shop;
				    }
				    else if(minimum == bilPancit3){
				    	shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					}
			    }
			    else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
        }
        if(rating >= 4.5){
            minimum = min(regPancit2,bilPancit2);
             if(budget >= minimum){
                if(minimum == regPancit2){
                	shop = "    Buddy's Regular Pancit Habhab\n    is the best choice for you!";
					return shop;
				}
				else if(minimum == bilPancit2){
					shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
				}
             }
             else{
             	shop = "Can't find a store that suits your budget!";
				return shop;
			 }
        }
        else{
            shop = "Can't find a store that suits your ratings";
            return shop;
        }
    }
    if(person>3&&person<7){
       if(rating>=3.5&&rating<=4){
           double newReg1 = regPancit1*2;
           double newReg3 = regPancit3*2;
           
           minimum = min (min(newReg1,newReg3),min(bilPancit1,bilPancit3));
           if(budget >= minimum){
               if(minimum == newReg1){
                    shop = "  2 order of Mustiola's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
               }
            	else if(minimum == newReg3){
                    shop = "  2 order of Patakim's Regular Pancit\n  Habhab the best choice for you!";
				    return shop;
               }
               if(minimum == bilPancit1){
                    shop = "    Mustiola's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
               }
               else if(minimum == bilPancit3){
                    shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
               }
           }
           else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
       }
       else if(rating >= 4 && rating <=4.5){
            double newReg2 = regPancit2*2;
            double newReg3 = regPancit3*2;
            minimum = min (min(newReg2,newReg3),min(bilPancit2,bilPancit3));
            if(budget >= minimum){
               if(minimum == newReg2){
                    shop = "  2 order of Buddy's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
               }
                else if(minimum == newReg3){
                    shop = "  2 order of Patakim's Regular Pancit\n  Habhab the best choice for you!";
				    return shop;
               }
               if(minimum == bilPancit2){
                    shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
               }
               else if(minimum == bilPancit3){
                    shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
               }
           }
           else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
       }
       if(rating>=4.5 && rating <=5.0){
           double newReg2 = regPancit2*2;
           minimum = min(newReg2,bilPancit2);
           if(budget>=minimum){
               if(minimum == newReg2){
                   shop = "  2 order of Buddy's Regular Pancit\n  Habhab the best choice for you!";
                   return shop;
               }
               else if(minimum == bilPancit2){
                   shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
                   return shop;
               }
            }
            else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			} 
       }
       else{
            shop = "Can't find a store that suits your ratings";
            return shop;
        }
   }
    if(person > 6 && person < 12){ 
        if(rating>=3.5 && rating <=4){
        	double newReg1 = regPancit1*3; //2-3 person * 3 9
        	double newReg3 = regPancit3*3;
            minimum = min(min(newReg1,newReg3),min(bilPancit1 ,bilPancit3));
            if(budget>=minimum){
                if(minimum == bilPancit1){
                    shop = "    Mustiola's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
                }
                else if(minimum == bilPancit3){
                    shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
                }
                if(minimum == newReg1){
                	shop = "  3 order of Mustiola's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
				}
				else if(minimum == newReg3){
					shop = "  3 order of Patakim's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
				}
            }
            else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
        }
        else if(rating>=4&&rating<=4.5){
        	double newReg2 = regPancit2*3;
        	double newReg3 = regPancit3*3;
            minimum = min(min(newReg2,newReg3),min(bilPancit2, bilPancit3));
            if(budget>=minimum){
                if(minimum == bilPancit2){
                    shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
                }
                else if(minimum == bilPancit3){
                    shop = "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
                }
                if(minimum == newReg2){
                	shop = "  3 order of Buddy's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
				}
				else if(minimum == newReg3){
					shop = "  3 order of Patakim's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
				}
            }
            else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
        }
        if(rating>=4.5 && rating<=5.0){
        	double newReg2 = regPancit2*3;
            minimum = min(newReg2,bilPancit2);
            if(budget>=minimum){
                if(minimum == bilPancit2){
                    shop = "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!";
					return shop;
                }
                else if(minimum == newReg2){
                	shop = "  3 order of Buddy's Regular Pancit\n  Habhab the best choice for you!";
					return shop;
				}
            }
            else{
				    shop = "Can't find a store that suits your budget!";
				    return shop;
			}
        }
        else{
            shop = "Can't find a store that suits your ratings";
            return shop;
        }
    }
    else{
    	shop = "    Too little/too many to compare";
    	return shop;
	}
}
string isShop(int H, int M, string minShopP){
	string status;
	if(minShopP == "    Mustiola's Regular Pancit Habhab\n    is the best choice for you!" 
		|| "  2 order of Mustiola's Regular Pancit\n  Habhab the best choice for you!"
	 	|| "    Mustiola's Bilao Pancit Habhab\n    is the best choice for you!"
		|| "  3 order of Mustiola's Regular Pancit\n  Habhab the best choice for you!"){
		if(H>=6 && H<=20 && (M>=0&&M<=60)){
			status = "Open";
			return status;
		}
		else{
			status = "Closed";
			return status;
		}
	}
	else if (minShopP == "    Buddy's Regular Pancit Habhab\n    is the best choice for you!"
		||	"  2 order of Buddy's Regular Pancit\n  Habhab the best choice for you!"
	 	|| "    Buddy's Bilao Pancit Habhab\n    is the best choice for you!"
		|| "  3 order of Buddy's Regular Pancit\n  Habhab the best choice for you!"){
		if(H>=9 && H<=19 && (M>=0&&M<=60)){
			status = "Open";
			return status;
		}
		else{
			status = "Closed";
			return status;
		}
	}
	if(minShopP == "    Patakim's Regular Pancit Habhab\n    is the best choice for you!"
		||	"  2 order of Patakim's Regular Pancit\n  Habhab the best choice for you!"
	 	|| "    Patakim's Bilao Pancit Habhab\n    is the best choice for you!"
		|| "  3 order of Patakim's Regular Pancit\n  Habhab the best choice for you!"){
		if(H>=8 && H<=20 && (M>=0&&M<=60)){
			status = "Open";
			return status;
		}
		else{
			status = "Closed";
			return status;
		}
	}
	else{
		status = "Unclear";
		return status;
	}
}
string pataResto(int person, double budget, double rating, double pata1, double pata2, double pata3, double pata2L){
	double minimum1;
	string shope;
	if(person>0&&person<6){//per serving is good for 3-5 persons
		if(rating > 0 && rating<= 4){
			minimum1 = min(pata1,min(pata2,pata3));
			if(budget>=minimum1){
				if(minimum1 == pata1){
					shope = "    Mustiola's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
				else if(minimum1 = pata2){
					shope = "    Buddy's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
				if(minimum1 == pata3){
					shope = "    Patakim's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
			}
			else{
				shope = "Can't find a store that suits your budget!";
				return shope;
			}
		}
		else if(rating>=4 && rating<4.6){
			minimum1 = min(min(pata2,pata2L),pata3);
			if(budget>=minimum1){
				if(minimum1 == pata2){
					shope = "    Buddy's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
				else if(minimum1 == pata3){
					shope ="    Patakim's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
			}
			else{
				shope = "Can't find a store that suits your budget!";
				return shope;
			}
		}
		if(rating>=4.6&&rating<=5.0){
			minimum1 = min(pata2, min(pata2,pata2L));
			if(budget>= minimum1){
				if(minimum1 == pata2){
					shope = "    Buddy's Crispy Pata is\n    the best choice for you!";
					return shope;
				}
				if(minimum1 == pata2L){
					shope = "    Buddy's Large Crispy Pata\n    is the best choice for you!";
					return shope;
				}
			}
			else{
				shope = "Can't find a store that suits your budget!";
				return shope;
			}
		}
		else{
			shope = "Can't find a store that suits your ratings";
            return shope;
		}
	}
	else if(person>5&&person<9){
		if(rating>0&&rating<4.6){
			double newpata1 = pata1*2;
			double newpata3 = pata3*2;
			double newpata2 = pata2*2;
			minimum1 = min(min(newpata1,newpata3), min(newpata2,pata2L));
			if(budget>=minimum1){
				if(minimum1 == newpata1){
					shope = "  2 Orders of Mustiola's Crispy Pata\n  is the best choice for you!";
					return shope;
				}
				else if(minimum1 == newpata2){
					shope = "  2 Orders of Buddy's Crispy Pata\n  is the best choice for you!";
					return shope;
				}
				if(minimum1 == pata2L){
					shope = "    Buddy's Large Crispy Pata\n    is the best choice for you!";
					return shope;
				}
				else if(minimum1 == newpata3){
					shope = "  2 Orders of Patakim's Crispy Pata\n  is the best choice for you!";
					return shope;
				}
			}
			else{
				shope = "Can't find a store that suits your budget!";
				return shope;
			}
		}
		else if(rating>=4.6){	
			double newpata2 = pata2*2;
			minimum1 = min(newpata2,pata2L);
			if(budget>=minimum1){
				if(minimum1 == newpata2){
					shope = "  2 Orders of Buddy's Crispy Pata\n  is the best choice for you!";
					return shope;
				}
				else if(minimum1 == pata2L){
					shope =	"    Buddy's Large Crispy Pata\n    is the best choice for you!";
					return shope;
				}
			}
			else{
				shope = "Cant't find a store that suits your budget!";
				return shope;
			}
		}
		else{
			shope = "Can't find a store that suits your ratings";
            return shope;
		}
	}
	else{
    	shope = "    Too little/too many to compare";
    	return shope;
	}
}
string isShop1(int H, int M, string pataMin){
	string status1;
	if(pataMin == "    Mustiola's Crispy Pata is\n    the best choice for you!"
	|| "  2 Orders of Mustiola's Crispy Pata\n  is the best choice for you!"){
		if(H>=6 && H<=20 && (M>=0&&M<=60)){
			status1 = "Open";
			return status1;
		}
		else{
			status1 = "Closed";
			return status1;
		}
	}
	else if(pataMin == "    Buddy's Crispy Pata is\n    the best choice for you!" 
	|| "    Buddy's Large Crispy Pata\n    is the best choice for you!"
	|| "  2 Orders of Buddy's Crispy Pata\n  is the best choice for you!"){
			if(H>=9 && H<=19 && (M>=0&&M<=60)){
			status1 = "Open";
			return status1;
		}
		else{
			status1 = "Closed";
			return status1;
		}
	}
	if(pataMin == "    Patakim's Crispy Pata is\n    the best choice for you!"
	|| "  2 Orders of Patakim's Crispy Pata\n  is the best choice for you!"){
		if(H>=8 && H<=20 && (M>=0&&M<=60)){
			status1 = "Open";
			return status1;
		}
		else{
			status1 = "Closed";
			return status1;
		}
	}
	else{
		status1 = "Unclear";
		return status1;
	}
}
void userInput(double &budget, int &person, int &H,int&M, double &rating, int &option, string prodname1, string prodname2){ //let the user input budget person hour and rating and the option he wants to go to
		cout<<"||=====================================||"<<endl;
		cout<<"\t\tRestorec"<<endl;
		cout<<"||=====================================||"<<endl;
		cout<<"   Cheap and best food on your budget!   "<<endl;
		cout<<"||=====================================||"<<endl;
		cout<<"  Provide some info so we can\n  recommend you a restaurant later on."<<endl;
		cout<<"||=====================================||"<<endl;
		cout<<"    Budget: P";
		cin>>budget;
		cout<<"    Person:  ";
		cin>>person;
		cout<<"    Time 24H Format (H:M): ";
		cin>>H>>M;
		cout<<"    Resto Raiting (1.0-5.0): ";
		cin>>rating;
		cout<<"||=====================================||"<<endl;
		cout<<"\t\tFOOD LIST"<<endl;
		cout<<"||=====================================||"<<endl;
		cout<<"\t[1] "<<prodname1<<endl;
		cout<<"\t[2] "<<prodname2<<endl; 
		cout<<"\t[0] Exit"<<endl;
		cout<<"\tEnter your choice: ";
		cin>>option;
		cout<<"||=====================================||"<<endl;
}
void userOption1(int person, double budget, double rating,double regPancit1,double regPancit2,double regPancit3,double bilPancit1,
double bilPancit2,double bilPancit3, string &minShopP, string &shopStat,int H, int M){
		minShopP = pancitResto(person,budget,rating, regPancit1, regPancit2, regPancit3, bilPancit1, bilPancit2, bilPancit3);
		shopStat = isShop(H, M, minShopP);
}
void printOption1(string minShopP, string shopStat){
		if(minShopP == "Can't find a store that suits your budget!"){
			cout<<minShopP<<endl;
		}
		else{
			cout<<minShopP<<endl;
			if((shopStat == "Closed"|| shopStat == "Open")){
				cout<<"    The shop is "<<shopStat<<endl;
			}			
	}  
}
void userOption2(int person, double budget, double rating, double pata1, double pata2, double pata2L, double pata3, string &pataMin, string &shopStat1,int H,int M){
		pataMin = pataResto(person,budget,rating, pata1,pata2,pata3,pata2L);
		shopStat1 = isShop1(H, M, pataMin);
}
void printOption2(string pataMin, string shopStat1){
	if(pataMin == "Can't find a store that suits your budget!"){
		cout<<pataMin<<endl;
	}
	else{
		cout<<pataMin<<endl;
		if((shopStat1 == "Closed"|| shopStat1 == "Open")){
			cout<<"    The shop is "<<shopStat1<<endl;
		}				
	}   
}
void endProgram(){
		cout<<"||=====================================||"<<endl;
		cout<<"    Program terminated... \n    or";
        system("pause");
}
void invalidInput(){
	cout<<"\t\tInvalid Input!"<<endl;
}
int main(){	
	string minShopP, shopStat, pataMin, shopStat1, prodname1 ="Pancit Habhab",prodname2 = "Crispy Pata";
	int option, person,H,M; 
	double budget, rating, regPancit1 = 125, bilPancit1 = 330, regPancit2 = 250, bilPancit2 = 695, regPancit3 = 160, bilPancit3 = 460, 
	pata1 = 500, pata2 = 595, pata3 = 600, pata2L = 795; ; 
	
	do{
		userInput(budget,person,H,M,rating,option,prodname1,prodname2); 
		if(option == 1){
			userOption1(person, budget, rating, regPancit1, regPancit2, regPancit3, bilPancit1, bilPancit2,bilPancit3, minShopP,shopStat,H,M);
			printOption1(minShopP,shopStat);
		}
		else if(option == 2){
			userOption2(person, budget, rating, pata1, pata2, pata2L, pata3, pataMin,shopStat1,H,M);
			printOption2(pataMin,shopStat1);
		}
		else{
			invalidInput();
		}
		if(option == 0){
			endProgram();
		}
	}while(option!=0);

	
	return 0;
}
