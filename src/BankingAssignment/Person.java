package BankingAssignment;

public class Person {

	Atm atm = new Atm();
	OnlineBanking onlineBanking = new OnlineBanking();

	private String bankAccountNo = "11122233";
	private String accountHolderName = "Spider Man";
	protected double currentBalance = 500.0;

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}

	public OnlineBanking getOnlineBanking() {
		return onlineBanking;
	}

	public void setOnlineBanking(OnlineBanking onlineBanking) {
		this.onlineBanking = onlineBanking;
	}

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
