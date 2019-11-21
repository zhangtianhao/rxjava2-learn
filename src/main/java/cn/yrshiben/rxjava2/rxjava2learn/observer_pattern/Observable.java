package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern;

/**
 * @author zhangbin
 * @Description: 被观察者
 * @date create at 2019/10/25 9:47 AM
 */
public interface Observable<T> {

    /**
     * 被观察自己要做的事，能通知观察者
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
