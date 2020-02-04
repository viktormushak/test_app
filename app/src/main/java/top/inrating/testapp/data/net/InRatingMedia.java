package top.inrating.testapp.data.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InRatingMedia {

    @GET("/img/{name}")
    Call<ResponseBody> getImageByName(@Path("name") String name);
}
