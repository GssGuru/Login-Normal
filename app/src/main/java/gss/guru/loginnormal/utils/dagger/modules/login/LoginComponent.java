package gss.guru.loginnormal.utils.dagger.modules.login;



import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import gss.guru.loginnormal.ui.login.LoginActivity;
import gss.guru.loginnormal.utils.dagger.utils.ActivityScope;


@Subcomponent(modules = {LoginModule.class})
@ActivityScope
public interface LoginComponent extends AndroidInjector<DaggerApplication>  {

    void inject(LoginActivity activity);
}
