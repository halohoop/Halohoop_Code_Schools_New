package com.halohoop.lock;

/**
 * À¿À¯demo
 * 
 * @author Pooholah
 *
 */
public class RecycleLockDemo {

	private static Object obj1 = new Object();
	private static Object obj2 = new Object();

	public static void main(String[] args) {
		//thread1
		new Thread() {
			public void run() {
				synchronized (obj1) {
					System.out.println("thread1 required obj1");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (obj2) {
						System.out.println("thread1 required obj2");
					}
				}
			};
		}.start();
		//thread2
		new Thread() {
			public void run() {
				synchronized (obj2) {
					System.out.println("thread2 required obj2");
					synchronized (obj1) {
						System.out.println("thread2 required obj1");
					}
				}
			};
		}.start();
	}
}
