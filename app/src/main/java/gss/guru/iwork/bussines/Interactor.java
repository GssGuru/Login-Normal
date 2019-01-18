package gss.guru.iwork.bussines;

import io.reactivex.Single;

public interface Interactor {

    interface Auth {

        Single<String> auth(String email, String passwd);
    }

}
