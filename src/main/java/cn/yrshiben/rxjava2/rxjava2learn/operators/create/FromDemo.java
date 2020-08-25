package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 4:30 PM
 */
public class FromDemo {

    public static void main(String[] args) {
        // fromArray
        Observable.fromArray(1, 2, 3, 4, 5)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
        System.out.println("--------------------");
        // fromArray
        List<Integer> list0 = new ArrayList();
        list0.add(1);
        list0.add(2);
        list0.add(3);
        list0.add(4);
        Observable.fromArray(list0)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
        System.out.println("--------------------");

        // fromIterable
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.fromIterable(list)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
        System.out.println("--------------------");
        // fromFuture
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(LocalDateTime.now() + " ### " + "模拟一些很耗时的任务...");
                TimeUnit.SECONDS.sleep(5);
                return "OK";
            }
        });
        Observable.fromFuture(future, 4, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(LocalDateTime.now() + " ### " + "onNext 执行，参数：" + s),
                        throwable -> System.out.println(LocalDateTime.now() + " ### " + throwable),
                        () -> System.out.println(LocalDateTime.now() + " ### " + "onComplete 执行。"),
                        disposable -> System.out.println(LocalDateTime.now() + " ### " + "onSubscribe 执行")
                );
        System.out.println("--------------------");
    }
}
