package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 9:35 PM
 */
public class RangeDemo {
    public static void main(String[] args) {
        Observable.range(2, 3)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );

        Observable.rangeLong(2, 3)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
    }
}
