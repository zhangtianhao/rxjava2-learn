package cn.yrshiben.rxjava2.rxjava2learn.observer_pattern2;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/25 3:38 PM
 */
public class ObservableCreate<T> implements Observable<T> {

    private ObservableSource<T> source;

    public ObservableCreate(ObservableSource<T> source) {
        this.source = source;
    }

    /**
     * 相当于 {@link io.reactivex.internal.operators.observable.ObservableCreate#subscribeActual} 方法
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer<T> observer) {
        CreateEmitter<T> emitter = new CreateEmitter<>(observer);
        source.registerObserver(emitter);
    }

    /**
     * 相当于 {@link io.reactivex.internal.operators.observable.ObservableCreate.CreateEmitter} 类
     *
     * @param <T>
     */
    static final class CreateEmitter<T> implements Emitter<T> {

        private Observer<T> observer;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void doSomethon(T t) {
            observer.respondBySomethin(t);
        }
    }
}
