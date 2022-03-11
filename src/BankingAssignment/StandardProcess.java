package BankingAssignment;

public interface StandardProcess {

	public double deposit(double moneyDeposit);

	public double withdraw(double moneyWithdraw);

	public double fundTransfer(String transferFund, double amount);

	public double investment(double moneyInvestment);

}
