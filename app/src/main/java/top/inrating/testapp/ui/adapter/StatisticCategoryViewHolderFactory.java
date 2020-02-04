package top.inrating.testapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import top.inrating.testapp.R;
import top.inrating.testapp.ui.category.Category;

public class StatisticCategoryViewHolderFactory {

    public static class StatisticViewHolder extends RecyclerView.ViewHolder {

        private Context context;

        StatisticViewHolder(Context context, @NonNull View itemView) {
            super(itemView);
            this.context = context;
        }

        public void setIcon(int icon) {
            ((ImageView) itemView.findViewById(R.id.category_icon)).setImageResource(icon);
        }

        public void setTitle(@StringRes int title, Object...objects) {
            ((TextView) itemView.findViewById(R.id.category_title))
                    .setText(context.getString(title, objects));
        }
    }

    public static class StatisticWithUsersViewHolder extends RecyclerView.ViewHolder {

        private Context context;

        StatisticWithUsersViewHolder(Context context, @NonNull View itemView) {
            super(itemView);
            this.context = context;
        }

        public void setIcon(int icon) {
            ((ImageView) itemView.findViewById(R.id.category_icon)).setImageResource(icon);
        }

        public void setTitle(@StringRes int title, Object...objects) {
            ((TextView) itemView.findViewById(R.id.category_title))
                    .setText(context.getString(title, objects));
        }

        public void setMoreLabel(int count) {
            ((TextView) itemView.findViewById(R.id.category_more_label))
                    .setText(context.getString(R.string.category_more_label, count));
        }

        public void setAdapter(RecyclerView.Adapter adapter) {
            RecyclerView recyclerView = itemView.findViewById(R.id.user_card_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(adapter);
        }

        public void setMoreLabelOnClick(View.OnClickListener clickListener) {
            itemView.findViewById(R.id.category_more_label)
                    .setOnClickListener(clickListener);
        }
    }

    static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == Category.STATISTIC_WITH_USERS) {
            return new StatisticWithUsersViewHolder(context,
                    LayoutInflater.from(context)
                            .inflate(R.layout.statistic_item_with_users_item, parent, false));
        } else {
            return new StatisticViewHolder(context,
                    LayoutInflater.from(context)
                            .inflate(R.layout.statistic_item, parent, false));
        }
    }
}
