package top.inrating.testapp.ui.category;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.inrating.testapp.data.model.UserData;
import top.inrating.testapp.ui.adapter.StatisticCategoryViewHolderFactory.StatisticWithUsersViewHolder;
import top.inrating.testapp.ui.adapter.UserCardAdapter;

public class StatisticWithUsers implements Category {

    @StringRes
    private int titleStringResId;
    @DrawableRes
    private int iconResId;
    private int count;
    private List<UserData> userDataList;
    private StatisticWithUsersViewHolder viewHolder;

    protected StatisticWithUsers(int iconResId, int titleStringResId, int count) {
        this.iconResId = iconResId;
        this.titleStringResId = titleStringResId;
        this.count = count;
    }

    public int getCategoryType() {
        return Category.STATISTIC_WITH_USERS;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        this.viewHolder = (StatisticWithUsersViewHolder) holder;
        this.viewHolder.setIcon(iconResId);
        this.viewHolder.setTitle(titleStringResId, count);
        runUsersDataLoading();
    }

    protected void onUsersDataLoaded(List<UserData> userDataList){
        this.userDataList = userDataList;
        if (userDataList.size() > 4){
            this.viewHolder.setMoreLabel(userDataList.size() - 4);
            this.viewHolder.setMoreLabelOnClick(view -> {
                showAllUsers();
                view.setVisibility(View.INVISIBLE);
            });
            this.viewHolder.setAdapter(new UserCardAdapter(this.userDataList.subList(0, 4)));
        } else {
            this.viewHolder.setAdapter(new UserCardAdapter(this.userDataList));
        }
    }

    private void showAllUsers(){
        this.viewHolder.setAdapter(new UserCardAdapter(this.userDataList));
    }

    public void runUsersDataLoading(){

    }
}
