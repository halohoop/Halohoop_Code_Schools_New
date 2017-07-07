# Halohoop_Code_Schools

## 模板方法安卓传感器常用指南针旋转角度转换方法，将-180至+180，转换为0-359
	//开发过类似方向传感器的童鞋都会了解，通常我们会在获取方向的时候的第一个浮点数数组的第一个值就是按Z轴旋转的夹角
	//而安卓传感器返回给我们的值是0表示北，±180表示南，+90表示东，-90表示西，
	//这些取值有时候很不适合我们后续的操作，因此我们做一个转换，将0表示北，90表示东，180表示南，270表示西；
	//以下方法就是起到转换的作用的，只需将orien[0]传进来即可；

	public static float normalizeDegree(float paramFloat) {
        return (720.0F + paramFloat) % 360.0F;
    }

## 打开应用市场指定搜索某个应用


	/**
	 * 使用隐式意图打开手机中原有应用市场
	 * 并且搜索传进来的包名对应的软件
	 *
	 */
	public static boolean openMarketAndSearchYST(Context context, String packageName) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("market://details?id=" + packageName);// 填入需要搜索的包名
            intent.setData(uri);
            intent.setPackage(packageName);// 填入应用市场的包名
            //intent.setPackage(packageName);// 可以指定应用市场的包名
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

## 获取当前手机环境的国家语言

			/*
			 * if current language equals the param；
			 * such as LangUtils.isCurrentLanguageEquals("ru")//equals Russian value-ru
			 */
			public static boolean isCurrentLanguageEquals(String langStr) {
					Locale l = Locale.getDefault();
					String language = l.getLanguage();
			//        String country = l.getCountry().toLowerCase();
					if (langStr != null && langStr.equalsIgnoreCase(language)) {
							return true;
					}
					return false;
			}

## Android源码中通话Dialer模块PhoneFavoriteListView类的获取当前view的截图

			private Bitmap createDraggedChildBitmap(View view) {
	        view.setDrawingCacheEnabled(true);
	        final Bitmap cache = view.getDrawingCache();

	        Bitmap bitmap = null;
	        if (cache != null) {
	            try {
	                bitmap = cache.copy(Bitmap.Config.ARGB_8888, false);
	            } catch (final OutOfMemoryError e) {
	                Log.w(LOG_TAG, "Failed to copy bitmap from Drawing cache", e);
	                bitmap = null;
	            }
	        }

	        view.destroyDrawingCache();
	        view.setDrawingCacheEnabled(false);

	        return bitmap;
	    }

## 根据百分比取得两个数之间的值
	
	/**
	 * Linear interpolate between a and b with parameter t.
	 * 根据t的百分比返回a到b之间值
	 */
	private static float lerp(float a, float b, @FloatRange(from = 0.0, to = 1.0)float t) {
	    return a + (b - a) * t;
	}

## 合并两个数组

	/**
	 * 两个数组合并
	 * @param arrayLhs
	 * @param arrayRhs
     * @return
     */
	private static Object combineArray(Object arrayLhs, Object arrayRhs) {
		Class<?> localClass = arrayLhs.getClass().getComponentType();
		int i = Array.getLength(arrayLhs);
		int j = i + Array.getLength(arrayRhs);
		Object result = Array.newInstance(localClass, j);
		for (int k = 0; k < j; ++k) {
			if (k < i) {
				Array.set(result, k, Array.get(arrayLhs, k));
			} else {
				Array.set(result, k, Array.get(arrayRhs, k - i));
			}
		}
		return result;
	}
	/*
	 * //	[12345] [9876]
	 * //最终变成	[9876  12345]
	*/