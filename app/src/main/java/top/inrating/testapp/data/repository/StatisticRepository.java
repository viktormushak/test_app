package top.inrating.testapp.data.repository;

import java.util.List;

import io.reactivex.functions.Consumer;
import top.inrating.testapp.data.model.UserData;

public interface StatisticRepository {

    void getLikersByPostId(int id, Consumer<List<UserData>> onSuccess);

    void getCommentatorsByPostId(int id, Consumer<List<UserData>> onSuccess);

    void getMentionsByPostId(int id, Consumer<List<UserData>> onSuccess);

    void getRepostsByPostId(int id, Consumer<List<UserData>> onSuccess);
}
