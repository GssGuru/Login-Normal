package gss.guru.loginnormal.model.interactors;

import io.reactivex.Single;

public interface Interactor {

    interface Login {

        Single<String> auth(String email, String passwd);
    }

}
