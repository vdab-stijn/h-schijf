package be.vdab.model;

public class Deodorant extends Product {
	
	/** The implementation type of this deodorant product. */
	private DeoType type;
	
	/**
	 * Construct a new Deodorant product with the given arguments.
	 * 
	 * @param productNumber the product number of this product.
	 * @param brand the brand of this product.
	 * @param name the name of this product.
	 * @param volume the volume of this product.
	 * @param price the price of this product.
	 * @param type the implementation type of this deodorant product.
	 */
	public Deodorant(
			final int productNumber,
			final String brand,
			final String name,
			final int volume,
			final double price,
			final DeoType type) {
		super(productNumber, brand, name, volume, price);
		
		setType(type);
	}
	
	/**
	 * Sets the implementation type of this deodorant product.
	 * @param type the implementation type of this deodorant product.
	 */
	public final void setType(final DeoType type) {
		this.type = type;
	}
	/**
	 * Returns the implementation type of this deodorant product.
	 * @return the implementation type of this deodorant product.
	 */
	public final DeoType getType() {
		return type;
	}
	
	@Override
	public final String toString() {
		return super.toString() + " " + getType().name();
	}
	
	/**
	 * The implementation type of a deodorant product.
	 * 
	 * Valid values are VAPO and STICK.
	 * 
	 * @author stijn.verholen
	 */
	public enum DeoType {
		VAPO, STICK;
	}
}
