package gss.guru.loginnormal.ui.login;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import gss.guru.loginnormal.model.interactors.Interactor;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepository;
import gss.guru.loginnormal.utils.rx.RxSchedulers;

public class LoginPresenter implements LoginPresenterView.Presenter {

    private LoginPresenterView.View view;
    private final CompositeDisposable disposable;
    private Interactor.Login interactor;

    public LoginPresenter() {
        this.disposable = new CompositeDisposable();
    }

    public LoginPresenter(Interactor.Login interactor) {
        this.disposable = new CompositeDisposable();
        this.interactor = interactor;
    }

    @Override
    public void onViewCreated() {}

    @Override
    public void bindView(LoginPresenterView.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        disposable.clear();
        view = null;
    }

    @Override
    public void login(String email, String passwd) {
        view.showProgress();

        disposable.add(interactor.auth(email, passwd)
                .compose(new RxSchedulers().getIOToMainTransformer())
                .subscribe(
                        data -> {
                            if (data != null) {
                                view.startMain();
                            } else {
                                view.showContent();
                                view.failEmail(" ");
                                view.failPasswd(" ");
                            }
                        },
                        throwable -> {
                            Log.d("throwable", getClass().getName() + ".login ", throwable);
                            view.failEmail(" ");
                            view.failPasswd(" ");
                            view.showContent();
                        }));
    }

    @Override
    public void startDemo() {
        view.startMain();
    }
}