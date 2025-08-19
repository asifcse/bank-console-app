package com.asifkhan.minibanking;

import com.asifkhan.minibanking.banking.BankManagement;
import java.util.Scanner;

/**
 *
 * @author Asif Khan <asif.cse12@gmail.com>
 */
public class MiniBanking {

    public static void main(String[] args) {
        BankManagement bm = new BankManagement();
        Scanner input = new Scanner(System.in);
        
            System.out.println("Welcome to Mini Bank");
            System.out.println("To create Bank account please enter 1");
            System.out.println("To login your account please enter 2");
            System.out.println("Exit from application type 0");
        switch(input.nextInt()){
            
            case 1:
                String customerName="";
                String customerPassCode="";
                
                System.out.println("Please enter your user name");
                Scanner sc = new Scanner(System.in);
                customerName = sc.nextLine();
                System.out.println("Choose password");
                customerPassCode = sc.nextLine();
                if(bm.createAccount(customerName,customerPassCode)){
                    System.out.println("Account created Successfully");
                }else{
                    System.out.println("All Field Required!");
                }
                
            case 2:
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter customer user name");
                customerName = sc1.nextLine();
                System.out.println("Enter user password");
                customerPassCode = sc1.nextLine();
                if(bm.isValidUser(customerName,customerPassCode)){
                    System.out.println("loged in Successfully");
                    System.out.println("Account blance: "+bm.checkBlance(customerName, customerPassCode));
                    System.out.println("Transfer blance");
          
                }else{
                    System.out.println("All Field Required!");
                }
            default:
               
        }
       
*/
        
        String customerName = "";
        String customerPassCode;
        int custoemrAccountNo;
        int input;
        BankManagement bm = new BankManagement();
        Scanner sc = new Scanner(System.in);
        while(true){
            
            System.out.println("Welcome to Mini Bank");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Bank Account Login");
            System.out.println("0. Exit from Application");
            
            try{
                
                input = Integer.parseInt(sc.nextLine());
                
                switch(input){
                
                    case 1:
                       
                        try{
                            
                            System.out.println("Please enter your unique customer user name:");
                            customerName = sc.nextLine();
                            System.out.println( "Enter password:");
                            customerPassCode =sc.nextLine();
                            
                            if(bm.createAccount(customerName,customerPassCode)){
                                
                                System.out.println("Account created Successfully");
                                
                            }else{
                                
                                System.out.println("All Field Required!");
                                
                            }    
                        }catch(Exception  e){
                            System.out.println(" ERR : Enter Valid Data::Insertion Failed!\n");
                        }
                        break;
                        
                    case 2:
                        
                        try{
                            
                            System.out.println("Please enter your  customer user name:");
                            customerName = sc.nextLine();
                            System.out.println( "Enter customer password:");
                            customerPassCode =sc.nextLine(); 
                            
                            if(bm.isValidUser(customerName,customerPassCode)){
                                
                                System.out.println("loged in Successfully");
                                System.out.print("Hello, "+customerName+" ");
                                //System.out.println("Account blance: "+bm.checkBlance(customerName, customerPassCode));
                                System.out.println("3.View blance");
                                System.out.println("4.Transfer blance");
                                System.out.println("5. Log out");
                                Scanner sc2 = new Scanner(System.in);
                                int input2 = Integer.parseInt(sc2.nextLine());
                                switch(input2){
                                    case 3:
                                        try{
                                            
                                            bm.viewBlance(customerName, customerPassCode);
                                        }catch(Exception  e){
                                            System.out.println(e);
                                        }
                                        break;
                                    case 4:
                                        try{
                                            Scanner sc3 = new Scanner(System.in);
                                            System.out.println("Enter transfer account number:");
                                            int input3 = Integer.parseInt(sc3.nextLine());
                                            System.out.println("Enter Transfar Ammount:");
                                            double input4 = Double.parseDouble(sc3.nextLine());
                                            if(bm.blanceTransfer(customerName, customerPassCode, input3, input4)){
                                                System.out.println("You successfull transfar:"+input4+" tk to account no: "+input3);
                                            }
                                            
                                        }catch(Exception e){
                                        
                                            System.out.println(e);
                                        }
                                        break;
                                    default :
                                        System.out.println("Invalid entry");
                                }
                            }else{
                                
                                System.out.println("All Field Required!");
                            } 
                        }catch(Exception  e){
                            System.out.println(" ERR : Enter Valid Data::Insertion Failed!\n");
                        }
                        break;
                    default:
                        System.out.print("Invalid Entry");
                }
                
            }catch(Exception  e){
               System.out.println(" ERR : Enter Valid Data::Insertion Failed!\n");
            }
        }
        
    }
}
