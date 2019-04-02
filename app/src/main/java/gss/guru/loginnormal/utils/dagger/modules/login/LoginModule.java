package gss.guru.loginnormal.utils.dagger.modules.login;

import dagger.Module;
import dagger.Provides;
import gss.guru.loginnormal.model.interactors.Interactor;
import gss.guru.loginnormal.model.interactors.LoginInteractor;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepository;
import gss.guru.loginnormal.model.repository.preference.PreferenceRepositoryImpl;
import gss.guru.loginnormal.ui.login.LoginPresenter;
import gss.guru.loginnormal.ui.login.LoginPresenterView;
import gss.guru.loginnormal.utils.rx.RxSchedulersImpl;

@Module
public class LoginModule {

    @Provides
    LoginPresenterView.Presenter provideRegistrationViewPresenter(Interactor.Login interactor) {
        return new LoginPresenter(interactor);
    }

    @Provides
    Interactor.Login provideRegistrationViewInteractor(NetworkRepository networkRepository, PreferenceRepositoryImpl prefsRepository, RxSchedulersImpl rxSchedulers) {
        return new LoginInteractor(prefsRepository, rxSchedulers, networkRepository);
    }

}
