package top.inrating.testapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

import top.inrating.testapp.R;
import top.inrating.testapp.data.repository.PostRepository;
import top.inrating.testapp.data.repository.StatisticRepository;
import top.inrating.testapp.data.repository.impl.PostRepositoryImpl;
import top.inrating.testapp.data.repository.impl.StatisticRepositoryImpl;
import top.inrating.testapp.ui.category.Category;
import top.inrating.testapp.ui.category.Statistic;
import top.inrating.testapp.ui.category.StatisticWithUsers;

@SuppressWarnings("WeakerAccess")
public class StatisticViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categoryList = new MutableLiveData<>();

    private PostRepository postRepository = new PostRepositoryImpl();
    private StatisticRepository statisticRepository = new StatisticRepositoryImpl();

    LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    void loadPostStatistic() {
        postRepository.getPostBySlug("LeBxOWT5zSemiSvkuqBLXFjXlaA0bJlX", post ->
                categoryList.setValue(Arrays.asList(
                        new Statistic(R.drawable.ic_views, R.string.views_category_title, post.getViewsCount()),
                        new StatisticWithUsers(R.drawable.ic_like, R.string.likes_category_title, post.getLikesCount()){
                            @Override
                            public void runUsersDataLoading() {
                                statisticRepository
                                        .getLikersByPostId(post.getId(), this::onUsersDataLoaded);
                            }
                        },
                        new StatisticWithUsers(R.drawable.ic_comment, R.string.commentators_category_title, post.getCommentsCount()){
                            @Override
                            public void runUsersDataLoading() {
                                statisticRepository
                                        .getCommentatorsByPostId(post.getId(), this::onUsersDataLoaded);
                            }
                        },
                        new StatisticWithUsers(R.drawable.ic_mention, R.string.mentions_category_title, 0){
                            @Override
                            public void runUsersDataLoading() {
                                statisticRepository
                                        .getMentionsByPostId(post.getId(), this::onUsersDataLoaded);
                            }
                        },
                        new StatisticWithUsers(R.drawable.ic_reposts, R.string.reposts_category_title, post.getRepostsCount()){
                            @Override
                            public void runUsersDataLoading() {
                                statisticRepository
                                        .getRepostsByPostId(post.getId(), this::onUsersDataLoaded);
                            }
                        },
                        new Statistic(R.drawable.ic_bookmark, R.string.bookmarks_category_title, post.getBookmarksCount()))),
                Throwable::printStackTrace);
    }
}
