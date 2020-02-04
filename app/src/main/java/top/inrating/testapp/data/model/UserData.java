package top.inrating.testapp.data.model;

import com.google.gson.annotations.SerializedName;

public class UserData {

    private String nickname;
    @SerializedName("avatar_image")
    private AvatarImage avatarImage;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    public static class AvatarImage {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
