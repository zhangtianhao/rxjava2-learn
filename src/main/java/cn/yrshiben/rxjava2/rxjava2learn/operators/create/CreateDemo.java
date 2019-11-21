package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author zhangbin
 * @Description: create 操作符
 * @date create at 2019/10/18 12:55 PM
 */
public class CreateDemo {

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onNext(4);
                    emitter.onComplete();
                    emitter.onNext(5);
                    // 如果 emitter 已经被 Disposed，就不调用 observer.onError(t)，如果没被 Disposed，就会调用 observer.onError(t)
                    emitter.onError(new RuntimeException("this is onError"));
                    emitter.onNext(6);
                    // 如果 emitter 已经被 Disposed，此时调用没反应，如果没被 Disposed，就会调用 observer.onError(t)
                    emitter.tryOnError(new RuntimeException("this is tryOnError"));
                    emitter.onNext(7);
                }
            }
        }).subscribe(integer -> System.out.println(integer),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("已完成")
        );
    }
}
