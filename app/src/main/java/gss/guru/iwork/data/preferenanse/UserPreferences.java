package gss.guru.iwork.data.preferenanse;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;


import javax.inject.Inject;


import gss.guru.iwork.MyApp;
import gss.guru.iwork.data.network.response.Auth;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences {

    private static final String SHARED_PREFERENCES_NAME = "t-9947.xml";
    private static final String TOKEN = "t-1432";
    private static final String USER = "t-1982";
    private static final String CREATED = "t-2562";

    private final SharedPreferences mPrefs;
    private final Context mContext;

    @Inject
    public UserPreferences(Context context) {
        mPrefs = MyApp.getContext().getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
//        mPrefs = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        mContext = context;
    }


    public boolean isPrefExist(String key){
        return mPrefs.contains(key);
    }

    public void saveAuth(Auth auth){
        mPrefs.edit()
                .putString(TOKEN, auth.getKey())
                .putInt(USER, auth.getUser())
                .putString(CREATED, auth.getCreated())
//                .putBoolean(DEMO_MODE, false)
                .apply();
    }

    public boolean isAuth(){
        return mPrefs.getString(TOKEN, null) != null && mPrefs.getInt(USER, 0) != 0 && mPrefs.getString(CREATED, null) != null ;
    }

    public String getToken(){
        return mPrefs.getString(TOKEN, null);
    }


}
