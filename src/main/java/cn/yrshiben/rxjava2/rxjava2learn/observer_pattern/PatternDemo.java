package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/25 10:08 AM
 */
public class PatternDemo {

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
}
