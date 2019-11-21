package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern;

/**
 * @author zhangbin
 * @Description: 做为被观察者
 * @date create at 2019/10/25 9:55 AM
 */
public class PeopleObservable implements Observable<String> {

    /*
     * 被观察者内部维护的观察者
     */
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
