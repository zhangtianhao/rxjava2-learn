package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

/**
 * @author zhangbin
 * @Description: 观察者
 * @date create at 2019/10/25 9:51 AM
 */
public interface Observer<T> {

    /**
     * 【被观察者】通知时触发的方法
     * 相当于 {@link io.reactivex.Observer#onNext(Object)} 方法
     *
     * @param t
     */
    void respondBySomethin(T t);


}
