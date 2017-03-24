package com.halohoop.abstractfactorypattern;


public class Client {

	public static void main(String[] args) {
		AbstractFactory factory1 = new ConcreteFactory1();
		AbstractProductA createProductA = factory1.createProductA();
		AbstractProductB createProductB = factory1.createProductB();
		createProductA.func();
		createProductB.func();
		System.out.println("-------------------");
		AbstractFactory factory2 = new ConcreteFactory2();
		AbstractProductA createProductA2 = factory2.createProductA();
		AbstractProductB createProductB2 = factory2.createProductB();
		createProductA2.func();
		createProductB2.func();
	}

}
