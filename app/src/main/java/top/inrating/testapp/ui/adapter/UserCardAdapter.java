package top.inrating.testapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.inrating.testapp.R;
import top.inrating.testapp.data.local.impl.ImageProviderImpl;
import top.inrating.testapp.data.model.UserData;

public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.UserCardViewHolder> {

    private List<UserData> userDataList;

    public UserCardAdapter(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    @NonNull
    @Override
    public UserCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserCardViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserCardViewHolder holder, int position) {
        holder.bind(userDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    class UserCardViewHolder extends RecyclerView.ViewHolder {

        UserCardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(UserData userData) {
            ((TextView) itemView.findViewById(R.id.user_card_name)).setText(userData.getNickname());
            ImageProviderImpl imageProviderImpl = new ImageProviderImpl(itemView.getContext());
            imageProviderImpl.loadImage(
                    userData.getAvatarImage().getUrl(), ((ImageView) itemView.findViewById(R.id.user_card_img))::setImageBitmap);
        }
    }
}
