package be.vdab.util;

import java.util.regex.Pattern;

public class Date implements IDate, Comparable<Date> {

	/** The character that separates date parts (as a String). */
	public static final String DATE_SEPARATOR = "/";
	
	/**
	 * The pattern that provides the basic dateString validation. This
	 * does not validate the year.
	 * @see isValidDate()
	 */
//	public static final Pattern BASIC_DATE_PATTERN
//	= Pattern.compile(	"([1-9]|[1-2][0-9]|[3][0-1])/" +
//						"([1-9]|[1][0-2])/" +
//						"([1-4][0-9]{3})");
	public static final String BASIC_DATE_PATTERN
	= 	"([1-9]|[1-2][0-9]|[3][0-1])/" +
		"([1-9]|[1][0-2])/" +
		"([1-4][0-9]{3})";
	
	/** Minimum day of the earliest date representable by this class. */
	public static final int DATE_MIN_DAY = 1;
	/** Minimum month of the earliest date representable by this class. */
	public static final int DATE_MIN_MONTH = 1;
	/** Minimum year of the earliest date representable by this class. */
	public static final int DATE_MIN_YEAR = 1584;
	/** Maximum day of the latest date representable by this class. */
	public static final int DATE_MAX_DAY = 31;
	/** Maximum month of the latest date representable by this class. */
	public static final int DATE_MAX_MONTH = 12;
	/** Maximum year of the latest date representable by this class. */
	public static final int DATE_MAX_YEAR = 4099;
	
	/**
	 * The earliest date that can be represented by this class.
	 * This is set to 1/1/1584.
	 */
	private static Date DATE_MIN = null;
	public static final String DATE_MIN_STRING = "1/1/1584";
	/**
	 * The latest date that can be represented by this class.
	 * This is set to 31/12/4099.
	 */
	private static Date DATE_MAX = null;
	public static final String DATE_MAX_STRING = "31/12/4099";
	
	/** The day of the current date. */
	private final int day;
	/** The month of the current date. */
	private final int month;
	/** The year of the current date. */
	private final int year;
	/** Is the current date in a leap year ? */
	private final boolean isLeapYear;
	
	public Date(
			final int day,
			final int month,
			final int year) throws DateFormatException {
		this(day, month, year, true);
	}
	
	private Date(
			final int day,
			final int month,
			final int year,
			final boolean validate) throws DateFormatException {
		this.day = day;
		this.month = month;
		this.year = year;
		
		// LEAP YEAR: divisible by 4, not by 100 except if divisible by 400
		if (getYear() % 400 == 0 ||
			(getYear() % 100 != 0 && getYear() % 4 == 0))
			isLeapYear = true;
		else
			isLeapYear = false;
		
		if (validate && !isValidDate(day, month, year)) {
			throw new DateFormatException(
				"Invalid date (" +
				day + ", " + month + ", " + year +
				") ! Expected a date in the range " +
				getEpoch().toString() + " to " + getApocalypse().toString());
		}
	}
	
	public static Date getEpoch() {
		if (DATE_MIN == null) {
			try {
				DATE_MIN = new Date(
						DATE_MIN_DAY, DATE_MIN_MONTH, DATE_MIN_YEAR, false);
			}
			catch (final DateFormatException dfe) {}
		}
		
		return DATE_MIN;
	}
	public static Date getApocalypse() {
		if (DATE_MAX == null) {
			try {
				DATE_MAX = new Date(
						DATE_MAX_DAY, DATE_MAX_MONTH, DATE_MAX_YEAR, false);
			}
			catch (final DateFormatException dfe) {}
		}
		
		return DATE_MAX;
	}
	
	/**
	 * Returns true if this date is before the after date, i.e.
	 * this date is at least one day before the after date.
	 * @param after the date that may be after this date.
	 * @return true if the current date is at least one day before the after
	 * date.
	 */
	public boolean before(final IDate after) {
		return !after(after);
	}
	
	/**
	 * Returns true if this date is before the after date, i.e.
	 * this date is at least one day before the after date.
	 * @param afterDay the day of the date that may be after this date.
	 * @param afterMonth the month of the date that may be after this date.
	 * @param afterYear the year of the date that may be after this date.
	 * @return true if the current date is at least one day before the after
	 * date.
	 */
	public boolean before(
			final int afterDay, final int afterMonth, final int afterYear) {
		return !after(	getDay(), getMonth(), getYear(),
						afterDay, afterMonth, afterYear);
	}
	
	/**
	 * Returns true if this date is exactly the same date as the now date.
	 * 
	 * This method uses the result of the compareTo method.
	 * @param now the date that may be the same as this date.
	 * @return true if this date is exactly the same date as the now date, false
	 * otherwise.
	 */
	public boolean sameDate(final IDate now) {
		return	sameDate(now.getDay(), now.getMonth(), now.getYear());
	}
	
	/**
	 * Returns true if this date is exactly the same date as the now date.
	 * 
	 * @param day the day of the date that may be the same as this date.
	 * @param month the month of the date that may be the same as this date.
	 * @param year the year of the date that may be te same as this date.
	 * @return true if this date is exactly the same date as the now date, false
	 * otherwise.
	 */
	public boolean sameDate(final int day, final int month, final int year) {
		return	(getDay() - day == 0) &&
				(getMonth() - month == 0) &&
				(getYear() - year == 0);
	}
	
	/**
	 * Returns true if this date is after the before date, i.e.
	 * this date is at least one day after the before date.
	 * @param before the date that me be before this date.
	 * @return true if the current date is at least one day after the before
	 * date.
	 */
	public boolean after(final IDate before) {
		return after(	getDay(), getMonth(), getYear(),
						before.getDay(), before.getMonth(), before.getYear());
	}
	
