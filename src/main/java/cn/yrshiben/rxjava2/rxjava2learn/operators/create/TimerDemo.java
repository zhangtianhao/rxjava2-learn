package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Description: timer 操作符示例
 * @date create at 2019/10/25 9:16 PM
 */
public class TimerDemo {

    public static void main(String[] args) {
        Observable.timer(3, TimeUnit.SECONDS, Schedulers.single())
                .subscribe(s -> System.out.println(Thread.currentThread().getName() + "##" + LocalDateTime.now() + "##onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println(Thread.currentThread().getName() + "##" + LocalDateTime.now() + "##onComplete 执行。"),
                        disposable -> System.out.println(Thread.currentThread().getName() + "##" + LocalDateTime.now() + "##onSubscribe 执行")
                );

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
