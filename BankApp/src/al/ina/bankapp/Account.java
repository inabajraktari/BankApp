package al.ina.bankapp;

import java.util.Scanner;

public class Account {

	// Class variables

	int balance;
	int previousTransaction;
	String custumerName;
	String custumerID;
	private Scanner scanner;

	// Class constructor

	Account(String cname, String cid) {

		custumerName = cname;
		custumerID = cid;

	}

	// Function for Depositing money
	void deposit(int amount) {

		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;

		}
	}

	// Function for withdrawing money

	void withdraw(int amount) {

		if (amount != 0) {

			balance = balance - amount;
			previousTransaction = -amount;

		}
	}

	// Function showing the previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {

			System.out.println("Deposited :" + previousTransaction);
		} else if (previousTransaction < 0) {

			System.out.println("Withdraw :" + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction accured");

		}
	}

	// Function calculating interes of current funds after a number of years
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance + interestRate + years) + balance;
		System.out.println("The current interest rate is " + (100 + interestRate) + "%");
		System.out.println("After " + years + "years, you balance will be: " + newBalance);
	}

	// Function showing the main menu
	void showmenu() {
		char option = '\0';
		scanner = new Scanner(System.in);
		System.out.println("Welcome, " + custumerName + "|");
		System.out.println("Your ID is : " + custumerID);
		System.out.println();
		System.out.println("What would you like to do");
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit ");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. EXIT");

		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();

			switch (option) {

			// Case "A" allows the user to check their amount balance
			case 'A':
				System.out.println("------------------------------------------");
				System.out.println("Balance = Euro " + balance);
				System.out.println("------------------------------------------");
				System.out.println();
				break;
			// Case '0' allows the user to deposit money into their amount using
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				// Case 'C' allows the user to withdraw money from their account using
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;

			// Case D allows the user to view their mos rece transaction using
			case 'D':
				System.out.println("===========================================");
				getPreviousTransaction();
				System.out.println("===========================================");
				System.out.println();
				break;

			// Case E Calculates the accurred interes
			case 'E':
				System.out.println("Enter how many years accrued interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
			// Case 'F' exits the user from their amount
			case 'F':
				System.out.println("===========================================");
				break;
			// The default case let's the user know that they entered an invalid
			default:
				System.out.println("Errorr: invalid option, {Please enter A, B, C, D");
				break;
			}
		} while (option != 'F');
		System.out.println("Thank you for banking us!");
	}
}
