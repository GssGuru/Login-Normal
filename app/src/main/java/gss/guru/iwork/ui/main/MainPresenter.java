package gss.guru.iwork.ui.main;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import gss.guru.iwork.MyApp;
import gss.guru.iwork.data.network.impl.NetworkRepository;
import gss.guru.iwork.utils.dagger.utils.Injectors;
import gss.guru.iwork.utils.rx.RxSchedulers;

public class MainPresenter implements MainPresenterView.Presenter {

    @Inject
    NetworkRepository networkInteractor;


    private MainPresenterView.View view;
    private final CompositeDisposable disposable;

    public MainPresenter() {
        Injectors.get(MyApp.getContext()).inject(this);
        this.disposable = new CompositeDisposable();
    }



    @Override
    public void doSomeInMresenter() {

    }

    @Override
    public void onViewCreated() {
        disposable.add(
                networkInteractor.auth("test55@valeev.ru", "qweasd123")
                        .compose(new RxSchedulers().getIOToMainTransformer())
                        .subscribe(data -> {
                    view.setData(new Gson().toJson(data));
                }, throwable -> {
                    view.setError("error " + throwable.getMessage());
                }));

    }

    @Override
    public void bindView(MainPresenterView.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        disposable.clear();
        view = null;
    }
}
