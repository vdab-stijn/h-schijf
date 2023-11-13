package be.vdab;

import java.util.ArrayList;
import java.util.List;

import be.vdab.util.Date;
import be.vdab.util.DateFormatException;
import be.vdab.util.EmployeeDate;

public class DateTest {

	public static void main(final String[] args) {
		System.out.println("TESTING VALID DATES");
		testValidDates();
		
		System.out.println("\nTESTING INVALID DATES");
		testInvalidDates();
		
		System.out.println("\nTESTING VALID EMPLOYEE DATES");
		testValidEmployeeDates();
		
		System.out.println("\nTESTING INVALID EMPLOYEE DATES");
		testInvalidEmployeeDates();
		
		System.out.println("\n\nAll tests completed");
	}
	
	private static final void testValidDates() {
		List<String> dates = new ArrayList<>();
		
		for (int i = Date.DATE_MIN_YEAR; i < Date.DATE_MAX_YEAR + 1; i++) {
		for (int j = Date.DATE_MIN_MONTH; j < Date.DATE_MAX_MONTH + 1; j++) {
		for (int k = Date.DATE_MIN_DAY; k < Date.DATE_MAX_DAY + 1; k++) {
			dates.add(k + Date.DATE_SEPARATOR + j + Date.DATE_SEPARATOR + i);
		}}}
		
		for (final String dateString : dates) {
			try {
				Date.parse(dateString);
			}
			catch (final DateFormatException dfe) {
				System.err.println("INVALID DATE -> " + dateString);
				dfe.printStackTrace(System.err);
			}
		}
	}
	
	private static final void testValidEmployeeDates() {
		List<String> dates = new ArrayList<>();
		
		for (int i = EmployeeDate.DATE_MIN_YEAR; i < Date.DATE_MAX_YEAR + 1; i++) {
		for (int j = EmployeeDate.DATE_MIN_MONTH; j < Date.DATE_MAX_MONTH + 1; j++) {
		for (int k = EmployeeDate.DATE_MIN_DAY; k < Date.DATE_MAX_DAY + 1; k++) {
			dates.add(k + Date.DATE_SEPARATOR + j + Date.DATE_SEPARATOR + i);
		}}}
		
		for (final String dateString : dates) {
			try {
				EmployeeDate.parse(dateString);
			}
			catch (final DateFormatException dfe) {
				System.err.println("INVALID EMPLOYEE DATE -> " + dateString);
			}
		}
			
	}
	
	private static final void testInvalidDates() {
		List<String> dates = new ArrayList<>();
		
		// 1/1/1581
		dates.add(
				Date.DATE_MIN_DAY + Date.DATE_SEPARATOR +
				Date.DATE_MIN_MONTH + Date.DATE_SEPARATOR +
				(Date.DATE_MIN_YEAR - 3));
		// 0/0/0
		dates.add(0 + Date.DATE_SEPARATOR + 0 + Date.DATE_SEPARATOR + 0);
		dates.add(
				Date.DATE_MIN_DAY + Date.DATE_SEPARATOR +
				(Date.DATE_MIN_MONTH - 1) + Date.DATE_SEPARATOR +
				Date.DATE_MIN_YEAR);
		// 0/1/1584
		dates.add(
				(Date.DATE_MIN_DAY - 1) + Date.DATE_SEPARATOR +
				Date.DATE_MIN_MONTH + Date.DATE_SEPARATOR +
				Date.DATE_MIN_YEAR);
		// 31/12/4100
		dates.add(
				Date.DATE_MAX_DAY + Date.DATE_SEPARATOR +
				Date.DATE_MAX_MONTH + Date.DATE_SEPARATOR +
				(Date.DATE_MAX_YEAR + 1));
//		// 31/12/4099/
//		dates.add(
//				Date.DATE_MAX_DAY + Date.DATE_SEPARATOR +
//				Date.DATE_MAX_MONTH + Date.DATE_SEPARATOR +
//				Date.DATE_MAX_YEAR + Date.DATE_SEPARATOR);
		
		for (final String dateString : dates) {
			try {
				Date.parse(dateString);
			}
			catch (final DateFormatException dfe) {
				continue;
			}
			System.err.println("INVALID DATE NOT CAUGHT -> " + dateString);
		}
	}
	
	private static final void testInvalidEmployeeDates() {
		List<String> dates = new ArrayList<>();
		
		// 1/1/1581
		dates.add(
				EmployeeDate.DATE_MIN_DAY + Date.DATE_SEPARATOR +
				EmployeeDate.DATE_MIN_MONTH + Date.DATE_SEPARATOR +
				(EmployeeDate.DATE_MIN_YEAR - 3));
		// 0/0/0
		dates.add(0 + Date.DATE_SEPARATOR + 0 + Date.DATE_SEPARATOR + 0);
		dates.add(
				EmployeeDate.DATE_MIN_DAY + Date.DATE_SEPARATOR +
				(EmployeeDate.DATE_MIN_MONTH - 1) + Date.DATE_SEPARATOR +
				EmployeeDate.DATE_MIN_YEAR);
		// 0/1/1584
		dates.add(
				(EmployeeDate.DATE_MIN_DAY - 1) + Date.DATE_SEPARATOR +
				EmployeeDate.DATE_MIN_MONTH + Date.DATE_SEPARATOR +
				EmployeeDate.DATE_MIN_YEAR);
		// 31/12/4100
		dates.add(
				Date.DATE_MAX_DAY + Date.DATE_SEPARATOR +
				Date.DATE_MAX_MONTH + Date.DATE_SEPARATOR +
				(Date.DATE_MAX_YEAR + 1));
//		// 31/12/4099/
//		dates.add(
//				Date.DATE_MAX_DAY + Date.DATE_SEPARATOR +
//				Date.DATE_MAX_MONTH + Date.DATE_SEPARATOR +
//				Date.DATE_MAX_YEAR + Date.DATE_SEPARATOR);
		
		for (final String dateString : dates) {
			try {
				EmployeeDate.parse(dateString);
			}
			catch (final DateFormatException dfe) {
				System.out.println(dfe.getMessage());
				continue;
			}
			System.err.println(
					"INVALID EMPLOYEE DATE NOT CAUGHT -> " + dateString);
		}
	}
}
