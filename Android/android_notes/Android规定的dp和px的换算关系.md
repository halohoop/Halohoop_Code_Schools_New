# Android规定的dp和px的换算关系

根据谷歌Android规定，（a）160dpi的屏幕，就是每英寸有160个像素的屏幕上，1dp=1px（a）；
那么（b）在320dpi的屏幕上，1dp=2px（b）;
同理，在480dpi的屏幕，就是1dp=3px；
相同的dp值，可以让我们在不同密度的手机中的显示比例保持一致；

几种标准的固定的dpi；

### 密度ldpi：
##### 密度值：120
##### 分辨率：240*320
##
### 密度mdpi：
##### 密度值：160
##### 分辨率：320*480
##
### 密度hdpi：
##### 密度值：240
##### 分辨率：480*800
##
### 密度xhdpi：
##### 密度值：320
##### 分辨率：720*1280
##
### 密度xxhdpi：
##### 密度值：480
##### 分辨率：1080*1920

## 那么实际上我们就能够得到换算的比例了
### ldpi:mdpi:hdpi:xhdpi:xxhdpi = 3:4:6:8:12