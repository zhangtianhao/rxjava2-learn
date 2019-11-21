package cn.yrshiben.rxjava2.rxjava2learn.operators.error_management;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

import java.io.IOException;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/27 11:37 PM
 */
public class DoOnErrorDemo {
    public static void main(String[] args) {
        Observable.error(new IOException())
                .onExceptionResumeNext(new ObservableSource<String>() {
                    @Override
                    public void subscribe(Observer<? super String> observer) {
                        return;
                    }
                });
    }
}
