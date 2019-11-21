package cn.yrshiben.rxjava2.rxjava2learn.operators.create;


import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/26 5:34 PM
 */
public class JustDemo {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
    }
}
