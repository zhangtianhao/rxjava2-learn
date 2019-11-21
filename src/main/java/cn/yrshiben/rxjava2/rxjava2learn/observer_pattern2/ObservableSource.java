package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

import io.reactivex.ObservableEmitter;

/**
 * @author zhangbin
 * @Description: 被 Observerable 包装
 * @date create at 2019/10/25 3:33 PM
 */
public interface ObservableSource<T> {

    /**
     * 相当于 {@link io.reactivex.ObservableOnSubscribe#subscribe(ObservableEmitter)} 方法
     *
     * @param emitter 相当于 {@link io.reactivex.Emitter} 类
     */
    void registerObserver(Emitter<T> emitter);
}
