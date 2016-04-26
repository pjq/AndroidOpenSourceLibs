
package me.pjq.androidopensourcelib;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.List;

import me.pjq.androidopensourcelib.retrofit.ApiService;
import me.pjq.androidopensourcelib.retrofit.Repo;
import me.pjq.androidopensourcelib.retrofit.RetrofitManager;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing
 * Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    RetrofitManager retrofitManager;

    ApiService apiService;

    public ApplicationTest() {
        super(Application.class);

        retrofitManager = RetrofitManager.getInstance();

        apiService = retrofitManager.getApiService();
    }

    public void testApi() {
        apiService.listRepos("pjq");
    }

    public void testApiObservable() {
        Observable<List<Repo>> repos = apiService.listReposObservable("pjq");

        repos.subscribeOn(Schedulers.io()).flatMap(new Func1<List<Repo>, Observable<?>>() {
            @Override
            public Observable<?> call(List<Repo> repos) {
                return null;
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Object>() {
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
