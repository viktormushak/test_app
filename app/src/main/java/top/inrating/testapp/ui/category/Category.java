package top.inrating.testapp.ui.category;

import androidx.recyclerview.widget.RecyclerView;

public interface Category {
    int STATISTIC = 0;
    int STATISTIC_WITH_USERS = 1;

    int getCategoryType();

    void onBindViewHolder(RecyclerView.ViewHolder holder);
}
