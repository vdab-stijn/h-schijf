package be.vdab.islandsurvival;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import be.vdab.islandsurvival.species.IslandFauna;

public class Island extends Observable {
	
	private final List<IslandFauna> inhabitants
	= new ArrayList<>();
	
	private String owner;
	private int[] volcanoes;
	
	public Island(final String owner, final int numberOfVulcanoes) {
		setOwner(owner);
		createVulcanoes(numberOfVulcanoes);
	}
	
	private final void setOwner(final String owner) {
		this.owner = owner;
	}
	public final String getOwner() {
		return owner;
	}
	
	private final void createVulcanoes(final int numberOfVolcanoes) {
		volcanoes = new int[numberOfVolcanoes];
		
		for (int i = 0; i < numberOfVolcanoes; i++) {
			volcanoes[i] = i;
		}
	}
	public final String getVulcano(final int index) {
		if (index < 0 || index > volcanoes.length) {
			throw new IllegalArgumentException(
					"Unknown volcano (" + index + ") !");
		}
		
		return "Volcano " + volcanoes[index];
	}
	public final String getRandomVolcano() {
		return getVulcano(new Random().nextInt(volcanoes.length));
	}
	public final int[] getVolcanoes() {
		return volcanoes;
	}
	
	public final void erupt(final String volcano) {
		IslandSurvival.printLine();
		System.out.println(volcano + " has erupted !");
		IslandSurvival.printLine();
		
		setChanged();
		notifyObservers();
		IslandSurvival.printLine();
	}
	
//	public final void addSpecies(final IslandFauna newSpecies) {
//		for (final IslandFauna knownSpecies : inhabitants) {
//			if (knownSpecies.equals(newSpecies)) {
//				throw new IllegalArgumentException(
//						"This species is already on the island !");
//			}
//		}
//	}
	
	public final void addInhabitant(final IslandFauna inhabitant) {
		inhabitants.add(inhabitant);
		addObserver(inhabitant);
		
		System.out.println(inhabitant.getName() + " has moved to the island");
	}
}
