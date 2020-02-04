package top.inrating.testapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import top.inrating.testapp.R;
import top.inrating.testapp.ui.adapter.StatisticCategoryAdapter;

public class StatisticActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        setSupportActionBar(findViewById(R.id.toolbar));

        RecyclerView recyclerView = findViewById(R.id.category_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StatisticViewModel statisticViewModel =
                new ViewModelProvider(this, new StatisticViewModelFactory())
                        .get(StatisticViewModel.class);

        statisticViewModel.getCategoryList().observe(this, categories ->
                recyclerView.setAdapter(new StatisticCategoryAdapter(categories)));

        statisticViewModel.loadPostStatistic();
    }

}
