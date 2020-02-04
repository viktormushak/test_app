package top.inrating.testapp.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@SuppressWarnings("unchecked")
public class StatisticViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StatisticViewModel.class)){
            return (T) new StatisticViewModel();
        }

        throw new IllegalArgumentException("wrong ViewModel class");
    }
}
