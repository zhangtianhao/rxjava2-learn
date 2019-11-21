package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/25 10:08 AM
 */
public class PatternDemo2 {

    public static void main(String[] args) {
        // 定义被观察者
        ObservableCreate<String> observable = new ObservableCreate<>(new ObservableSource<String>() {
            @Override
            public void registerObserver(Emitter<String> emitter) {
                emitter.doSomethon("吃饭");
                emitter.doSomethon("睡觉");
                emitter.doSomethon("敲代码");
            }
        });

        // 定义观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void respondBySomethin(String s) {
                System.out.println(s + ":" + s);
            }
        };

        // 被观察者将观察者注册进来
        observable.registerObserver(observer);
    }
}
