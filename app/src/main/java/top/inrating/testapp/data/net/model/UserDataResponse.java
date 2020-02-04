package top.inrating.testapp.data.net.model;

import java.util.List;

import top.inrating.testapp.data.model.UserData;

public class UserDataResponse {

    private List<UserData> data;

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }
}
