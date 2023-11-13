package be.vdab.employees;

import java.math.BigDecimal;

import be.vdab.util.EmployeeDate;

public class Officer extends Clerk {

	private FunctionTitle functionTitle;
	
	public Officer(
			final int number,
			final String name,
			final Gender gender,
			final EmployeeDate dateEnlisted,
			final BigDecimal monthlyWage,
			final FunctionTitle functionTitle)
	throws EmployeeException {
		super(number, name, gender, dateEnlisted, monthlyWage);
		
		setFunctionTitle(functionTitle);
	}
	
	public final void setFunctionTitle(final FunctionTitle functionTitle) {
		this.functionTitle = functionTitle;
	}
	public final FunctionTitle getFunctionTitle() {
		return functionTitle;
	}
	
	public enum FunctionTitle {
		DIRECTOR, CEO, MANAGER;
	}
}
