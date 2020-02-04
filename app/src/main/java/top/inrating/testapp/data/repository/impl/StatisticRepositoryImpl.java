package top.inrating.testapp.data.repository.impl;

import android.annotation.SuppressLint;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.inrating.testapp.BuildConfig;
import top.inrating.testapp.data.model.UserData;
import top.inrating.testapp.data.net.InRatingApi;
import top.inrating.testapp.data.repository.StatisticRepository;

@SuppressWarnings("ResultOfMethodCallIgnored")
@SuppressLint("CheckResult")
public class StatisticRepositoryImpl implements StatisticRepository {

    private InRatingApi inRatingApi = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(InRatingApi.class);

    public void getLikersByPostId(int id, Consumer<List<UserData>> onSuccess) {
        inRatingApi.getLikersByPostId(BuildConfig.TOKEN, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userDataResponse ->
                        onSuccess.accept(userDataResponse.getData()), Throwable::printStackTrace);
    }

    public void getCommentatorsByPostId(int id, Consumer<List<UserData>> onSuccess) {
        inRatingApi.getCommentatorsByPostId(BuildConfig.TOKEN, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userDataResponse ->
                        onSuccess.accept(userDataResponse.getData()), Throwable::printStackTrace);
    }

    public void getMentionsByPostId(int id, Consumer<List<UserData>> onSuccess) {
        inRatingApi.getMentionsByPostId(BuildConfig.TOKEN, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userDataResponse ->
                        onSuccess.accept(userDataResponse.getData()), Throwable::printStackTrace);
    }

    public void getRepostsByPostId(int id, Consumer<List<UserData>> onSuccess) {
        inRatingApi.getRepostsByPostId(BuildConfig.TOKEN, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userDataResponse ->
                        onSuccess.accept(userDataResponse.getData()), Throwable::printStackTrace);
    }
}
