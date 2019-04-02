package gss.guru.loginnormal.utils.dagger.modules.app;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gss.guru.loginnormal.MyApp;
import gss.guru.loginnormal.data.network.client.RetrofitClient;
import gss.guru.loginnormal.data.network.impl.NetworkRepository;
import gss.guru.loginnormal.data.network.impl.NetworkRepositoryImpl;
import gss.guru.loginnormal.data.preferenanse.UserPreferences;
import gss.guru.loginnormal.ui.main.MainPresenter;
import gss.guru.loginnormal.ui.main.MainPresenterView;
import gss.guru.loginnormal.utils.rx.RxBus;
import gss.guru.loginnormal.utils.rx.RxSchedulers;
import gss.guru.loginnormal.utils.rx.RxSchedulersAbs;

@Module
public class AppModule {

    private Context mContext;

    @Provides
    public Context provideContext(MyApp application) {
        mContext = application.getApplicationContext();
        return mContext;
    }

    @Provides
    public Resources provideResources() {
        return mContext.getResources();
    }

    @Provides
    @Singleton
    public RxBus provideRxBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    public RetrofitClient provideRetrofitClient() {
        return RetrofitClient.getInstance();
    }

    @Provides
    @Singleton
    public NetworkRepository provideNetworkInteractor() {
        return new NetworkRepositoryImpl();
    }

    @Provides
    @Singleton
    public UserPreferences provideSharedPrefsRepository() {
        return new UserPreferences(mContext);
    }

    @Provides
    @Singleton
    public RxSchedulersAbs provideRxSchedlers() {
        return new RxSchedulers();
    }

    @Provides
    @Singleton
    MainPresenterView.Presenter providePresenterMain() {
        return new MainPresenter();
    }

}
