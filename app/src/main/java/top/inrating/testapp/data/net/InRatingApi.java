package top.inrating.testapp.data.net;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import top.inrating.testapp.data.model.Post;
import top.inrating.testapp.data.net.model.UserDataResponse;

public interface InRatingApi {

    @POST("/v1/users/posts/get")
    Observable<Post> getPostBySlug(@Header("Authorization") String token, @Query("slug") String slug);


    @POST("/v1/users/posts/likers/all")
    Observable<UserDataResponse> getLikersByPostId(@Header("Authorization") String token, @Query("id") int id);


    @POST("/v1/users/posts/commentators/all")
    Observable<UserDataResponse> getCommentatorsByPostId(@Header("Authorization") String token, @Query("id") int id);


    @POST("/v1/users/posts/mentions/all")
    Observable<UserDataResponse> getMentionsByPostId(@Header("Authorization") String token, @Query("id") int id);


    @POST("/v1/users/posts/reposters/all")
    Observable<UserDataResponse> getRepostsByPostId(@Header("Authorization") String token, @Query("id") int id);
}
