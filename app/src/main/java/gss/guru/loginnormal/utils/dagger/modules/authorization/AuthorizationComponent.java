package gss.guru.loginnormal.utils.dagger.modules.authorization;



import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import gss.guru.loginnormal.ui.login.LoginActivity;
import gss.guru.loginnormal.utils.dagger.utils.ActivityScope;


@Subcomponent(modules = {AuthorizationModule.class})
@ActivityScope
public interface AuthorizationComponent extends AndroidInjector<DaggerApplication>  {

    void inject(LoginActivity activity);
}
