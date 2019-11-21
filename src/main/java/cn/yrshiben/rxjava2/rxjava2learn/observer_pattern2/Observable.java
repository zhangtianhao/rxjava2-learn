package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

/**
 * @author zhangbin
 * @Description: 被观察者
 * @date create at 2019/10/25 9:47 AM
 */
public interface Observable<T> {

    /**
     * 注册【观察者】到【被观察者】内部，以便对【观察者】进行通知
     * 相当于 {@link io.reactivex.Observable#subscribe(io.reactivex.Observer)} 这个方法
     *
     * @param observer
     */
    void registerObserver(Observer<T> observer);
}
