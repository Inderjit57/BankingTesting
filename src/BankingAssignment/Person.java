package BankingAssignment;

public class Person {

	private String bankAccountNo = "11122233";
	private String accountHolderName = "Spider Man";
	public String accountType;
	protected double checkingBalance = 500;
	protected double savingBalance;
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}
	
	public double setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
		savingBalance = checkingBalance - savingBalance;
		return savingBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountType(String accounttype) {
		switch(accounttype) {
		case"checking":
			System.out.println("Checking Balance : " + checkingBalance);
			break;
		case"saving":
			System.out.println("Saving Balance :" + savingBalance);
			break;
		default:
			System.out.println("Please select checking or savings");
		}
		return null;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

}
