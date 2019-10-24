package cn.yrshiben.rxjava2.rxjava2learn.operators;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/18 12:56 PM
 */
public class HelloWorld {

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello world");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        System.out.println("======================");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello world");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("完成");
            }
        });

        System.out.println("======================");
        Observable.just("hello world")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });

        System.out.println("======================");
        Observable.just("hello world")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("完成");
                    }
                });

        System.out.println("======================");
        Observable
                .create((ObservableOnSubscribe<List<Integer>>) emitter -> {
                    ArrayList<Integer> list = new ArrayList<>();
                    System.out.println("&&&&&&&&000");
                    list.add(1);
                    System.out.println("&&&&&&&&111");
                    list.add(2);
                    System.out.println("&&&&&&&&222");
                    list.add(3);
                    System.out.println("&&&&&&&&333");
                    list.add(4);
                    System.out.println("&&&&&&&&444");
                    list.add(5);
                    System.out.println("&&&&&&&&555");
                    list.add(6);
                    System.out.println("&&&&&&&&666");
                    list.add(7);
                    System.out.println("&&&&&&&&777");
                    emitter.onNext(list);
                })
                .flatMap(list -> Observable.fromIterable(list))
                .flatMap(i -> {
                    System.out.println(i);
                    return Observable
                            .just(i)
                            .map(integer -> {
                                System.out.println(integer + "A");
                                return integer + 1;
                            })
                            .takeWhile(integer -> integer < 5);
                })
                .subscribe(integer -> System.out.println(integer));

        System.out.println("======================");
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5);
        just.all(i -> i < 6).subscribe(i -> System.out.println(i));
        List<Integer> list = new ArrayList<>();
        just.takeWhile(i -> i < 3).subscribe(i -> list.add(i));
        System.out.println(list);

        List<BigDecimal> bigDecimals = new ArrayList<>();
        BigDecimal value = bigDecimals.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        System.out.println(value);

    }
}
