package be.vdab.islandsurvival;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import be.vdab.islandsurvival.species.IslandFaunaFactory;

public class IslandSurvival {

	private final Island island;
	private final EventGenerator generator;
	
	public IslandSurvival(final Island island, final EventGenerator generator) {
		this.island = island;
		this.generator = generator;
	}
	
	public final Island getIsland() { return island; }
	public final EventGenerator getGenerator() { return generator; }
	
	private final void loadFauna(final String dataFileName) {
		final Path dataFile = Paths.get(dataFileName);
		
		try (final BufferedReader reader = Files.newBufferedReader(dataFile)) {
			for (String line = reader.readLine(); (line = reader.readLine()) != null; ) {
				island.addInhabitant(IslandFaunaFactory.getInstance().getFauna(line));
			}
		}
		catch (final IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}
	
	public static final void printLine() {
		System.out.println("=============================================================");
	}
	public final void printWelcome() {
		printLine();
		System.out.println("~ I ~ S ~ L ~ A ~ N ~ D ~ ~ ~ S ~ U ~ R ~ V ~ I ~ V ~ A ~ L ~");
		printLine();
		System.out.println("Welcome to the island of " + island.getOwner());
		System.out.println("This island has " + island.getVolcanoes().length +
				" active volcano" +
				(island.getVolcanoes().length != 1 ? "es" : ""));
		printLine();
		System.out.println("To stop the game, type 'APOCALYPSE'");
		printLine();
	}
	public final void printShutdown() {
		printLine();
		System.out.println("GOODBYE");
		printLine();
	}
	
	public final void beginGame() {
		generator.startGenerating(island);
	}
	public final void stopGame() {
		generator.stopGenerating();
	}
	
	public static void main(String[] args) {
		final IslandSurvival survival = new IslandSurvival(
				new Island("Doctor Moreau", 5),
				new EventGenerator(0, 1500));
		final Scanner scanner = new Scanner(System.in);
		
		survival.printWelcome();
		
		survival.loadFauna("dev/inhabitants.txt");
		survival.beginGame();
		
		while (!scanner.nextLine().equalsIgnoreCase("APOCALYPSE"));
		scanner.close();
		
		survival.stopGame();
		survival.printShutdown();
	}
}