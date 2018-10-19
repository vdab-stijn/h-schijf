package be.vdab.islandsurvival.species;

import java.util.Observable;
import java.util.Observer;

import be.vdab.islandsurvival.Island;

public abstract class IslandFauna implements Observer {

	private String name;
	
	public IslandFauna(final String name) {
		setName(name);
	}
	
	private final void setName(final String name) {
		this.name = name;
	}
	public final String getName() {
		return name;
	}

	@Override
	public void update(final Observable observable, final Object arg) {
		if (!(observable instanceof Island)) {
			throw new IllegalArgumentException();
		}
		
		reactToEruption();
	}
	
	public abstract void reactToEruption();
	
	protected void printReaction(final String reaction) {
		System.out.println(getName() + " " + reaction);
	}
}
