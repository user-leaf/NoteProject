### FlexboxLayout常用属性

灵活运用这些属性的搭配可以达到非常灵活的效果

---

##### 1、FlexboxLayout直接属性
```xml
<com.google.android.flexbox.FlexboxLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        app:flexDirection="row"
        app:flexWrap="wrap"
        app:justifyContent="flex_start">
    <!--
        设置了换行（flexWrap=“wrap或wrap_reverse”）
        
    -->
</com.google.android.flexbox.FlexboxLayout>
```
##### 2、FlexboxLayout子元素属性
