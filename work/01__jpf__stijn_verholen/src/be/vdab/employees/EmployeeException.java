package be.vdab.employees;

public class EmployeeException extends Exception {
	
	/**
	 * Implements Serializable.
	 */
	private static final long serialVersionUID = 167722863586574799L;
	
	public EmployeeException(final String message) {
		super(message);
	}
}
