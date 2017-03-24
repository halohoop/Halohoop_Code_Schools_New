package com.halohoop.factorypattern;

public class ProductB extends Product {

	@Override
	void function1() {
		System.out.println("ProductB func1");
	}

	@Override
	void function2(int param) {
		System.out.println("ProductB func2+param:"+param);
	}


}
