package com.halohoop.factorypattern;

/**
 * 抽象工厂方法
 * @author Pooholah
 *
 */
public abstract class Factory {
	public abstract <T extends Product> T createProduct(Class<T> clz);
}
