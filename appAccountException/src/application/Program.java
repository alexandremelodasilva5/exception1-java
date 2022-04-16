package application;


import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withDrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, initialBalance, withDrawLimit);
		
		System.out.println("");
		System.out.print("Enter the amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withDraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		
		sc.close();
	}

}
