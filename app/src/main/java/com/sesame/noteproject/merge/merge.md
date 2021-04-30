#### merge的使用

merge使用主要是的目的是在优化布局，减少布局嵌套，一般与include结合使用。

merge里面的控件的布局方式（垂直或者是水平）受制于容纳include的布局。在根节点中可以指明在哪个布局中显示。

```xml
<merge xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:showIn="@layout/activity_merge">

</merge>
```
