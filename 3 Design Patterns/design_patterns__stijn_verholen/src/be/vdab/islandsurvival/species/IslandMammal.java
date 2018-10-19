package be.vdab.islandsurvival.species;

public class IslandMammal extends IslandFauna {

	public IslandMammal(final String name) {
		super(name);
	}

	@Override
	public void reactToEruption() {
		printReaction("hides in a cave");
	}
}
