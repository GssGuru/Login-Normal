package gss.guru.loginnormal.model.repository.network.impl;



import io.reactivex.Single;

public interface NetworkRepository {

    Single<String> auth(String email, String passwd);

}
