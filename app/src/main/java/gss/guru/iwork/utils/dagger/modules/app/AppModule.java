package gss.guru.iwork.utils.dagger.modules.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import java.util.logging.Handler;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gss.guru.iwork.MyApp;
import gss.guru.iwork.data.network.client.RetrofitClient;
import gss.guru.iwork.data.network.impl.NetworkRepository;
import gss.guru.iwork.data.network.impl.NetworkRepositoryImpl;
import gss.guru.iwork.data.preferenanse.UserPreferences;
import gss.guru.iwork.ui.main.MainPresenter;
import gss.guru.iwork.ui.main.MainPresenterView;
import gss.guru.iwork.utils.rx.RxBus;
import gss.guru.iwork.utils.rx.RxSchedulers;
import gss.guru.iwork.utils.rx.RxSchedulersAbs;

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
