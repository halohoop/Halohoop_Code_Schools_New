# Single Instance Pattern

## 使用场景
### 1.当一个类臃肿的时候不希望有太多的实例被创建。

## 模式使用Demo
* 见下文。

## 特别注意
### 1.volatile关键字作用。
* 由于java编译器允许乱序执行，指令重排，DCL单例可能会在多线程的时候失效。在JDK1.5之后，SUN官方已经注意到了，调整了JVM，具体化了volatile关键字，因此，如果是JDK1.5以及以后，只需要将sInstance的定义改成

	private volatile static Singleton sInstance= null

* 就可以保证sInstance对象每次都是从主内存中读取，单例就不会失效。
### 2.解决反射和反序列化单例失效。
* 由于java能够通过反射以及反序列化构造一个对象，因此即使把构造函数私有化，DCL和静态内部类的单例模式都可能会失效。解决办法：
* DCL方式↓:**在构造函数中适当时候抛出异常；重写readResolve方法；**

---
	import java.io.ObjectStreamException;
	import java.io.Serializable;

	public class DCLSingleton implements Serializable {
		private static DCLSingleton sInstance = null;
	
		private DCLSingleton() {
			if (null != sInstance) {
				// 防止反射获取多个对象的漏洞
				throw new RuntimeException("请不要非法创建新对象");
			}
		}
	
		public static DCLSingleton getInstance() {
			if (sInstance == null) {
				synchronized (DCLSingleton.class) {
					if (sInstance == null) {
						return sInstance = new DCLSingleton();
					}
				}
			}
			return sInstance;
		}
	
		// 防止反序列化获取多个对象的漏洞。
		// 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
		// 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
		private Object readResolve() throws ObjectStreamException {
			return sInstance;
		}
	}

---
* 静态内部类↓：**在构造函数中适当时候抛出异常；重写readResolve方法；**

---
	import java.io.ObjectStreamException;
	import java.io.Serializable;

	public class InnerClassSingleton implements Serializable {
		// 防止反射获取多个对象的漏洞
		private InnerClassSingleton() {
			if (null != SingletonHolder.instance)
				throw new RuntimeException();
		}
	
		// 第一次调用这个getInstance方法的时候才会去加载SingletonHolder类。
		public static InnerClassSingleton getInstance() {
			return SingletonHolder.instance;
		}
	
		private static class SingletonHolder {
			private static final InnerClassSingleton instance = new InnerClassSingleton();
		}
	
		// 防止反序列化获取多个对象的漏洞
		private Object readResolve() throws ObjectStreamException {
			return SingletonHolder.instance;
		}
	}

---