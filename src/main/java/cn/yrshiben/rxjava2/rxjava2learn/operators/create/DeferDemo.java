package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 9:16 PM
 */
public class DeferDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return Observable.just(LocalDateTime.now().toString());
            }
        });
        // 直到有观察者订阅它，它才会为每个观察者创建一个全新的 Observable
        observable.subscribe(time -> System.out.println(time));
        TimeUnit.SECONDS.sleep(1);
        // 又会创建一个全新的 Observable
        observable.subscribe(time -> System.out.println(time));
    }
}
