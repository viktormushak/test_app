package top.inrating.testapp.data.local.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

import io.reactivex.functions.Consumer;
import top.inrating.testapp.data.local.ImageProvider;
import top.inrating.testapp.data.repository.MediaRepository;
import top.inrating.testapp.data.repository.impl.MediaRepositoryImpl;

public class ImageProviderImpl implements ImageProvider {

    private File cacheDir;
    private MediaRepository mediaRepository;


    public ImageProviderImpl(Context context) {
        this.cacheDir = context.getCacheDir();
        this.mediaRepository = new MediaRepositoryImpl(context);
    }

    @SuppressLint("StaticFieldLeak")
    public void loadImage(String url, Consumer<Bitmap> onImageLoaded) {
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        File imageFile = new File(cacheDir, fileName);
        if (imageFile.exists()){
            try {
                onImageLoaded.accept(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mediaRepository.getImageFileByName(fileName, onImageLoaded);
        }
    }
}
