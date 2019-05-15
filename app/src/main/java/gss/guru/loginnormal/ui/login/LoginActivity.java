package gss.guru.loginnormal.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import gss.guru.loginnormal.R;
import gss.guru.loginnormal.utils.dagger.modules.login.LoginModule;
import gss.guru.loginnormal.utils.dagger.utils.Injectors;
import gss.guru.loginnormal.ui.utils.AuthValidate;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity implements LoginPresenterView.View {

    @Inject
    LoginPresenterView.Presenter presenter;

    @ViewById EditText email;
    @ViewById EditText password;

    @ViewById View login_progress;
    @ViewById View login_form;

    @Click({R.id.email_sign_in_button})
    void login() {
        if (AuthValidate.isEmailPasswdValid(email.getText().toString(), password.getText().toString()))
            presenter.login(email.getText().toString(), password.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injectors.get(this).plus(new LoginModule()).inject(this);
        presenter.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbindView();
    }

    @AfterViews
    void bindViews() {
        presenter.onViewCreated();
    }

    @Override
    public void failEmail(String error) {
        email.setError(error);
    }

    @Override
    public void failPasswd(String error) {
        password.setError(error);
    }

    @Override
    public void showProgress() {
        login_progress.setAlpha(1f);
        login_form.setAlpha(0f);
    }

    @Override
    public void showContent() {
        login_progress.setAlpha(0f);
        login_form.setAlpha(1f);
    }

    @Override
    public void startMain() {
//        startActivity(new Intent(this, MainActivity_.class));
        finish();
    }
}