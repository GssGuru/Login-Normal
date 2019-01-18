package gss.guru.iwork.data.network.impl;



import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkRepository {

    Single<String> auth(String email, String passwd);

}
