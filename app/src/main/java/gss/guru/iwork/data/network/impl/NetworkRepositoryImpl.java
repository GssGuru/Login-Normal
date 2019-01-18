package gss.guru.iwork.data.network.impl;



import javax.inject.Inject;

import io.reactivex.Single;
import gss.guru.iwork.MyApp;
import gss.guru.iwork.data.network.client.RetrofitClient;
import gss.guru.iwork.utils.dagger.utils.Injectors;

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
