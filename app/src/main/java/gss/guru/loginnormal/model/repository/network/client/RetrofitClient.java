package gss.guru.loginnormal.model.repository.network.client;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import gss.guru.loginnormal.BuildConfig;
import gss.guru.loginnormal.MyApp;
import gss.guru.loginnormal.utils.dagger.utils.Injectors;

public class RetrofitClient {

    public static final String BASE_URL = "https://gss.guru/api";
    private static RetrofitClient instance;
    private ApiService apiService;

    public RetrofitClient() {
        Injectors.get(MyApp.getContext()).inject(this);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = buildApi(BASE_URL, ApiService.class);
        }
        return apiService;
    }

    private <T> T buildApi(String url, Class<T> aClass) {
        return getRetrofitBuilder(url, aClass)
                .client(getHttpClient(aClass)
                        .connectTimeout(20, TimeUnit.MINUTES)
                        .readTimeout(20, TimeUnit.MINUTES)
                        .writeTimeout(20, TimeUnit.MINUTES)
                        .build())
                .build()
                .create(aClass);
    }

    private <T> Retrofit.Builder getRetrofitBuilder(String url, Class<T> aClass) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(getHttpClient(aClass).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @NonNull
    private <T> OkHttpClient.Builder getHttpClient(Class<T> aClass) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.addInterceptor(chain -> {
            Request request = chain.request();
            request = request.newBuilder()
                    .addHeader("Accept", "application/json")
                    .build();
            return chain.proceed(request);
        });

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC).setLevel
                    (HttpLoggingInterceptor.Level.BODY).setLevel(HttpLoggingInterceptor.Level.HEADERS));
        }
        return okHttpBuilder;
    }
}