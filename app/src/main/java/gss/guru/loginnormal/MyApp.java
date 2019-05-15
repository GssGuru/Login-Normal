package gss.guru.loginnormal;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import gss.guru.loginnormal.utils.dagger.modules.app.AppComponent;
import gss.guru.loginnormal.utils.dagger.modules.app.AppModule;
import gss.guru.loginnormal.utils.dagger.modules.app.DaggerAppComponent;


public class MyApp extends DaggerApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(new AppModule())
                .build();
        appComponent.inject(this);
        return appComponent;
    }
}
