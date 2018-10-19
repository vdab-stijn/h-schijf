package be.vdab;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bank {

	private static final String URL = "jdbc:mysql://localhost/bank?useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "jdbctest";
	private static final String PASS = "jdbctest";

	private static final String INSERT_ACCOUNT = "INSERT INTO Rekeningen(RekeningNr, Saldo) VALUES(?,0)";

	private static final String SELECT_BALANCE = "SELECT RekeningNr, Saldo FROM Rekeningen WHERE RekeningNr = ?";

	private static final String UPDATE_BALANCE = "UPDATE Rekeningen SET Saldo = ? WHERE RekeningNr = ?";

	private Connection connection;

	public Bank() {

	}

	private final Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(URL, USER, PASS);

			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
		}

		return connection;
	}

	private final String askAccountNumber() throws SQLException {
		return askAccountNumber("Please enter the account number: ");
	}

	private final String askAccountNumber(final String prompt) throws SQLException {
		return askAccountNumber(prompt, false);
	}

	private final String askAccountNumber(final String prompt, final boolean verifyDB) throws SQLException {
		String accountNumber = null;

		while (accountNumber == null) {
			System.out.print(prompt);
			accountNumber = new Scanner(System.in).nextLine().trim();

			if (!validateAccountNumber(accountNumber)) {
				System.out.println("Invalid account number !");
				accountNumber = null;
			} else {
				if (verifyDB && !validateAccountNumberDB(accountNumber)) {
					System.out.println("Unknown account number !");
					accountNumber = null;
				}
			}
		}

		return accountNumber;
	}

	private final boolean validateAccountNumber(final String accountNumber) {
		if (accountNumber == null || accountNumber.length() != 12)
			return false;

		if (Long.parseLong(accountNumber.substring(0, 10)) % 97 != Long.parseLong(accountNumber.substring(10)))
			return false;

		return true;
	}

	private final boolean validateAccountNumberDB(final String accountNumber) throws SQLException {
		final Account account = consultBalanceDB(accountNumber);

		if (account != null && account.getAccountNumber().equalsIgnoreCase(accountNumber))
			return true;
		return false;
	}

	private final void startBank() throws SQLException {
		showMenu();
	}

	private final void stopBank() {
		printLine();
		System.out.println("Goodbye !");
		printLine();

		System.exit(0);
	}

	private final void newAccount() throws SQLException {
		final String accountNumber = askAccountNumber();

		if (validateAccountNumberDB(accountNumber)) {
			System.out.println("This account (" + accountNumber + ") already exists !");
		} else {
			final Account account = newAccountDB(accountNumber);

			System.out.println("Created new account (" + account + ")");
		}
	}

	private final Account newAccountDB(final String accountNumber) throws SQLException {
		final PreparedStatement statement = getConnection().prepareStatement(INSERT_ACCOUNT,
				Statement.RETURN_GENERATED_KEYS);

		statement.setLong(1, Long.parseLong(accountNumber));
		statement.executeUpdate();

		final ResultSet result = statement.getGeneratedKeys();

		result.next();

		final long id = result.getLong(1);

		getConnection().commit();

		return new Account(String.valueOf(id), BigDecimal.valueOf(0L));
	}

	private final void consultBalance() throws SQLException {
		final Account account = consultBalanceDB(askAccountNumber());

		if (account != null) {
			System.out.println("Balance for account " + account.getAccountNumber() + ": EUR " + account.getBalance());
		}
	}

	private final Account consultBalanceDB(final String accountNumber) throws SQLException {
		Account account = null;

		final PreparedStatement statement = getConnection().prepareStatement(SELECT_BALANCE);
		statement.setLong(1, Long.parseLong(accountNumber));

		final ResultSet result = statement.executeQuery();

		if (result.next()) {
			account = new Account(result.getString("RekeningNr"), result.getBigDecimal("saldo"));
			getConnection().commit();
		}
		return account;
	}

	private final void transferMoney() throws SQLException {
		final Account fromAccount = consultBalanceDB(
				askAccountNumber("Please enter the account to transfer money FROM: ", true));
		final Account toAccount = consultBalanceDB(
				askAccountNumber("Please enter the account to transfer money TO: ", true));
		BigDecimal amount = null;

		while (amount == null) {
			System.out.print("Please enter the amount to transfer: ");
			amount = new Scanner(System.in).nextBigDecimal();

			if (amount.compareTo(fromAccount.getBalance()) > 0) {
				System.out.println("Not enough money in the account (EUR " + fromAccount.getBalance() + ")");

				amount = null;
			}
		}

		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		toAccount.setBalance(toAccount.getBalance().add(amount));

		transferMoneyDB(fromAccount, toAccount);
	}

	private final void transferMoneyDB(final Account from, final Account to) throws SQLException {
		final PreparedStatement fromStatement = getConnection().prepareStatement(UPDATE_BALANCE);
		final PreparedStatement toStatement = getConnection().prepareStatement(UPDATE_BALANCE);

		fromStatement.setBigDecimal(1, from.getBalance());
		fromStatement.setLong(2, Long.valueOf(from.getAccountNumber()));
		final int fromResult = fromStatement.executeUpdate();

		toStatement.setBigDecimal(1, to.getBalance());
		toStatement.setLong(2, Long.valueOf(to.getAccountNumber()));
		final int toResult = toStatement.executeUpdate();

		getConnection().commit();

		if (fromResult + toResult == 2) {
			System.out.println("Updated accounts with their new balance !");
		} else {
			System.out.println("Could not transfer money !");
		}
	}

	private final void printLine() {
		System.out.println("=================================================");
	}

	private final void showMenu() throws SQLException {
		BankOperation operation = null;

		while (operation == null) {
			System.out.println("\n\n");
			printLine();
			System.out.println("FEDERAL RESERVE SYSTEM");
			printLine();

			final BankOperation[] operations = BankOperation.values();
			for (int i = 0; i < operations.length; i++) {
				System.out.println(operations[i].getCommand() + " " + operations[i].getExplanation());
			}
			printLine();

			System.out.print("Desired fuction (1, 2 or 3): ");
			operation = BankOperation.parse((new Scanner(System.in)).nextInt());
		}

		switch (operation) {
		case QUIT_APP:
			stopBank();
			break;
		case NEW_ACCOUNT:
			newAccount();
			break;
		case CONSULT_BALANCE:
			consultBalance();
			break;
		case TRANSFER_MONEY:
			transferMoney();
			break;
		}

		showMenu();
	}

	public static final void main(final String[] args) {
		final Bank bank = new Bank();

		try {
			bank.startBank();
		} catch (final SQLException se) {
			se.printStackTrace(System.err);
		}
	}

	private enum BankOperation {
		QUIT_APP(0, "Quit this application"), NEW_ACCOUNT(1, "New account"), CONSULT_BALANCE(2, "Consult balance"),
		TRANSFER_MONEY(3, "Transfer money");

		private final int command;
		private final String explanation;

		private BankOperation(final int command, final String explanation) {
			this.command = command;
			this.explanation = explanation;
		}

		public final int getCommand() {
			return command;
		}

		public final String getExplanation() {
			return explanation;
		}

		public static final BankOperation parse(final int command) {
			switch (command) {
			case 0:
				return QUIT_APP;
			case 1:
				return NEW_ACCOUNT;
			case 2:
				return CONSULT_BALANCE;
			case 3:
				return TRANSFER_MONEY;
			}

			return null;
		}
	}
}
