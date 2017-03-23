# Android属性动画的若干种常用属性

### 我们都知道属性动画ObjectAnimator可以传入一个字符串参数作为属性名称来改变View的属性，其中有几个是安卓定义好的属性字符串值，这里总结出来。

* translationX 和 translationY
> 这两个属性作为一种增量来控制着View对象从它布局容器的左上角坐标偏移的位置。

* rotaion、rotaionX 和 rotaionY
> 这三个属性控制View对象围绕支点进行2D和3D旋转。

* scaleX 和 scaleY  
> 这两个属性控制着View对象围绕它的支点进行2D缩放。

* pivotX 和 pivotY  
> 这两个属性控制着View对象的支点位置，围绕这个支点进行旋转和缩放处理。默认情况下，该支点的位置就是View对象的中心点。

* x 和 y  
> 这是两个简单实用的属性，它描述了View对象在它的容器中的最终位置，它是最初的左上角坐标和tanslationX、tanslationY值的累计和。

* alpha
> 它表示View对象的alpha透明度。默认值是1（不透明），0代表完全透明（不可见）。