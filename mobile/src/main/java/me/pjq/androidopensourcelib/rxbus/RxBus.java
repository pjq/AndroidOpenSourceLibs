
package me.pjq.androidopensourcelib.rxbus;

import me.pjq.androidopensourcelib.bus.BusAction;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by i329817 on 4/26/16.
 */
public class RxBus {
    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return _bus;
    }

    public void sendBusAction() {
        send(new BusAction("RxBus Send Action"));
    }

    public void toOb() {
        // note that it is important to subscribe to the exact same _rxBus
        // instance that was used to post the events
        toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object event) {

                if (event instanceof BusAction) {
                    // _showTapText();
                }
            }
        });
    }
}
