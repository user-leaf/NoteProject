### 属性动画
> 想起来，面试的时候，问过我一道题，记不大清了。就是改变字体颜色还是背景颜色来着，说因为没有那个直接设置属性的方法，问我怎么实现。
> 算作是复习吧，带着这个目标去回顾了一下。

1. 属性动画都是通过ValueAnimator 类和ObjectAnimator 类来完成，其中ObjectAnimator类是对对象做动画，ValueAnimator 类是对值做动画。
2. PropertyValueHolder类可以同时执行多个动画，AnimatorSetl类可以将多个动画按一定的秩序先后执行。
3. TypeEvaluator估值器和Interpolator 差值器

了解了下面6个类的基本用法，就基本彻底掌握了属性动画

- ObjectAnimator 对象动画
- ValueAnimator 值动画
- PropertyValueHolder 用于同时执行多个动画
- TypeEvaluator 估值器
- AnimatorSet 动画集合
- Interpolator 差值器

#### 一、ObjectAnimator与ValueAnimator

对象动画（ObjectAnimator）与值动画（ValueAnimator）：
值动画是通过控制值的变化，之后 手动赋值给对象的属性，从而实现动画。

```
 final ImageView imageView = findViewById(R.id.imageView);
 ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
 anim.setDuration(5000);
 anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
     @Override
     public void onAnimationUpdate(ValueAnimator animation) {
         float currentValue = (float) animation.getAnimatedValue();
         Log.d("MainActivity", "cuurent value is " + currentValue);
         imageView.setAlpha(currentValue);
     }
 });
 anim.start();
```

#### 二、理解插值器和估值器
**TimeInterpolator（时间插值器）的作用是根据时间流逝的百分比来计算出当前属性值改变的百分比。**系统预设的是LinearInterpolator(线性插值器，匀速动画)，AccelerateDecelerateInterpolator（加速减速插值器：两头慢中间快）和DecelerateInterpolator（减速插值器）。

**TypeEvaluator（类型估值算法），也叫估值器，它的作用是根据当前属性变化的百分比来计算变化后的属性值。**系统预设了针对整型属性IntEvaluator，浮点型FloatEvaluator，和color颜色值ArgbEvaluator。两者结合能实现非匀速动画。

#### 三、执行多个动画，用AnimatorSet

引用：
[1] https://blog.csdn.net/huweiliyi/article/details/105671079
[2] https://blog.csdn.net/weixin_38244174/article/details/93073950