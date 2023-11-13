package be.vdab.util;

public class EmployeeDate extends Date {

	public static final int DATE_MIN_DAY = 12;
	public static final int DATE_MIN_MONTH = 2;
	public static final int DATE_MIN_YEAR = 1977;
	
	private static EmployeeDate DATE_MIN = null;
	
	private static final String DATE_MIN_STRING
	= DATE_MIN_DAY + DATE_SEPARATOR + DATE_MIN_MONTH + DATE_SEPARATOR + DATE_MIN_YEAR;
	
	public EmployeeDate(
			final int day, final int month, final int year)
	throws DateFormatException {
		this(day, month, year, true);
	}
	
	private EmployeeDate(
			final int day,
			final int month,
			final int year,
			final boolean validate)
	throws DateFormatException {
		super(day, month, year);
		
		if (validate && !isValidDate(day, month, year))
			throw new DateFormatException(
				"Invalid employee date (" +
				day + ", " + month + ", " + year +
				") ! Expected a date in the range " +
				DATE_MIN_STRING + " to " + DATE_MAX_STRING);
	}
	
	public static final EmployeeDate getEpoch() {
		if (DATE_MIN == null) {
			try {
				DATE_MIN = new EmployeeDate(
						DATE_MIN_DAY, DATE_MIN_MONTH, DATE_MIN_YEAR, false);
			}
			catch (final DateFormatException dfe) {}
		}
		
		return DATE_MIN;
	}
	
	/**
	 * @see Date.isValidDate(int, int, int)
	 */
	public static final boolean isValidDate(
			final int day,
			final int month,
			final int year) {
		return	Date.isValidDate(day, month, year) &&
				getEpoch().before(day, month, year);
	}
	
	/**
	 * @see Date.isValidDateString(String)
	 */
	public static final boolean isValidDateString(final String dateString) {
		try {
			parse(dateString);
		}
		catch (final DateFormatException dfe) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @see Date.parse(String)
	 */
	public static final EmployeeDate parse(final String dateString)
	throws DateFormatException {
		final Date date = Date.parse(dateString);
		
		return new EmployeeDate(date.getDay(), date.getMonth(), date.getYear());
	}
}
