package BankingAssignment;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String operation = "";
		boolean operationContinue = true;
		String subOperations = "";
		double moneyDepositWithdrawTransfer;
		String permisionGrant;
		String change = "Y";
		String noChange = "N";
		String userId; // Card Number for Atm
		String pin;
		int counter = 0;

		Person person = new Person();
		Atm atm = new Atm();
		OnlineBanking onlineBanking = new OnlineBanking();

		System.out.println("Which operation to perform(use upper or lower cases): ATM / Online Banking: OB");
		operation = sc.nextLine();
		if (operation.equalsIgnoreCase("ATM")) {
			for (int i = 0; i < 3; i++) {
				counter++;
				System.out.println(counter + " Enter Card Number");
				userId = sc.next();
				System.out.println("Enter Pin");
				pin = sc.next();
				atm.userIdentification(userId, pin);
				if (atm.isValid == true) {
					while (operationContinue) { // While condition Starts here
						System.out.println("\nAccount Holder name: " + person.getAccountHolderName());
						System.out.println("Account  number: " + person.getBankAccountNo());
						System.out.println(
								"Total funds Avaliable: " + (atm.getCheckingBalance() + atm.getSavingBalance()));

						System.out.println(
								"\nChoose an operation:FOR deposit: D / withdraw: W / fund Transfer: FT / user Identification: UI");
						subOperations = sc.next();
						switch (subOperations) {
						case "D":
							System.out.println("Enter money to deposit");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							atm.deposit(moneyDepositWithdrawTransfer);
							System.out.println("Balance is: " + atm.deposit(moneyDepositWithdrawTransfer));
							break;

						case "W":
							System.out.println("Enter money to withdraw");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							atm.getDailyWithdrawLimit(moneyDepositWithdrawTransfer);
							if (atm.isValid == true) {
								atm.withdraw(moneyDepositWithdrawTransfer);
								if (atm.isMoney == true) {
									System.out.println("New Balance is: " + atm.withdraw(moneyDepositWithdrawTransfer));
								} else if (atm.isMoney == false) {
									System.out.println(atm.withdraw(moneyDepositWithdrawTransfer));
									break;
								}
							} else if (atm.isValid == false) {
								System.out.println("Withdrwal limit is: " + atm.getlimit());
							}

							break;

						case "FT":
							System.out.println("Checking Balance is: " + atm.getCheckingBalance());
							System.out.println("Saving Balance is: " + atm.getSavingBalance());
							System.out.println("Enter the amount to transfer from Checking to saving");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							atm.setSavingBalance(moneyDepositWithdrawTransfer);
							System.out.println("Saving balance: " + atm.getSavingBalance());
							break;

						case "UI":
							// User ID for ATM is 8 digit CARD NUMBER
							// Add pin for online transactions
							System.out.println("Do you want to change Debit Card? Enter Y / N");
							permisionGrant = sc.next();
							if (permisionGrant.equals(change)) {
								System.out.println("Enter new card num");
								String newCardNum = sc.next();
								atm.setcardNum(newCardNum);
								System.out.println("New Card is: " + atm.getCardNum());
							} else if (permisionGrant.equals(noChange)) {
								System.out.println("Card is not changed");
								break;
							}
							break;

						}

						System.out.println("Continue operation?: Enter Y / N");
						permisionGrant = sc.next();
						if (permisionGrant.equals(change)) {
							operationContinue = true;
						} else {
							operationContinue = false;
							break;
						}
					} // While condition for ATM ends
					break;
				} else {
					System.out.println(atm.userIdentification(userId, pin));
					if (i == 2) {
						System.out.println("Account locked");
						break;
					}
				}

			} // For loop for ATM Ends

		} else if (operation.equalsIgnoreCase("OB")) {
			for (int j = 0; j < 3; j++) {
				System.out.println("Enter User Name: Can user upper or lower case");
				userId = sc.next();
				System.out.println(
						"Enter password \nyou can use one: $/&/@ \nPassword must be more than or equals to 8 characters");
				pin = sc.next();
				onlineBanking.userIdentification(userId, pin);
				if (onlineBanking.isOnlinePassValid == true) {
					while (operationContinue) {
						System.out.println("Account Holder name: " + person.getAccountHolderName());
						System.out.println("Account  number: " + person.getBankAccountNo());
						System.out.println("Choose an operation:FOR fund Transfer: FT / money investment: MI");
						subOperations = sc.next();
						switch (subOperations) {
						case "FT":
							System.out.println("Still under maintenance :). Please use other services");
							break;

						case "MI":
							System.out.println("Current Interest rate: " + onlineBanking.getInterestRate());
							System.out.println("How much money to invest?");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							System.out.println("After interest you will get: "
									+ onlineBanking.investment(moneyDepositWithdrawTransfer));
							break;

						default:
							System.out.println(
									"Please select from the list: fund transfer/ user Identification/ money investment.");
						}
						System.out.println("Continue operation?: Enter Y / N");
						permisionGrant = sc.next();
						if (permisionGrant.equals(change)) {
							operationContinue = true;
						} else {
							operationContinue = false;
							break;
						}

					} // while operation ends
					break;
				} else {
					System.out.println(onlineBanking.userIdentification(userId, pin));
					if (j == 2) {
						System.out.println("Account locked");
						break;
					}
					break;
				}

			} // for Loop ends
		} else {
			System.out.println("Select from ATM and Online Banking");
		}

	}
}
