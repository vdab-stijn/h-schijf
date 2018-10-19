package be.vdab.persistence;

import be.vdab.model.Product;

public interface Order extends Calculable {

	public void addProduct(final Product product);
	
	/**
	 * Sorts all product in this order in their natural sort order.
	 */
	public void sort();
	
	/**
	 * Sorts all products in this order based on brand name.
	 * @see Product.sortByBrand()
	 */
	public void sortByBrand();
	
	/**
	 * Sorts all product in this order in ascending order of volume.
	 */
	public void sortByVolume();
	
	/**
	 * Displays all products from this brand in the current order.
	 * @param brand the brand to display products in this order of.
	 */
	public void displayByBrand(final String brand);
	
	/**
	 * Displays the products that cost less than 50 €.
	 */
	public void displayCheapestProducts();
	
	/**
	 * Displays all perfumes in the order.
	 */
	public void displayPerfumes();
	
	/**
	 * Finds the most expensive product in this order.
	 * @return the most expensive product in this order.
	 */
	public Product findMostExpensiveProduct();
	
	/**
	 * Saves the current product list to a file called 'merkproducten.dat'
	 * on the desktop.
	 */
	public void saveProductsList();
}
