
package me.pjq.androidopensourcelib.retrofit;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by i329817 on 4/26/16.
 */
public class RetrofitManager {
    private static RetrofitManager ourInstance = new RetrofitManager();

    private ApiService apiService;

    private Retrofit retrofit;

    public static RetrofitManager getInstance() {
        return ourInstance;
    }

    private RetrofitManager() {
        retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .client(new OkHttpClient()).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void testApi() {
        Call<List<Repo>> repos = apiService.listRepos("octocat");
    }

    public void testCreate() {
        rx.Observable.create(new rx.Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                boolean result = true;

                subscriber.onNext(result);

                if (!result) {
                    subscriber.onError(new Throwable("result error"));
                }

                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }
}
