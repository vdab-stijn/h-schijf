package be.vdab.persistence;

@FunctionalInterface
public interface Calculable {

	/**
	 * Calculates the total price in this order.
	 * @return the total price in this order.
	 */
	public double totalPrice();
}
