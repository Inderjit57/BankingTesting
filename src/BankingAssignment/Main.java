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
//		Atm atm = new Atm();
//		OnlineBanking onlineBanking = new OnlineBanking();

		System.out.println("Which operation to perform(use upper or lower cases): ATM / Online Banking: OB");
		operation = sc.next();
		if (operation.equalsIgnoreCase("ATM")) {
			for (int i = 0; i < 3; i++) {
				counter++;
				System.out.println(counter + " Enter Card Number");
				userId = "999000888";
				System.out.println("Enter Pin");
				pin = "123@$";
				person.getAtm().userIdentification(userId, pin);
				if (person.getAtm().isValid == true) {
					while (operationContinue) { // While condition Starts here
						System.out.println("\nAccount Holder name: " + person.getAccountHolderName());
						System.out.println("Account  number: " + person.getBankAccountNo());
						System.out.println("Total funds Avaliable: " + (person.getCurrentBalance()));

						System.out.println(
								"\nChoose an operation:FOR deposit: D / withdraw: W / fund Transfer: FT / user Identification: UI");
						subOperations = sc.next();
						switch (subOperations) {
						case "D":
							System.out.println("Enter money to deposit");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							System.out.println("Balance is: " + person.getAtm().deposit(moneyDepositWithdrawTransfer));

							break;

						case "W":
							System.out.println("Enter money to withdraw");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							person.getAtm().getDailyWithdrawLimit(moneyDepositWithdrawTransfer);
							if (person.getAtm().isValid == true) {
								person.getAtm().withdraw(moneyDepositWithdrawTransfer);
								if (person.getAtm().isMoney == true) {
									System.out.println("New Balance is: " + person.getAtm().withdraw(moneyDepositWithdrawTransfer));
								} else if (person.getAtm().isMoney == false) {
									break;
								}
							} else if (person.getAtm().isValid == false) {
								System.out.println("Withdrwal limit is: " + person.getAtm().getlimit());
							}
							break;

						case "FT":
							System.out.println("Are you sure to transfer funds? Press: Y / N");
							operation = sc.next();
							System.out.println("how much to transfer");
							moneyDepositWithdrawTransfer = sc.nextDouble();							
							person.getAtm().fundTransfer(operation, moneyDepositWithdrawTransfer);
							if(person.getAtm().isValid == true) {
								System.out.println("Balance left: "+ person.getAtm().fundTransfer(operation, moneyDepositWithdrawTransfer));
							} else if(person.getAtm().isValid == false){
								break;
							}
							break;

						case "UI":
							System.out.println("Do you want to change Debit Card? Enter Y / N");
							permisionGrant = sc.next();							
							if (permisionGrant.equals(change)) {								
								String newCardNum = sc.next();
								person.getAtm().setcardNum(newCardNum);
								System.out.println("New Card is: " + person.getAtm().getCardNum());
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
					System.out.println(person.getAtm().userIdentification(userId, pin));
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
				person.getOnlineBanking().userIdentification(userId, pin);
				if (person.getOnlineBanking().isOnlinePassValid == true) {
					while (operationContinue) {
						System.out.println("Account Holder name: " + person.getAccountHolderName());
						System.out.println("Account  number: " + person.getBankAccountNo());
						System.out.println("Total funds Avaliable: " + (person.getCurrentBalance()));

						System.out.println("Choose an operation:FOR fund Transfer: FT / money investment: MI");
						subOperations = sc.next();
						switch (subOperations) {
						case "FT":
							System.out.println("Are you sure to transfer funds? Press: Y / N");
							operation = sc.next();
							System.out.println("how much to transfer");
							moneyDepositWithdrawTransfer = sc.nextDouble();							
							person.getOnlineBanking().fundTransfer(operation, moneyDepositWithdrawTransfer);
							if(person.getOnlineBanking().isValid == true) {
								System.out.println("Balance left: "+ person.getOnlineBanking().fundTransfer(operation, moneyDepositWithdrawTransfer));
							} else if(person.getOnlineBanking().isValid == false){
								break;
							}
							break;

						case "MI":
							System.out.println("Current Interest rate: " + person.getOnlineBanking().getInterestRate());
							System.out.println("How much money to invest?");
							moneyDepositWithdrawTransfer = sc.nextDouble();
							System.out.println("After interest you will get: "
									+ person.getOnlineBanking().investment(moneyDepositWithdrawTransfer));
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
					System.out.println(person.getOnlineBanking().userIdentification(userId, pin));
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
