# ArcImageView
<image src="https://github.com/Golabe/ArcView/blob/master/images/a.png?raw=true" width="400"/>
<image src="https://github.com/Golabe/ArcView/blob/master/images/b.png?raw=true" width="400"/>

## 使用
```xml
 <top.golabe.library.ArcImageView
        android:scaleType="centerCrop"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:src="@drawable/timg"
        app:arc_height="20dp"
        app:direction="in"
       />
```
```xml
 <declare-styleable name="ArcImageView">
        <!--弧形高度-->
        <attr name="arc_height" format="dimension" />
        <!--弧形开口方向-->
        <attr name="direction" format="enum">
            <!--向内-->
            <enum name="in" value="0x0001" />
            <!--向外-->
            <enum name="out" value="0x0002" />
        </attr>
    </declare-styleable>
```
