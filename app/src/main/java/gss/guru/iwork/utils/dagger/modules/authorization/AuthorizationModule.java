package gss.guru.iwork.utils.dagger.modules.authorization;

import dagger.Module;
import dagger.Provides;
import gss.guru.iwork.bussines.Interactor;
import gss.guru.iwork.bussines.interactors.AuthInteractor;
import gss.guru.iwork.data.network.impl.NetworkRepository;
import gss.guru.iwork.data.preferenanse.UserPreferences;
import gss.guru.iwork.ui.login.LoginPresenter;
import gss.guru.iwork.ui.login.LoginPresenterView;
import gss.guru.iwork.utils.rx.RxSchedulersAbs;

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
