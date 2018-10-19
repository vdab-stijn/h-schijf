package be.vdab.employees;

import java.math.BigDecimal;

import be.vdab.util.EmployeeDate;

public class Worker extends Employee {

	public static final BigDecimal MINIMUM_HOURLY_WAGE
	= new BigDecimal(9.76d);
	
	private BigDecimal hourlyWage;
	
	public Worker(
			final int number,
			final String name,
			final Gender gender,
			final EmployeeDate dateEnlisted,
			final BigDecimal hourlyWage)
	throws EmployeeException {
		super(number, name, gender, dateEnlisted);
		
		setHourlyWage(hourlyWage);
	}
	
	public final void setHourlyWage(final BigDecimal hourlyWage)
	throws EmployeeException {
		if (hourlyWage.compareTo(MINIMUM_HOURLY_WAGE) < 0)
			throw new EmployeeException(
					"Hourly wage must be greater than " + MINIMUM_HOURLY_WAGE);
		
		this.hourlyWage = hourlyWage;
	}
	public final BigDecimal getHourlyWage() {
		return hourlyWage;
	}
	public final BigDecimal getMonthlyWage() {
		return getHourlyWage()
				.multiply(new BigDecimal(7.6d * 65d / 3d))
				.setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}
}
