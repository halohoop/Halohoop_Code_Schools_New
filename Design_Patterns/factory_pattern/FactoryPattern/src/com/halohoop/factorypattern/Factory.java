package com.halohoop.factorypattern;

/**
 * ���󹤳�����
 * @author Pooholah
 *
 */
public abstract class Factory {
	public abstract <T extends Product> T createProduct(Class<T> clz);
}
