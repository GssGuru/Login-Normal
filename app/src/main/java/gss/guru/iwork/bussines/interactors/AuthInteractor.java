package gss.guru.iwork.bussines.interactors;


import io.reactivex.Single;
import gss.guru.iwork.bussines.Interactor;
import gss.guru.iwork.data.network.impl.NetworkRepository;
import gss.guru.iwork.data.preferenanse.UserPreferences;
import gss.guru.iwork.utils.rx.RxSchedulersAbs;

public class AuthInteractor implements Interactor.Auth {

    private RxSchedulersAbs rxSchedulers;
    private NetworkRepository networkRepository;
    private UserPreferences pref;

    public AuthInteractor(UserPreferences pref, RxSchedulersAbs rxSchedulers, NetworkRepository networkRepository) {
        this.pref = pref;
        this.rxSchedulers = rxSchedulers;
        this.networkRepository = networkRepository;
    }

    @Override
    public Single<String> auth(String email, String passwd) {
        return null;
    }
}
