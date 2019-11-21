package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 10:07 PM
 */
public class IntervalRangeDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable.intervalRange(5, 4, 3, 2, TimeUnit.SECONDS)
                .subscribe(l -> System.out.println(LocalDateTime.now() + " ### " + "onNext 执行，参数：" + l),
                        throwable -> System.out.println(LocalDateTime.now() + " ### " + throwable),
                        () -> System.out.println(LocalDateTime.now() + " ### " + "onComplete 执行。"),
                        disposable -> System.out.println(LocalDateTime.now() + " ### " + "onSubscribe 执行")
                );

        TimeUnit.SECONDS.sleep(15);
    }
}
