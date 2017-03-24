package com.halohoop.factorypattern;

public class ProductA extends Product {

	@Override
	void function1() {
		System.out.println("ProductA func1");
	}

	@Override
	void function2(int param) {
		System.out.println("ProductA func2+param:"+param);
	}

}
