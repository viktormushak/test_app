package top.inrating.testapp.data.local;

import android.graphics.Bitmap;

import io.reactivex.functions.Consumer;

public interface ImageProvider {

    void loadImage(String url, Consumer<Bitmap> onImageLoaded);
}
