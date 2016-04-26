package me.pjq.androidopensourcelib.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by i329817 on 4/26/16.
 */
public interface ApiService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listReposObservable(@Path("user") String user);

}
