package be.vdab;

import java.math.BigDecimal;

public class Account {

	private final String accountNumber;
	private BigDecimal balance;

	public Account(final String accountNumber, final BigDecimal balance) {
		this.accountNumber = accountNumber;

		setBalance(balance);
	}

	public final String getAccountNumber() {
		return accountNumber;
	}

	public final void setBalance(final BigDecimal balance) {
		this.balance = balance;
	}

	public final BigDecimal getBalance() {
		return balance;
	}

	public final String toString() {
		return accountNumber.substring(0, 10) + "-" + accountNumber.substring(10);
	}
}
