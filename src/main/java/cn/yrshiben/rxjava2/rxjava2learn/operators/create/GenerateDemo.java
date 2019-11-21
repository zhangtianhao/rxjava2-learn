package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import java.util.concurrent.Callable;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 5:25 PM
 */
public class GenerateDemo {
    public static void main(String[] args) {
        Observable.generate((Consumer<Emitter<String>>) emitter -> {
            emitter.onNext("1");
            // emitter.onNext("2");
            // emitter.onNext("3");
            emitter.onComplete();
            emitter.onNext("4");
        }).subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("onComplete 执行。"),
                disposable -> System.out.println("onSubscribe 执行")
        );

        int startValue = 1;
        int incrementValue = 1;
        Flowable<Integer> flowable = Flowable.generate(() -> startValue, (s, emitter) -> {
            int nextValue = s + incrementValue;
            emitter.onNext(nextValue);
            return nextValue;
        });
        flowable.subscribe(value -> System.out.println(value));
        Flowable.generate(() -> "ok", (BiFunction<String, Emitter<String>, String>) (s, emitter) -> s);
    }
}
