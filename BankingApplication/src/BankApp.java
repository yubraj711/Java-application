import java.util.Scanner;

public class BankApp {

}

class BankAccount{

	String customerName;
	String customerId;
	int balanceAmount;
	int previousTransaction;



	BankAccount(String cname,String cid){
		customerName=cname;
		customerId= cid;


	}
	void deposit(int depositAmount) {

		if(depositAmount !=0)
		{
			balanceAmount = balanceAmount + depositAmount;
			previousTransaction =  depositAmount;
		}
	}


	void withdraw(int withdrawAmount) {
		if(withdrawAmount !=0) {

			balanceAmount = balanceAmount - withdrawAmount;
			previousTransaction = withdrawAmount;

		}
	}


	void previousTransaction() {


		if(previousTransaction > 0){
			System.out.println("Deposited Amount"+ previousTransaction);
		}

		else if (previousTransaction < 0) {
			System.out.println("Withdrawn Amount" + previousTransaction);
		}


		else
		{
			System.out.println("No transaction occur");
		}

	}



	void displayContent() {

		char option ='\0';
		Scanner sc= new Scanner(System.in);

		System.out.println("Hi:"+ " " + customerName);
		System.out.println("Customer id:" +" " + customerId);

		System.out.println("\n");


		System.out.println(  "A. Check Balance");

		System.out.println(  "B. Deposit Amount");

		System.out.println(  "C. Withdraw Amount");

		System.out.println( " D. previous Transaction");

		System.out.println(  "E. Exit");




		do
		{

			System.out.println("*******************");
			System.out.println("Enter an option");
			System.out.println("***********");
			option=sc.next().charAt(0);            //reading character from console  

			System.out.println("\n");


			switch(option) {

			case 'A':

				System.out.println("-----------------------------");
				System.out.println( "Balance Amount:"+ balanceAmount);
				System.out.println("------------------------------");
				System.out.println("\n");
				break;




			case 'B':
				System.out.println("--------------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("----------------------------");
				int amount=sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;


			case 'C':
				System.out.println("--------------------------------");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("----------------------------");
				int amount2=sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;



			case 'D':
				System.out.println("-------------------------------");
				previousTransaction();
				System.out.println("--------------------------------");
				System.out.println("\n");
				break;


			case 'E':
				System.out.println("------------------------------");

			default:
				System.out.println("Invalid option! Please enter again");
				break;

			}
		}
		while (option!= 'E');
		System.out.println("Thank you for using our services");


	}




	public static void main(String[] args) {

		BankAccount BA=new BankAccount("Samjeila","SA3456787");
		BA.displayContent();
	}

}















