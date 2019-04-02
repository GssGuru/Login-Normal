package gss.guru.loginnormal.model.interactors;


import gss.guru.loginnormal.model.repository.preference.PreferenceRepository;
import gss.guru.loginnormal.model.repository.preference.PreferenceRepositoryImpl;
import io.reactivex.Single;
import gss.guru.loginnormal.model.repository.network.impl.NetworkRepository;

import gss.guru.loginnormal.utils.rx.RxSchedulersImpl;

public class LoginInteractor implements Interactor.Login {

    private RxSchedulersImpl rxSchedulers;
    private NetworkRepository networkRepository;
    private PreferenceRepository pref;

    public LoginInteractor(PreferenceRepositoryImpl pref, RxSchedulersImpl rxSchedulers, NetworkRepository networkRepository) {
        this.pref = pref;
        this.rxSchedulers = rxSchedulers;
        this.networkRepository = networkRepository;
    }

    @Override
    public Single<String> auth(String email, String passwd) {
        return null;
    }
}
