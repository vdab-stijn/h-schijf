package be.vdab.model;

import java.util.Comparator;

public abstract class Product implements Comparable<Product> {

	/** The product number of this product. */
	private int productNumber;
	/** The brand of this product. */
	private String brand;
	/** The name of this product. */
	private String name;
	/** The volume of this product. */
	private int volume;
	/** The price of this product. */
	private double price;
	
	/** The product code. */
	private String code = null;
	
	/**
	 * Constructor for this product.
	 * 
	 * @param productNumer the product number of this product.
	 * @param brand the brand of this product.
	 * @param name the name of this product.
	 * @param volume the volume of this product.
	 * @param price the price of this product.
	 */
	protected Product(
			final int productNumer,
			final String brand,
			final String name,
			final int volume,
			final double price) {
		setProductNumber(productNumber);
		setBrand(brand);
		setName(name);
		setVolume(volume);
		setPrice(price);
	}
	
	/**
	 * Sets the product number of this product.
	 * @param productNumber the product number of this product.
	 */
	public final void setProductNumber(final int productNumber) {
		this.productNumber = productNumber;
	}
	/**
	 * Returns the product number of this product.
	 * @return the product number of this product.
	 */
	public final int getProductNumber() {
		return productNumber;
	}
	
	/**
	 * Sets the brand of this product.
	 * @param brand the brand of this product.
	 */
	public final void setBrand(final String brand) {
		this.brand = brand;
	}
	/**
	 * Returns the brand of this product.
	 * @return the brand of this product.
	 */
	public final String getBrand() {
		return brand;
	}
	
	/**
	 * Sets the name of this product.
	 * @param name the name of this product.
	 */
	public final void setName(final String name) {
		this.name = name;
	}
	/**
	 * Returns the name of this product.
	 * @return the name of this product.
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Sets the volume of this product.
	 * @param volume the volume of this product.
	 */
	public final void setVolume(final int volume) {
		this.volume = volume;
	}
	/**
	 * Returns the volume of this product.
	 * @return the volume of this product.
	 */
	public final int getVolume() {
		return volume;
	}
	
	/**
	 * Sets the price of this product.
	 * @param price the price of this products
	 */
	public final void setPrice(final double price) {
		this.price = price;
	}
	/**
	 * Returns the price of this product.
	 * @return the price of this product.
	 */
	public final double getPrice() {
		return price;
	}
	
	public final String getProductCode() {
		if (code == null) {
			code  = String.format("%.3s", getBrand().toUpperCase())
						.replaceAll(" ",  "_");
			code += String.format("%.3s", getName().toUpperCase())
						.replaceAll(" ",  "_");
			code += getVolume();
		}
		
		return code;
	}
	
	/*
	 * VRAAG 2c:
	 * 		Zorg dat de natuurijke volgorde van Product sorteert op
	 * 		productnummer.
	 */
	@Override
	public final int compareTo(final Product product) {
		if (getProductNumber() == product.getProductNumber())
			return 0;
		
		if (getProductNumber() < product.getProductNumber())
			return -1;
		
		return 1;
	}
	
	/**
	 * Returns a {@link java.util.Comparator} that sorts two products by brand
	 * name.
	 * @return a {@link java.util.Comparator} that sorts two products by brand
	 * name.
	 */
	/*
	 * VRAAG e:
	 * 		Schrijf een statische methode "sorteerOpMerkNaam" die een
	 * 		comparator object teruggeeft van het type Product.
	 */
	public final static Comparator<Product> sortByBrand() {
		return (o1, o2) -> o1.getBrand().compareTo(o2.getBrand());
	}
	
	/*
	 * VRAAG f:
	 * 		Override de toString() methode: Kijk voor een goede implementatie
	 * 		van deze methode even naar de printscreen op pagina 3. Maak
	 * 		gebruik van de FORMAT methode !
	 * 
	 * 		(4)<product number>
	 * 		()Merk: <brand>
	 * 		()Naam: <name>
	 * 		()Volume: <volume>
	 * 		()Prijs: <price>
	 * 		()Code: <getProductCode()>
	 * 		()
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return 	String.format("%1$-5s", getProductNumber()) +
				"Merk: " + String.format("%1$-25s", getBrand()) +
				"Naam: " + String.format("%1$-25s", getName()) +
				"Volume: " + String.format("%3d", getVolume()) + "ml     " +
				"Prijs: " + String.format("%3.2f", getPrice()) + "    " +
				"Code: " + String.format("%1$-15s", getProductCode());
	}
}
