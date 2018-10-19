package be.vdab.console;

import java.util.List;

import be.vdab.model.Product;
import be.vdab.persistence.Data;
import be.vdab.persistence.Order;
import be.vdab.persistence.OrderImpl;

public class TestSave {

	public static void main(final String[] args) {
		final Order order = new OrderImpl();
        final List<Product> list = Data.getData();

        for (Product artikel : list) {
            //order.voegProductToe(artikel);
        	order.addProduct(artikel);
        }
		
		order.saveProductsList();
	}
}
