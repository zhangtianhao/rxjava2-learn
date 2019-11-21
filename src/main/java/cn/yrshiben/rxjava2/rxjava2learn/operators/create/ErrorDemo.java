package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 10:52 PM
 */
public class ErrorDemo {
    public static void main(String[] args) {
        Observable.error(new RuntimeException("抛异常"))
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
    }
}
