package com.halohoop.factorypattern;

public class Client {

	public static void main(String[] args) {
		Factory factory = new ConreteFactory();
		ProductA productA = factory.createProduct(ProductA.class);
		productA.function1();
		productA.function2(2);
		System.out.println("--------------------");
		ProductB productB = factory.createProduct(ProductB.class);
		productB.function1();
		productB.function2(2);
	}

}
