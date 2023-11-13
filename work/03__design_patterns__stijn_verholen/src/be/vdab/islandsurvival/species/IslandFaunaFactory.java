package be.vdab.islandsurvival.species;

public class IslandFaunaFactory {

	private static IslandFaunaFactory instance;
	
	private IslandFaunaFactory() {}
	
	public static final IslandFaunaFactory getInstance() {
		if (instance == null) {
			instance = new IslandFaunaFactory();
		}
		
		return instance;
	}
	
	public final IslandMammal getMammal(final String name) {
		return new IslandMammal(name);
	}
	
	public final IslandBird getBird(final String name) {
		return new IslandBird(name);
	}
	
	public final IslandFauna getFauna(final String fromString) {
		final char typeIdentifier = fromString.toLowerCase().charAt(0);
		final String name = fromString.substring(1);
		
		final KnownFaunaType type = KnownFaunaType.parse(typeIdentifier);
		
		switch (type) {
			case BIRD: return getBird(name);
			case MAMMAL: return getMammal(name);
		}
		
		return null;
	}
	
	public enum KnownFaunaType {
		BIRD('b'), MAMMAL('m');
		
		private char typeIdentifier;
		
		private KnownFaunaType(final char typeIdentifier) {
			this.typeIdentifier = typeIdentifier;
		}
		
		public static final KnownFaunaType parse(final char typeIdentifier) {
			for (KnownFaunaType type : values()) {
				if (type.typeIdentifier == typeIdentifier)
					return type;
			}
			
			throw new IllegalArgumentException(
					"Unknown fauna type (" + typeIdentifier + ") !");
		}
	}
}
