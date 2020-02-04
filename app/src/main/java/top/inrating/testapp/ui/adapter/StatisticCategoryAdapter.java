package top.inrating.testapp.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.inrating.testapp.ui.category.Category;

public class StatisticCategoryAdapter extends RecyclerView.Adapter {

    private List<Category> categories;

    public StatisticCategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int getItemViewType(int position) {
        return categories.get(position).getCategoryType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StatisticCategoryViewHolderFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        categories.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
