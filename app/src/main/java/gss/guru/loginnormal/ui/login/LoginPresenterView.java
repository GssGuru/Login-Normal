package gss.guru.loginnormal.ui.login;


import gss.guru.loginnormal.ui.BaseView;

public interface LoginPresenterView {

    interface View extends BaseView.RootView {

        void failEmail(String error);
        void failPasswd(String error);
        void showProgress();
        void showContent();
        void startMain();
    }

    interface Presenter extends BaseView.Presenter<View> {

        void login(String email, String passwd);
        void startDemo();
        void onViewCreated();
    }

}
