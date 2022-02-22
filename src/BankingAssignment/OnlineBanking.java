package BankingAssignment;

public class OnlineBanking extends BankingRules implements StandardProcess {

	private double interestRate = 0.08;
	private double moneyInvest;
	private String userIdOnline;
	private String validOnlineUserId = "frenchVanilla";
	private String validPasswordOnline = "12356@$";
	boolean isOnlinePassValid;

	public String fundTransfer(String transferFund) {
		return null;
	}

	public double deposit(double moneyDeposit) {
		//Service is avaliable in ATM
		return 0;
	}

	public double withdraw(double moneyWithdraw) {
		// Service is avaliable in ATM
		return 0;
	}

	@Override
	public double investment(double moneyInvest) {
		// invest and get annual interest
		this.moneyInvest = moneyInvest;
		return (moneyInvest + (moneyInvest * interestRate));
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String userIdentification(String onlineUserId,String password) { // Verify Pin for ATM
		this.userIdOnline = onlineUserId;
		
		if (onlineUserId.equalsIgnoreCase(validOnlineUserId) && password.equals(validPasswordOnline) && password.length()>=8 || password.contains("@") || password.contains("$")  || password.contains("&")){
			isOnlinePassValid = true;
		} 
		return "Not a valid entry, Please check user name and password";
	}

	public String getUserIdOnline() {
		return userIdOnline;
	}


}
