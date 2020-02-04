package top.inrating.testapp.data.repository.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import top.inrating.testapp.BuildConfig;
import top.inrating.testapp.data.net.InRatingMedia;
import top.inrating.testapp.data.repository.MediaRepository;

public class MediaRepositoryImpl implements MediaRepository {

    private InRatingMedia inRatingMedia = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_MEDIA)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InRatingMedia.class);

    private Context context;

    public MediaRepositoryImpl(Context context) {
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void getImageFileByName(String name, Consumer<Bitmap> onImageLoaded) {
        new AsyncTask<Void, Void, File>(){

            @Override
            protected File doInBackground(Void... voids) {
                try {
                    Response<ResponseBody> response = inRatingMedia.getImageByName(name).execute();
                    ResponseBody responseBody = response.body();
                    if (responseBody != null){
                        File file = new File(context.getCacheDir(), name);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(responseBody.bytes());
                        return file;
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(File file) {
                try {
                    onImageLoaded.accept(BitmapFactory.decodeFile(file.getAbsolutePath()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute();

    }
}
