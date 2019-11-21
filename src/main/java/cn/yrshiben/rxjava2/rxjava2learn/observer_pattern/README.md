> 由观察者模式入手,由浅入深理解 RxJava2 的响应式设计。

- 被观察者(Observable),也可以说是生产者。
- 观察者(Observer)，也可以说是消费者。
> 如何去理解观察者模式，首先要知道这里面有两个重要的角色，那就是 **`观察者`** 和 **`被观察者`**。
>   > **`被观察者`**: 行为发起的地方，这种行为会触发 **`观察者`** 做出某种反应。  
>
>   > **`观察者`**: 会对 **`被观察者`** 的某种行为做出反应。

**根据上面描述的模型我们可以写出如下的代码**
- 首先定义一个 **`被观察者`** 的接口 **`Observable<T>`**
- 这个 **`被观察者`** 能够发起某种行为 **`doSomethin(T t)`**
- 定义一个 **`观察者`** 的接口 **`Observer<T>`**
- 这个 **`观察者`** 会对 **`被观察者`** 的行为做出反应 **`respondBySomethin(T t)`**

对应代码如下：
```java
/**
 * 被观察者
 */
public interface Observable<T> {

    /**
     * 被观察自己要做的事
     *
     * @param t
     */
    void doSomethin(T t);
}

/**
 * 观察者
 */
public interface Observer<T> {

    /**
     * 对【被观察者】的行为做出反应
     *
     * @param t
     */
    void respondBySomethin(T t);
}
```
我们拿个生活中具体的示例往上面的模型里套。  
假设家里有个智能窗帘，它关注人的两个行为起床和睡觉，当人起床时，窗帘就自动打开，当人睡觉时，窗帘就自动关闭。这就是个观察者与被观察者的示例。  
- 被观察者：人
- 被观察者做的某些事：起床、睡觉
- 观察者：窗帘
- 观察者对被观察者做的某些事的反应：当人起床时打开窗帘，人睡觉时关闭窗帘

对应代码如下：
```java
/**
 * 人
 */
public class PeopleObservable implements Observable<String> {

    /**
     * 做某些事，如：起床，睡觉 等
     *
     * @param s
     */
    @Override
    public void doSomethin(String s) {
        
    }
}

/**
 * 窗帘，作为观察者关注人的动作，对人的动作做出反应。
 */
public class CurtainObserver implements Observer<String> {

    /**
     * 对人的某些行为做出反应
     *
     * @param s
     */
    @Override
    public void respondBySomethin(String s) {
        if ("起床".equals(s)) {
            System.out.println("打开窗帘");
        }
        if ("睡觉".equals(s)) {
            System.out.println("关闭窗帘");
        }
    }
}
```


根据上面的描述和代码，**`被观察者`** 和 **`观察者`** 都建立起来了，但是如何让窗帘对人的行为做出反应呢，那就是人主动通知窗帘做出反应，也就是 **`被观察者`** 主动通知 **`观察者`**，因此 **`被观察者`** 里需要维护一个 **`观察者`** 的引用，这样 **`被观察者`** 就能通知 **`观察者`** 了。
- **`被观察者`** 里提供一个维护 **`观察者`** 的方法 **`registerObserver(Observer<T> observer)`**

**`Observable`** 改造后的代码如下：
```java
/**
 * 被观察者
 */
public interface Observable<T> {

    /**
     * 被观察自己要做的事
     *
     * @param t
     */
    void doSomethin(T t);
    
    /**
     * 注册【观察者】到【被观察者】内部，以便对【观察者】进行通知
     *
     * @param observer
     */
    void registerObserver(Observer<T> observer);    
}
```
具体的观察者改造如下：
```java
/**
 * 人
 */
public class PeopleObservable implements Observable<String> {
    // 被观察者内部维护的观察者
    private Observer<String> observer;
    /**
     * 做某些事，如：起床，睡觉 等
     *
     * @param s
     */
    @Override
    public void doSomethin(String s) {
        // 通知观察者
        observer.respondBySomethin(s);
    }
    
    /**
     * 维护一个【观察者】
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer<String> observer) {
        this.observer = observer;
    }
}
```
至此，一个简单的观察者模型就建立好了，下面通过一个 `main` 方法来验证下。
```
    public static void main(String[] args) {
        // 定义被观察者【人】
        Observable observable = new PeopleObservable();
        // 定义观察者【窗帘】
        Observer observer = new CurtainObserver();
        // 被观察者将观察者注册进来
        observable.registerObserver(observer);

        // 人 开始做事情
        observable.doSomethin("起床");
        observable.doSomethin("睡觉");
        observable.doSomethin("睡觉");
        observable.doSomethin("吃饭");
    }
```
最终打印结果如下
```
打开窗帘
关闭窗帘
关闭窗帘
```
通过上面的梳理我们可以总结成如下一张图片  
![简单观察者模式图.png](http://ww1.sinaimg.cn/large/8c9b2ef7gy1g8ahd1znehj20i608cq4a.jpg)
