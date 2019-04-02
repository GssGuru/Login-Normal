package gss.guru.loginnormal.utils.dagger.modules.app;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gss.guru.loginnormal.MyApp;
import gss.guru.loginnormal.model.repository.network.client.RetrofitClient;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepository;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepositoryImpl;
import gss.guru.loginnormal.model.repository.preference.PreferenceRepositoryImpl;
import gss.guru.loginnormal.utils.rx.RxSchedulers;
import gss.guru.loginnormal.utils.rx.RxSchedulersImpl;

@Module
public class AppModule {

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
    public PreferenceRepositoryImpl provideSharedPrefsRepository() {
        return new PreferenceRepositoryImpl();
    }

    @Provides
    @Singleton
    public RxSchedulersImpl provideRxSchedlers() {
        return new RxSchedulers();
    }

}
