package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

/**
 * @author zhangbin
 * @Description: 用来包装一个观察者 Observer
 * @date create at 2019/10/25 3:34 PM
 */
public interface Emitter<T> {

    /**
     * 相当于 {@link io.reactivex.Emitter#onNext(Object)} 方法
     *
     * @param t
     */
    void doSomethon(T t);
}
