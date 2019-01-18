package gss.guru.iwork.utils.dagger.modules.authorization;



import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import gss.guru.iwork.ui.login.LoginActivity;
import gss.guru.iwork.utils.dagger.utils.ActivityScope;


@Subcomponent(modules = {AuthorizationModule.class})
@ActivityScope
public interface AuthorizationComponent extends AndroidInjector<DaggerApplication>  {

    void inject(LoginActivity activity);
}
