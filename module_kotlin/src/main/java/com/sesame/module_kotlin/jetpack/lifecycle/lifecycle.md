#### Lifecycle
Lifecycle完美解决了组件对页面生命周期的依赖问题，使组件能够自己管理其生命周期。

系统组件（Activity/Fragment、Service和Application），有生命周期。
普通组件（也就是非系统组件/自定义组件）无法主动获知系统组件的生命周期事件。
Lifecycle可以帮助创建可感知生命周期的组件。

具体实现：
1、页面实现LifecycleOwner接口（在新版本的SDK中，Activity已经默认实现了该接口）。
2、观察者实现LifecycleObserver接口（该接口没有接口方法，无须任何具体的实现）。
3、在被观察者页面中通过getLifecycle().addObserver(observer)使观察者与被观察者绑定即可。
另外，拥有生命周期概念的组件除了Activity和Fragment，还有Service和Application。
要监听Service的生命周期，Android提供了一个类叫LifecycleService。该类继承自Service，并实现了LifecycleOwner接口。
要监听应用程序的声明周期，Lifecycle提供了一个名为ProcessLifecycleOwner的类，以方便我们知道整个应用程序的生命周期情况。可用于想知道应用程序当前处在前台还是后台，或者当应用程序从后台回到前台时，我们能够得到通知。


``` java
public class KotlinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 可用于想知道应用程序当前处在前台还是后台，或者当应用程序从后台回到前台时，我们能够得到通知。
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }
}

```
#### 小结
所有具有生命周期的组件都能够使用Lifecycle。包括Activity、Fragment、Service和Application。Lifecycle组件存在的主要意义是帮助我们解耦，让自定义组件也能够感受到生命周期的变化。
