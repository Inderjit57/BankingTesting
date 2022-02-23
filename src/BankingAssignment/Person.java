package BankingAssignment;

public class Person {

	private String bankAccountNo = "11122233";
	private String accountHolderName = "Spider Man";
	protected double currentBalance = 500.0;

	public double setTotalFund(double moneyDeposit) {
		currentBalance += moneyDeposit;
		return currentBalance;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

}