	/**
	 * Returns true if this date is after the before date, i.e.
	 * this date is at least one day after the before date.
	 * @param beforeDay the day of the date that may be before this date.
	 * @param beforeMonth the month of the date that may be before this date.
	 * @param beforeYear the year of the date that may be before this date.
	 * @return true if the current date is at least one day after the before
	 * date.
	 */
	public boolean after(
			final int beforeDay, final int beforeMonth, final int beforeYear) {
		return after(	getDay(), getMonth(), getYear(),
						beforeDay, beforeMonth, beforeYear);
	}
	
	/**
	 * Returns true if this date is after the before date, i.e.
	 * this date is at least one day after the before date.
	 * @param day the day of the current date.
	 * @param month the month of the current date.
	 * @param year the year of the current date.
	 * @param beforeDay the day of the date that may be before this date.
	 * @param beforeMonth the month of the date that may be before this date.
	 * @param beforeYear the year of the date that may be before this date.
	 * @return true if the current date is at least one day after the before
	 * date.
	 */
	protected boolean after(
			final int day, final int month, final int year,
			final int beforeDay, final int beforeMonth, final int beforeYear) {
		// SAME DATE
		if (day == beforeDay && month == beforeMonth && year == beforeYear)
			return false;
		
		// CURRENT YEAR IS AFTER THE YEAR OF BEFORE DATE -> TRUE
		if (year - beforeYear > 0)
			return true;
		
		// CURRENT YEAR IS BEFORE THE YEAR OF BEFORE DATE -> FALSE
		if (year - beforeYear < 0)
			return false;
		
		// CURRENT YEAR == YEAR OF BEFORE DATE
		
		// CURRENT MONTH IS AFTER THE MONTH OF THE BEFORE DATE -> TRUE
		if (month - beforeMonth > 0)
			return true;
		
		// CURRENT MONTH IS BEFORE THE MONTH OF BEFORE DATE -> FALSE
		if (month - beforeMonth < 0)
			return false;
		
		// CURRENT MONTH == MONTH OF BEFORE DATE
		
		// CURRENT DAY IS AFTER THE DAY OF BEFORE DATE -> TRUE
		if (day - beforeDay > 0)
			return true;
		
		return false;
	}
	
	public static boolean isValidDate(
			final int day,
			final int month,
			final int year) {
		return	(Pattern.matches(BASIC_DATE_PATTERN,
					day + DATE_SEPARATOR + month + DATE_SEPARATOR + year) &&
				getEpoch().before(day, month, year) &&
				getApocalypse().after(day, month, year)) ||
				(getEpoch().sameDate(day, month, year) ||
				getApocalypse().sameDate(day, month, year));
	}
	
	/**
	 * Returns true if a call to parse(dateString) completes without a 
	 * DateFormatException.
	 * @param dateString the String containing a date.
	 * @return true if the dateString can be parsed into a Date object without
	 * causing a DateFormatException, false otherwise.
	 */
	public static boolean isValidDateString(final String dateString) {
		try {
			parse(dateString);
		}
		catch (final DateFormatException dfe) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Parses a date string into a Date object.
	 * @param dateString the String containing a date.
	 * @return a Data object constructed from the given String.
	 * @throws DateFormatException if the dateString does not comply with
	 * the format constraints or the minimum and maximum date constraints.
	 */
	public static Date parse(final String dateString)
	throws DateFormatException {
//		final Matcher matcher = BASIC_DATE_PATTERN.matcher(dateString);
//		
//		if (matcher.matches()) {
//			final int day = new Integer(matcher.group(1));
//			final int month = new Integer(matcher.group(2));
//			final int year = new Integer(matcher.group(3));
//			
//			if (isValidDate(day, month, year))
//				return new Date(day, month, year);
//		}
		final String[] parts = dateString.split(DATE_SEPARATOR);
		
		if (parts.length >= 3) {
			return new Date(
					new Integer(parts[0]),		// day
					new Integer(parts[1]),		// month
					new Integer(parts[2]));		// year
		}
		
		// Less than 3 date parts
		throw new DateFormatException(
			"Invalid date format: too few date parts or invalid separator (" +
			dateString +
			") ! Expected a date in the range " +
			DATE_MIN_STRING + " to " + DATE_MAX_STRING + 
			" (date separator: " + DATE_SEPARATOR + ")");
	}
	
	/**
	 * Returns true if this Date is in a leap year, false otherwise.
	 * @return true if this Date is in a leap year, false otherwise.
	 */
	public final boolean isLeapYear() {
		return isLeapYear;
	}
	
	@Override
	public int getDay() {
		return day;
	}

	@Override
	public int getMonth() {
		return month;
	}

	@Override
	public int getYear() {
		return year;
	}
	
	@Override
	public final String toString() {
		return	getDay() + DATE_SEPARATOR +
				getMonth() + DATE_SEPARATOR +
				getYear();
	}
	
	@Override
	public final boolean equals(final Object date) {
		if (!(date instanceof Date)) return false;
		
		return equals((Date)date);
	}
	
	/**
	 * Compares the current date with the provided date and returns true if
	 * they hold the same date, false otherwise.
	 * @param date the date to compare to.
	 * @return true if the provided date and the current date hold the same
	 * values for day, month and year, false otherwise.
	 */
	public final boolean equals(final Date date) {
		return	getDay() == date.getDay() &&
				getMonth() == date.getMonth() &&
				getYear() == date.getYear();
	}
	
	@Override
	public final int hashCode() {
		int hash = 7;
		
		hash = 31 * hash * getDay();
		hash = 31 * hash * getMonth();
		hash = 31 * hash * getYear();
		
		return hash;
	}
	
	@Override
	public final int compareTo(final Date date) {
		if (sameDate(date)) return 0;
		
		if (before(date)) return -1;
		
		return 1;
	}
}
