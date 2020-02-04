package top.inrating.testapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int id;
    @SerializedName("views_count")
    private int viewsCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("reposts_count")
    private int repostsCount;
    @SerializedName("bookmarks_count")
    private int bookmarksCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(int bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }
}
