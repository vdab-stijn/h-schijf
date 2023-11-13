package be.vdab.persistence;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import be.vdab.model.Product;

public class OrderImpl implements Order {
	
	public static final Path PRODUCTS_STORE
	= Paths.get(System.getProperty("user.home") + "/Desktop/merkproducten.dat");

	List<Product> products = new ArrayList<>();
	
	private static int PRODUCT_NUMBER = 1000;
	
	public OrderImpl() {
		
	}
	
	@Override
	public final double totalPrice() {
		return products.stream()
				.mapToDouble(product -> product.getPrice())
				.sum();
	}

	@Override
	public final void addProduct(Product product) {
		product.setProductNumber(PRODUCT_NUMBER);
		products.add(product);
		
		PRODUCT_NUMBER++;
	}

	@Override
	public final void sort() {
		products.stream()
			.sorted()
			.collect(Collectors.toList())
			.forEach(p -> System.out.println(p));
	}

	@Override
	public final void sortByBrand() {
		products.stream()
			.sorted(Product.sortByBrand())
			.collect(Collectors.toList())
			.forEach(p -> System.out.println(p));
	}

	@Override
	public final void sortByVolume() {
		products.stream()
			.sorted(Comparator.comparing(Product::getVolume))
			.forEach(p -> System.out.println(p));
	}

	@Override
	public final void displayByBrand(final String brand) {
		products.stream()
			.filter(p -> p.getBrand().equalsIgnoreCase(brand))
			.forEach(p -> System.out.println(p));
	}

	@Override
	public final void displayCheapestProducts() {
		products.stream()
			.filter(p -> p.getPrice() <  50d)
			.forEach(p -> System.out.println(p));;
	}

	@Override
	public final void displayPerfumes() {
		products.stream()
			.filter(p -> p instanceof be.vdab.model.Perfume)
			.forEach(p -> System.out.println(p));
	}

	@Override
	public final Product findMostExpensiveProduct() {
		return products.stream()
				.max(Comparator.comparing(Product::getPrice))
				.get();
	}
	
	public final void saveProductsList() {
		try (final BufferedWriter writer = Files.newBufferedWriter(PRODUCTS_STORE)) {
			for (final Product p : products) {
				writer.write(p.toString());
				writer.write("\r\n");
			}
		}
		catch (final IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}
}
