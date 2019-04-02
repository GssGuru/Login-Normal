package gss.guru.loginnormal.ui.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import gss.guru.loginnormal.R;
import gss.guru.loginnormal.utils.dagger.modules.authorization.AuthorizationModule;
import gss.guru.loginnormal.utils.dagger.utils.Injectors;
import gss.guru.loginnormal.utils.utils.AuthValidate;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity implements LoginPresenterView.View {

    @Inject
    LoginPresenterView.Presenter presenter;

    @ViewById EditText et_email;
    @ViewById EditText et_password;

    @ViewById View login_progress;
    @ViewById View login_form;

    @ViewById TextInputLayout til_password;
    @ViewById TextInputLayout til_email;

    @Click({R.id.btn_login})
    void btn_login() {
        if (AuthValidate.isEmailPasswdValid(et_email.getText().toString(), et_password.getText().toString()))
            presenter.login(et_email.getText().toString(), et_password.getText().toString());
    }

    @Click({R.id.tv_registration})
    void tv_registration() {
//        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(Const.LITEBOX_URL)));
    }

    @Click({R.id.tv_start_demo})
    void tv_start_demo() {
        presenter.startDemo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injectors.get(this).plus(new AuthorizationModule()).inject(this);
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
        til_email.setError(error);
    }

    @Override
    public void failPasswd(String error) {
        til_password.setError(error);
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