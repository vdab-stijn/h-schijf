package be.vdab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;

import be.vdab.employees.Clerk;
import be.vdab.employees.Employee;
import be.vdab.employees.EmployeeException;
import be.vdab.employees.Worker;
import be.vdab.util.DateFormatException;
import be.vdab.util.EmployeeDate;
import be.vdab.util.Logger;
import be.vdab.employees.Employee.Gender;
import be.vdab.employees.Officer.FunctionTitle;
import be.vdab.employees.Officer;

public class Company {

	public static final Path EMPLOYEE_DB = Paths.get("personeel.dat");

	private final SortedSet<Employee> employees = new TreeSet<>();

	public Company() {

	}

	private final void fillEmployeeFile() throws DateFormatException, EmployeeException {
		Logger.log("Creating worker 'Jos Dendaas'");
		final Worker jos = new Worker(3268, "Jos Dendaas", Gender.MALE, EmployeeDate.parse("12/2/1977"),
				new BigDecimal(12.23d));
		employees.add(jos);

		Logger.log("Creating worker 'Bob Bobbit'");
		final Worker bob = new Worker(3456, "Bob Bobbit", Gender.MALE, EmployeeDate.parse("1/3/1987"),
				new BigDecimal(10.5d));
		employees.add(bob);

		Logger.log("Creating cleark 'Suzy'");
		final Clerk suzy = new Clerk(3060, "Suzy 38D", Gender.FEMALE, EmployeeDate.parse("20/4/1978"),
				new BigDecimal(1683.50d));
		employees.add(suzy);

		Logger.log("Creating clerk 'Brenda Bellen'");
		final Clerk brenda = new Clerk(4836, "Brenda Bellen", Gender.FEMALE, EmployeeDate.parse("1/1/2018"),
				new BigDecimal(1468.90d));
		employees.add(brenda);

		Logger.log("Creating CEO 'Jean-Jacques Bellen'");
		final Officer jacques = new Officer(1, "Jean-Jacques 'Jacky' Bellen", Gender.MALE,
				EmployeeDate.parse("12/2/1977"), new BigDecimal(12689.63d), FunctionTitle.CEO);
		employees.add(jacques);
	}

	private final void printEmployeeFile() {
		for (final Employee employee : employees)
			System.out.println(employee);
	}

	private final void saveEmployeeFile() {
		try (BufferedWriter writer = Files.newBufferedWriter(EMPLOYEE_DB)) {
			for (final Employee employee : employees) {
				writer.write(employee.toString());
				writer.write("\n");
				writer.flush();
			}
		} catch (final IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}

	public static void main(final String[] args) {
		final Company company = new Company();

		try {
			company.fillEmployeeFile();
		} catch (final DateFormatException dfe) {
			System.err.println(dfe.getMessage());
		} catch (final EmployeeException ee) {
			System.err.println(ee.getMessage());
		}

		company.printEmployeeFile();
		company.saveEmployeeFile();
	}
}
