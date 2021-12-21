### Android进阶之光的学习笔记

#### 第2章
1. ViewPager的适配器主要处理了两件事：一件事是根据不同的position返回不同的Fragment；另一件事就是根据不同的position返回不同的title。
2. 用CoordinateLayout实现Toolbar隐藏和折叠这两种效果。

#### 第3章 View体系与自定义View
1、 View的滑动
   - layout()
   - offsetLeftAndRight()与offsetTopAndBottom() 
   - LayoutParams改变leftMargin和topMargin
   - 动画
   - scrollTo与scrollBy
   - Scroller
   
2、 属性动画
   - ObjectAnimator
   - ValueAnimator不提供任何动画效果，它更像是一个数值发生器，用来产生有一定规律的数字，从而让调用者控制动画的实现过程。
   - 动画监听 AnimatorListenerAdapter
   - 组合动画——AnimatorSet
   
