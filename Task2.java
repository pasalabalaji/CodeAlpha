import java.util.HashMap;
import java.util.Scanner;

//Problem Statement

//Online Quiz Platform
// A Simple Banking Application in Java is an ideal project
// for coding beginners. It covers fundamental concepts
// like the Scanner class for input, strings, loops, methods,
// and conditional statements. This project involves basic
// banking operations such as deposits, withdrawals,
// checking balances, and exiting the program.

class Task2 {
    public static void main(String args[]) {
        HashMap<Integer, Customer> map = new HashMap<>();
        boolean option=true;

        Scanner scanner=new Scanner(System.in);

        do{
            int operation;
            System.out.println("Select an operation 1) Create Account 2) Deposit 3) Withdraw 4) Check Balance 5) Exit ");
            operation=scanner.nextInt();

            if(operation==1){
               Customer customer=new Customer();
               System.out.println("Enter Account Number ");
               int AccountNumber=scanner.nextInt();
               

               if(map.get(AccountNumber)==null){
                 map.put(AccountNumber,customer);
                 customer.create_customer(customer);
               }
               else{
                    System.out.println("Account number holder already exists ");
               }


            }
            else if(operation==2){

                System.out.println("Enter Account Number ");
                Customer customer=map.get(scanner.nextInt());
                if(customer!=null){
                    

                    System.out.println("Enter Amount to deposit ");
    
                    customer.money=customer.money+  scanner.nextFloat();
    
                    System.out.println("Amount Deposited Successfully ");
                }
                else{
                    System.out.println("Account number holder doesn't exists ");
                }
 
                
 
             }
             else if(operation==3){
                System.out.println("Enter Account Number ");
                Customer customer=map.get(scanner.nextInt());
            if(customer!=null){
                

                System.out.println("Enter Amount to withdraw ");
                float amount=scanner.nextFloat();
                if(customer.money- amount <0){
                    System.out.println("Insufficient amount in your account, please select another option ");
                }
                else{
                    customer.money=customer.money-  amount;

                    System.out.println("Amount withdrawn Successfully ");
                }

            }
            else{
                System.out.println("Account number holder doesn't exists ");
            }

 
                
 
             }
             else if(operation==4){
                System.out.println("Enter Account Number ");
                Customer customer=map.get(scanner.nextInt());
            if(customer!=null){
                

                System.out.println("Dear "+customer.name+" "+"Amount in your account is "+" "+customer.money);

             }
             else{
                System.out.println("Account number holder doesn't exists ");
            }
            }
             else if(operation==5){
                option=false;
             }
             else{
                  System.out.println("Please select a valid operation ");
             }

    
        }while(option);
    }
}

class Customer{

    String name=new String();
    Float money;

      public static void create_customer(Customer user){
             System.out.println("Enter Your Name ");
             Scanner scanner=new Scanner(System.in);

             user.name=scanner.nextLine();
             user.money=(float)0;
      }
}
