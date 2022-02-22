package BankingAssignment;

public abstract class BankingRules extends Person {

	abstract String userIdentification(String userId, String password);

	private double dailyWithdrawLimit = 1000;
	private boolean noOfTransactionLimit;
	public int validPin = 1111;
	public boolean isValid;

	public double getDailyWithdrawLimit(double dailyWithdrwal) { 	// need to be fixed
		if(dailyWithdrwal < dailyWithdrawLimit) {
			isValid = true;
			return dailyWithdrawLimit;
		}
		return 0;
	}
	
	public double getlimit() {
		return dailyWithdrawLimit;
	}

	public boolean getNoOfTransactionLimit() { // dead code
		return noOfTransactionLimit;
	}

	public void setNoOfTransactionLimit(boolean noOfTransactionLimit) { // dead code
		this.noOfTransactionLimit = noOfTransactionLimit;
	}

	public int getPin() {
		isValid = true;
		return validPin;
	}

	public void setPin(int enterPin) {
		validPin = enterPin;
	}

}
