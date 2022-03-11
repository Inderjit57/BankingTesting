package BankingAssignment;

public class Atm extends BankingRules implements StandardProcess {
	
	private String cardNum = "999000888"; // valid cardNum to compare string
	private String transferFund;
	public String permisionToTransfer = "Y";
	public boolean isMoney;
	boolean isValid;
	private String validPassword = "123@$"; // valid password to compare string


	public String getCardNum() {
		return cardNum;
	}

	public void setcardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Override
	public double deposit(double moneyDeposit) { // this method deposit the money in the total fund in Person class
		setTotalFund(moneyDeposit);
		return currentBalance;
	}

	@Override
	public double withdraw(double moneyWithdraw) {
		if (moneyWithdraw < currentBalance) {
			isMoney = true;
			return currentBalance - moneyWithdraw;
		} else if (moneyWithdraw > currentBalance && currentBalance == 0) {
			isMoney = false;
			System.out.println("Not enough balance: " + currentBalance);
		}
		return 0;
	}

	@Override	
	public String userIdentification(String cardNum, String password) { // Verify Pin for ATM
		this.cardNum = cardNum;

		if (cardNum.equals(this.cardNum) && password.equals(validPassword) && password.length() >= 4) {
			isValid = true;
		}
		return "Pin length is minimum 4 numbers and should contains @/$/&";
	}

	@Override
	public double fundTransfer(String transferFund , double amount) { // in progress
		this.transferFund = transferFund;
		if (permisionToTransfer.equalsIgnoreCase(transferFund)) {
			isValid = true;
			return currentBalance - amount;  
		} else {
			isValid = false;
		}
		return 0;
	}

	public double investment(double moneyInvest) { // service is only avaliable on Online banking
		return 0;
	}

}
