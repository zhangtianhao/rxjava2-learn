package cn.yrshiben.rxjava2.rxjava2learn.operators;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/18 12:56 PM
 */
public class HelloWorld {

    public static void main(String[] args) {
        // RxJava2 的使用分为三步
        // 1、创建 Observable
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello world");
                emitter.onComplete();
            }
        });
        // 2、创建 Observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe 执行");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext 执行，参数：" + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete 执行。");
            }
        };
        // 3、使用 subscribe 进行订阅
        observable.subscribe(observer);

        // 三步合并在一起,下面这些代码等同于上面的代码
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("hello world");
            emitter.onComplete();
        }).subscribe(s -> System.out.println("onNext 执行，参数：" + s),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("onComplete 执行。"),
                disposable -> System.out.println("onSubscribe 执行")
        );
    }
}
