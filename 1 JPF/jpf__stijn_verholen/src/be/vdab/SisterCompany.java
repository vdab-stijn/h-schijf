package be.vdab;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SisterCompany {

	public static final Path EMPLOYEE_DB = Paths.get("personeel.dat");
	
	public static void main(final String[] args) {
		System.out.println("PERSONEELSBESTAND VAN MOEDERBEDRIJF:");
		try (BufferedReader reader = Files.newBufferedReader(EMPLOYEE_DB)) {
			for (String data; (data = reader.readLine()) != null;) {
				System.out.println(data);
			}
		}
		catch (final IOException ioe) {
			ioe.printStackTrace(System.err);
		}
		System.out.println("=================================================");
	}
}
