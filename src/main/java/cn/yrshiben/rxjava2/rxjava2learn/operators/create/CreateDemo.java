package cn.yrshiben.rxjava2.rxjava2learn.operators.create;

import io.reactivex.*;

/**
 * @author zhangbin
 * @Description: create 操作符
 * @date create at 2019/10/18 12:55 PM
 */
public class CreateDemo {

    public static void main(String[] args) {
        // fun1();
        // fun2();
        // fun3();
        // fun4();
        // fun5();
        // fun6();
        // fun7();
        fun8();
    }

    public static void fun1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
                emitter.onComplete();  // 调用多次也不会报错，但是跟调用一次效果一样
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onNext(8);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("执行完成");
        }, disposable -> {
            System.out.println("已订阅，开始接收数据。");
        });
    }

    public static void fun2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onError(new RuntimeException("这里发生异常"));
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onNext(8);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("执行完成");
        }, disposable -> {
            System.out.println("已订阅，开始接收数据。");
        });
    }

    public static void fun3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onError(new RuntimeException("这里发生异常"));
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onNext(8);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("执行完成");
        }, disposable -> {
            System.out.println("已订阅，开始接收数据。");
        });
    }

    public static void fun4() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new RuntimeException("这里发生异常"));
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onNext(8);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("执行完成");
        }, disposable -> {
            System.out.println("已订阅，开始接收数据。");
        });
    }

    public static void fun5() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onNext(4);
                    emitter.onComplete();
                }
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("执行完成");
        }, disposable -> {
            System.out.println("已订阅，开始接收数据。");
            // disposable.dispose();
        });
    }

    public static void fun6() {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                emitter.onSuccess(123);
                emitter.onSuccess(456); // 发射多次也只能收到一次的。
                emitter.onSuccess(789);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }

    public static void fun7() {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                emitter.onSuccess(123);
                emitter.onError(new RuntimeException("这里发生异常"));
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }

    public static void fun8() {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                emitter.onError(new RuntimeException("这里发生异常"));
                emitter.onSuccess(123);
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }
}
