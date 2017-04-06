# Android-ProGuard混淆以及代码优化

* 由于Java字节码的特殊性，使得它非常容易被反编译，因此，为了能够对编译好的JavaClass文件进行保护，通常会使用ProGuard来对Apk进行混淆处理，用无意义的字母来重命名类、字段、方法和属性。还可以删除无用的类、字段、方法和属性，以及删除没用的注释，最大限度的优化字节码文件。

* 在Android Studio中，可以非常方便地使用ProGuard，在Gradle Scripts文件夹下，打开build.gradle(Module: app)文件，显示如下：

---
	buildTypes {
	    release {
	        minifyEnabled false
	        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
	    }
	}

---


* minifyEnabled属性就是控制是否启用ProGuard的开关。设置为true表示开启。
* proguardFiles属性用于配置混淆文件，它分为两个部分：
	1. 系统默认的混淆文件，位于<SDK目录>/tools/proguard/proguard-android.txt目录下，大部分情况下使用这个就可以了。
	2. 项目中自定义的混淆文件，可以在项目的App文件夹下找到这个文件，在这个文件里可以定义引入的第三方依赖包的混淆规则。



