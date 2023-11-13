package be.vdab.model;

public class Perfume extends Product {

	/**
	 * Construct a new perfume product.
	 * 
	 * @param productNumber the product number of this product.
	 * @param brand the brand of this product.
	 * @param name the name of this product.
	 * @param volume the volume of this product.
	 * @param price the price of this product.
	 */
	public Perfume(
			final int productNumber,
			final String brand,
			final String name,
			final int volume,
			final double price) {
		super(productNumber, brand, name, volume, price);
	}
}
