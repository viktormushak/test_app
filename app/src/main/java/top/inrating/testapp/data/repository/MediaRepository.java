package top.inrating.testapp.data.repository;

import android.graphics.Bitmap;

import io.reactivex.functions.Consumer;

public interface MediaRepository {

    void getImageFileByName(String name, Consumer<Bitmap> onImageLoaded);
}
