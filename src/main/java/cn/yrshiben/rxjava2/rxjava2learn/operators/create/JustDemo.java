package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/26 5:34 PM
 */
public class JustDemo {

    public static void main(String[] args) {
        /**
         * 这种用法跟 Observable.fromArray(1, 2, 3, 4, 5) 差不多了
         */
        Observable.just(1, 2, 3, 4, 5)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );

        System.out.println("--------------------");

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.just(list)
                .subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("onComplete 执行。"),
                        disposable -> System.out.println("onSubscribe 执行")
                );
    }
}
