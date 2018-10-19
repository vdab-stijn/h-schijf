package be.vdab.employees;

import java.math.BigDecimal;

import be.vdab.util.EmployeeDate;

public class Clerk extends Employee {

	public static final BigDecimal MINIMUM_MONTHLY_WAGE
	= new BigDecimal(1129.47d);
	
	private BigDecimal monthlyWage;
	
	public Clerk(
			final int number,
			final String name,
			final Gender gender,
			final EmployeeDate dateEnlisted,
			final BigDecimal monthlyWage)
	throws EmployeeException {
		super(number, name, gender, dateEnlisted);
		
		setMonthlyWage(monthlyWage);
	}
	
	public final void setMonthlyWage(final BigDecimal monthlyWage)
	throws EmployeeException {
		if (monthlyWage.compareTo(MINIMUM_MONTHLY_WAGE) < 0)
			throw new EmployeeException(
					"Monthly wage must be greater than " + MINIMUM_MONTHLY_WAGE);
		
		this.monthlyWage = monthlyWage;
	}
	@Override
	public final BigDecimal getMonthlyWage() {
		return monthlyWage.setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}
}
