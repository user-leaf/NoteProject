### MaterialDesign.md
可以参考：[CoordinatorLayout的基本使用](https://www.jianshu.com/p/eec5a397ce79)  

用的时候翻翻[官方文档](https://developer.android.google.cn/reference/androidx/coordinatorlayout/widget/CoordinatorLayout)就好了。  

还能在布局文件中点进去看说明：
```xml
    <attr name="layout_collapseMode">
      <!-- The view will act as normal with no collapsing behavior. -->
      <enum name="none" value="0"/>
      <!-- The view will pin in place. -->
      <enum name="pin" value="1"/>
      <!-- The view will scroll in a parallax fashion. See the
           layout_collapseParallaxMultiplier attribute to change the multiplier. -->
      <enum name="parallax" value="2"/>
    </attr>
```

