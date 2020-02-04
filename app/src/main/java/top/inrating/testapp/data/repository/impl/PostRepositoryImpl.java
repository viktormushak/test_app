package top.inrating.testapp.data.repository.impl;

import android.annotation.SuppressLint;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.inrating.testapp.BuildConfig;
import top.inrating.testapp.data.model.Post;
import top.inrating.testapp.data.net.InRatingApi;
import top.inrating.testapp.data.repository.PostRepository;

@SuppressWarnings("ResultOfMethodCallIgnored")
@SuppressLint("CheckResult")
public class PostRepositoryImpl implements PostRepository {

    private InRatingApi inRatingApi = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(InRatingApi.class);

    public void getPostBySlug(String slug, Consumer<Post> onSuccess, Consumer<Throwable> onError){
        inRatingApi.getPostBySlug(BuildConfig.TOKEN, slug)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError);
    }
}
