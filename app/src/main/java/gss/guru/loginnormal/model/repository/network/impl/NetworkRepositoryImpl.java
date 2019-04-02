package gss.guru.loginnormal.model.repository.network.impl;



import javax.inject.Inject;

import io.reactivex.Single;
import gss.guru.loginnormal.MyApp;
import gss.guru.loginnormal.model.repository.network.client.RetrofitClient;
import gss.guru.loginnormal.utils.dagger.utils.Injectors;

public class NetworkRepositoryImpl implements NetworkRepository {

    @Inject
    RetrofitClient restClient;

    public NetworkRepositoryImpl() {
        Injectors.get(MyApp.getContext()).inject(this);
    }

    @Override
    public Single<String> auth(String email, String passwd) {
        return restClient.getApiService().auth(email, passwd);
    }
}
