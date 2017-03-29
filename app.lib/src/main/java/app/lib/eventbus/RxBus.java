package app.lib.eventbus;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by huanglin on 2017/3/26.
 */

public class RxBus {

    private final Relay<Object> relayBus;

    private final FlowableProcessor<Object> flowableBus;

    private RxBus() {
        //need private constructor
        relayBus = PublishRelay.create().toSerialized();
        flowableBus = PublishProcessor.create().toSerialized();
    }

    public RxBus getInstance() {
        return RxBusHolder.instance;
    }

    public static class RxBusHolder {
        private static final RxBus instance = new RxBus();
    }

    public void post(Object event) {
        relayBus.accept(event);
        flowableBus.onNext(event);
    }

    public  <T>Observable<T> toObservable(Class<T> eventType) {
        return relayBus.ofType(eventType);
    }

    public  <T>Observable<T> toObservable(final int code, Class<T> eventType) {
        return relayBus.ofType(Msg.class)
                .filter(new Predicate<Msg>() {
                    @Override
                    public boolean test(Msg msg) throws Exception {
                        return msg.code == code;
                    }
                })
                .map(new Function<Msg, Object>() {
                    @Override
                    public Object apply(Msg msg) throws Exception {
                        return msg.object;
                    }
                })
                .cast(eventType);
    }

    public boolean hasObservers() {
        return relayBus.hasObservers();
    }

    public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext) {
        return toObservable(eventType).observeOn(scheduler).subscribe(onNext);
    }

    public <T> Disposable register(int code, Class<T> eventType, Scheduler scheduler, Consumer<T> onNext) {
        return toObservable(code, eventType).observeOn(scheduler).subscribe(onNext);
    }

    public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError) {
        return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError);
    }

    public <T> Disposable register(int code, Class<T> eventType, Consumer<T> onNext, Consumer onError) {
        return toObservable(code, eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError);
    }

    public void unregister(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }



}
