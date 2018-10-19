package be.vdab.islandsurvival.species;

public class IslandBird extends IslandFauna {
	
	public IslandBird(final String name) {
		super(name);
	}
	
	@Override
	public void reactToEruption() {
		printReaction("flies to higher ground");
	}
}
