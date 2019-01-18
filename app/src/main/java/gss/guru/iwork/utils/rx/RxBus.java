package gss.guru.iwork.utils.rx;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {

    private PublishSubject<Object> bus = PublishSubject.create();

    public RxBus() {
    }

    public void post(Object o) {
        bus.onNext(o);
    }

    public Disposable subscribe(SubscribeEvent event) {
        return bus.subscribe(o -> {
            if (event.isInstance(o))
                event.onEvent(o);
        });
    }

    public Disposable subscribe(List<SubscribeEvent> events) {
        return bus.subscribe(o -> {
            for (SubscribeEvent event : events) {
                if (event.isInstance(o)) {
                    event.onEvent(o);
                    return;
                }
            }
        });
    }

    public static class SubscribeEvent<T> {
        @NonNull
        Class type;
        @NonNull
        OnEvent<T> listener;

        public SubscribeEvent(@NonNull Class type, @NonNull OnEvent<T> listener) {
            this.type = type;
            this.listener = listener;
        }

        public void onEvent(T event) {
            listener.onEvent(event);
        }

        public boolean isInstance(Object o) {
            return type.isInstance(o);
        }

        public interface OnEvent<T> {
            void onEvent(T event);
        }
    }
}
