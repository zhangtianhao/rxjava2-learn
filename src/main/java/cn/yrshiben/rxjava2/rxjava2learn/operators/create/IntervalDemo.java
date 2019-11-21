package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 9:46 PM
 */
public class IntervalDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(4, 2, TimeUnit.SECONDS)
                .subscribe(l -> System.out.println(LocalDateTime.now() + " ### " + "onNext 执行，参数：" + l),
                        throwable -> System.out.println(LocalDateTime.now() + " ### " + throwable),
                        () -> System.out.println(LocalDateTime.now() + " ### " + "onComplete 执行。"),
                        disposable -> System.out.println(LocalDateTime.now() + " ### " + "onSubscribe 执行")
                );

        TimeUnit.SECONDS.sleep(10);
    }
}
