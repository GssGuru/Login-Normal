package gss.guru.iwork.utils.dagger.modules.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import gss.guru.iwork.MyApp;
import gss.guru.iwork.data.network.client.RetrofitClient;
import gss.guru.iwork.data.network.impl.NetworkRepositoryImpl;
import gss.guru.iwork.ui.main.MainPresenter;
import gss.guru.iwork.utils.dagger.modules.authorization.AuthorizationComponent;
import gss.guru.iwork.utils.dagger.modules.authorization.AuthorizationModule;


@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication>  {

//    void inject(LoginActivity loginActivity);


    void inject(MainPresenter mainPresenter);



    void inject(RetrofitClient retrofitClient);
    void inject(NetworkRepositoryImpl network);


    void inject(MyApp app);


    AuthorizationComponent plus(AuthorizationModule module);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        @BindsInstance
        Builder appModule(AppModule appModule);
        AppComponent build();
    }
}
