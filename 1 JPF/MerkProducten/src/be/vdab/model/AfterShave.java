package be.vdab.model;

public class AfterShave extends Product {

	/** The implementation type of this aftershave product. */
	private AfterShaveType type;
	
	/**
	 * Constructs a new AfterShave product with the given arguments.
	 * 
	 * @param productNumber the product number of this product.
	 * @param brand the brand of this product.
	 * @param name the name of this product.
	 * @param volume the volume of this product.
	 * @param price the price of this product.
	 * @param type the implementation type of this aftershave.
	 */
	public AfterShave(
			final int productNumber,
			final String brand,
			final String name,
			final int volume,
			final double price,
			final AfterShaveType type) {
		super(productNumber, brand, name, volume, price);
		
		setType(type);
	}
	
	/**
	 * Sets the implementation type of this aftershave product.
	 * @param type the implementation type of this aftershave product.
	 */
	public final void setType(final AfterShaveType type) {
		this.type = type;
	}
	/**
	 * Returns the implementation type of this aftershave product.
	 * @return the implementation type of this aftershave product.
	 */
	public final AfterShaveType getType() {
		return type;
	}
	
	@Override
	public final String toString() {
		return super.toString() + " " + getType().name();
	}
	
	/**
	 * The implementation type of an aftershave product.
	 * 
	 * Valid values are VAPO and GEL.
	 * 
	 * @author stijn.verholen
	 */
	public enum AfterShaveType {
		VAPO, GEL;
	}
}
