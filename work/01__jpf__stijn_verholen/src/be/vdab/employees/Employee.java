package be.vdab.employees;

import java.math.BigDecimal;

import be.vdab.util.EmployeeDate;

public abstract class Employee implements Comparable<Employee> {

	private final int number;
	
	private EmployeeDate dateEnlisted;
	private String name;
	private Gender gender;
	
	public Employee(
			final int number,
			final String name,
			final Gender gender,
			final EmployeeDate dateEnlisted)
	throws EmployeeException {
		if (number <= 0)
			throw new EmployeeException(
					"Employee numbers must be greater than 0 (" + number + ")");
		
		this.number = number;
		
		setName(name);
		setGender(gender);
		setDateEnlisted(dateEnlisted);
	}
	
	public abstract BigDecimal getMonthlyWage();
	
	public final int getNumber() {
		return number;
	}
	
	public final void setName(final String name) {
		this.name = name;
	}
	public final String getName() {
		return name;
	}
	
	public final void setGender(final Gender gender) {
		this.gender = gender;
	}
	public final Gender getGender() {
		return gender;
	}
	
	public final void setDateEnlisted(final EmployeeDate dateEnlisted) {
		this.dateEnlisted = dateEnlisted;
	}
	public final EmployeeDate getDateEnlisted() {
		return dateEnlisted;
	}
	
	@Override
	public final String toString() {
		return	getNumber() + "\t" +
				getDateEnlisted().toString() + "\t" +
				getName() + "\t" +
				getGender() + "\t" +
				getMonthlyWage().toString();
	}
	
	@Override
	public final boolean equals(final Object employee) {
		if (!(employee instanceof Employee)) return false;
		
		return equals((Employee)employee);
	}
	
	/**
	 * Compares this Employee object with the provided Employee object and
	 * returns true if they have the same employee number, false otherwise.
	 * @param employee the Employee object to compare with.
	 * @return true if they have the same employee number, false otherwise.
	 * @param employee the Employee object to compare with.
	 */
	public final boolean equals(final Employee employee) {
		return getNumber() == employee.getNumber();
	}
	
	@Override
	public final int hashCode() {
		return (int)(31 * 7 * getNumber()); 
	}
	
	@Override
	public int compareTo(final Employee employee) {
		return getNumber() - employee.getNumber();
	}
	
	public enum Gender {
		MALE('m'), FEMALE('f');
		
		//private final char gender;
		
		private Gender(final char gender) {
			//this.gender = gender;
		}
		
		public static Gender parse(final String gender) {
			if (gender.equalsIgnoreCase("male") ||
				gender.equalsIgnoreCase("m"))
				return MALE;
			else
				return FEMALE;
		}
	}
}
