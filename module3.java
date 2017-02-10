/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anand Yadav
 */ 
import java.util.*;

class myException extends Exception{
    myException(String s){
        super(s);
    }
    
}

abstract class account{
    double interestRate, amount;
    abstract double calculateinterest(double amount) throws myException;
}

class FDAccount extends account{
    double interest, interestRate, amount, general=1, sCitizen=1;
    int noOfDays, age;
    double calculateinterest(double amount) throws myException{
        this.amount = amount;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number Of Days: ");
        noOfDays = s.nextInt();
        if(noOfDays<0){
            throw new myException("Days Should be Greater than 0.");
        }
        else{
        System.out.println("Ënter Age: ");
        age = s.nextInt();
        if(age<0){
            throw new myException("Age must be greater than 0.");
        }
        else{
        if(amount<10000000){
            if(noOfDays>=7 && noOfDays<=14){
                general = 5.50;
                sCitizen = 6.00;
            }
            else if(noOfDays>=15 && noOfDays<=29){
                general = 4.75;
                sCitizen = 5.25;
            }
            else if(noOfDays>=30 && noOfDays<=45){
                general = 5.50;
                sCitizen = 6.00;
            }
            else if(noOfDays>=45 && noOfDays<=60){
                general = 7.00;
                sCitizen = 7.50;
            }
            else if(noOfDays>=61 && noOfDays<=184){
                general = 7.50;
                sCitizen = 8.00;
            }
            else if(noOfDays>=185 && noOfDays<=365){
                general = 8.00;
                sCitizen = 8.50;
            }
        }
        else{
            if(noOfDays>=7 && noOfDays<=14){
                interestRate = 6.50;
            }
            else if(noOfDays>=15 && noOfDays<=29){
                interestRate = 6.750;
            }
            else if(noOfDays>=30 && noOfDays<=45){
                interestRate = 6.75;
            }
            else if(noOfDays>=45 && noOfDays<=60){
                interestRate = 8;
            }
            else if(noOfDays>=61 && noOfDays<=184){
                interestRate = 8.50;
            }
            else if(noOfDays>=185 && noOfDays<=365){
                interestRate = 10.00;
            }   
        }
        }
        }
        interestRate = (age<50)?general : sCitizen;
      return interest = amount * interestRate;  
    }
}

class SBAccount extends account{
    double interest, interestRate, amount;
    double calculateinterest(double amount) throws myException{
        this.amount = amount;
        System.out.println("Select Account Type: \n1. Normal\n2. NRI");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        
        switch(choice){
            case 1: interestRate = 0.04;
            break;
            case 2: interestRate = 0.06;
            break;
            default: System.out.println("Wrong Choice.");
        }
      return amount * interestRate;  
    }
}

class RDAccount extends account{
    double interest, interestRate, amount, monthlyAmount, general=1, sCitizen=1;
    int noOfMonths, age;
    double calculateinterest(double amount) throws myException{
        this.amount = amount;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number Of Months: ");
        noOfMonths = s.nextInt();
        if(noOfMonths<0){
            throw new myException("Months should be greater than 0.");
        }
        else{
        System.out.println("Ënter Age: ");
        age = s.nextInt();
        if(age<0){
            throw new myException("Age should be greater than 0.");
        }
        else{
            if(noOfMonths == 6){
                general = 5.50;
                sCitizen = 6.00;
            }
            else if(noOfMonths == 9){
                general = 4.75;
                sCitizen = 5.25;
            }
            else if(noOfMonths == 12){
                general = 5.50;
                sCitizen = 6.00;
            }
            else if(noOfMonths == 15){
                general = 7.00;
                sCitizen = 7.50;
            }
            else if(noOfMonths == 18){
                general = 7.50;
                sCitizen = 8.00;
            }
            else if(noOfMonths == 21){
                general = 8.00;
                sCitizen = 8.50;
            }
        }
        }
            
      interestRate = (age<50)?general : sCitizen;
      return interest = amount * interestRate;  
        }
        
    }

public class module3 {
    public static void main(String[] args) {
        int t = 4, choice;
        double amount;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Select The Option: \n1. Interest Calculator-SB\n2. Interest Calculator-FD\n"
                    + "3. Interest Calculator-RD\n4. Exit\n"); 
            choice = s.nextInt();
            
            switch(choice){
                case 1: SBAccount ob1 = new SBAccount();
                        System.out.println("Enter Amount: ");
                        amount = s.nextInt();
                        try{
                        System.out.println("Interest: " +ob1.calculateinterest(amount));
                        }
                        catch (Exception m){
                            System.out.println("Exception occured: "+m);
                        }
                        break;
                        
                case 2: FDAccount ob2 = new FDAccount();
                        System.out.println("Enter Amount: ");
                        amount = s.nextInt();
                        try{
                        System.out.println("Interest: " +ob2.calculateinterest(amount));
                        }
                        catch (Exception m){
                            System.out.println("Exception occured: "+m);
                        }
                        break;
                        
                case 3: RDAccount ob3 = new RDAccount();
                        System.out.println("Enter Amount: ");
                        amount = s.nextInt();
                        try{
                        System.out.println("Interest: " +ob3.calculateinterest(amount));
                        }
                        catch (Exception m){
                            System.out.println("Exception occured: "+m);
                        }
                        break;
                        
                case 4: System.exit(t);
                
                default:
                        System.out.println("Wrong Choice: ");
            }
            
         t--;   
        }while(t!=0);
     
    }
    
}
