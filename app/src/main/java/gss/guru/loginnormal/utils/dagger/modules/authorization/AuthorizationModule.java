package gss.guru.loginnormal.utils.dagger.modules.authorization;

import dagger.Module;
import dagger.Provides;
import gss.guru.loginnormal.bussines.Interactor;
import gss.guru.loginnormal.bussines.interactors.AuthInteractor;
import gss.guru.loginnormal.data.network.impl.NetworkRepository;
import gss.guru.loginnormal.data.preferenanse.UserPreferences;
import gss.guru.loginnormal.ui.login.LoginPresenter;
import gss.guru.loginnormal.ui.login.LoginPresenterView;
import gss.guru.loginnormal.utils.rx.RxSchedulersAbs;

@Module
public class AuthorizationModule {

    @Provides
    LoginPresenterView.Presenter provideRegistrationViewPresenter(Interactor.Auth interactor) {
        return new LoginPresenter(interactor);
    }

    @Provides
    Interactor.Auth provideRegistrationViewInteractor(NetworkRepository networkRepository, UserPreferences prefsRepository, RxSchedulersAbs rxSchedulers) {
        return new AuthInteractor(prefsRepository, rxSchedulers, networkRepository);
    }

}
