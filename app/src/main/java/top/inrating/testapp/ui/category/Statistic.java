package top.inrating.testapp.ui.category;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import top.inrating.testapp.ui.adapter.StatisticCategoryViewHolderFactory.StatisticViewHolder;

public class Statistic implements Category {

    @StringRes
    private int titleStringResId;
    @DrawableRes
    private int iconResId;
    private int count;

    public Statistic(int iconResId, int titleStringResId, int count) {
        this.iconResId = iconResId;
        this.titleStringResId = titleStringResId;
        this.count = count;
    }

    public int getCategoryType() {
        return Category.STATISTIC;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        StatisticViewHolder viewHolder = (StatisticViewHolder) holder;
        viewHolder.setIcon(iconResId);
        viewHolder.setTitle(titleStringResId, count);
    }
}
