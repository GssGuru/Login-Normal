package gss.guru.loginnormal.data.network.impl;



import io.reactivex.Single;

public interface NetworkRepository {

    Single<String> auth(String email, String passwd);

}
