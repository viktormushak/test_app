package top.inrating.testapp.data.repository;

import io.reactivex.functions.Consumer;
import top.inrating.testapp.data.model.Post;

public interface PostRepository {

    void getPostBySlug(String slug, Consumer<Post> onSuccess, Consumer<Throwable> onError);

}
