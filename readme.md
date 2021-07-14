#### my pure music app
https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
跟着学一下



1. 折叠悬浮效果
CoordinatorLayout{
    // 用来实现折叠ActionBar
    AppBarLayout(自带behavior，可省略不写){ // AppBarLayout是个LinearLayout
        // 可以是其它控件，不必非得是这个CollapsingToolbarLayout
        // 用来实现折叠布局
        CollapsingToolbarLayout(设置scrollFlags = [scroll|enterAlwaysCollapsed...]){ 
            控件1(设置collapseMode = [off|pin|parallax]，折叠效果){
            }
            
            控件2(设置collapseMode){
            }
            
            ...
        }
        
        TabLayout(不设置scrollFlags，就不会折叠){ // 上面的折叠后，只剩TabLayout悬停
        }
    }
    
    RecyclerView(要设置behavior){
    }
}



#### 学习感悟
1. 研究一下pure music，遇到不会的就查查百度