package gss.guru.loginnormal.utils.dagger.modules.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import gss.guru.loginnormal.MyApp;
import gss.guru.loginnormal.model.repository.network.client.RetrofitClient;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepositoryImpl;
import gss.guru.loginnormal.utils.dagger.modules.login.LoginComponent;
import gss.guru.loginnormal.utils.dagger.modules.login.LoginModule;


@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication>  {

//    void inject(LoginActivity loginActivity);
//    void inject(MainPresenter mainPresenter);

    void inject(RetrofitClient retrofitClient);
    void inject(NetworkRepositoryImpl network);
    void inject(MyApp app);

    LoginComponent plus(LoginModule module);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        @BindsInstance
        Builder appModule(AppModule appModule);
        AppComponent build();
    }
}
