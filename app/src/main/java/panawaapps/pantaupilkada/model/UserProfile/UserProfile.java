package panawaapps.pantaupilkada.model.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sikikan on 12/1/2015.
 */
public class UserProfile {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("data")
    @Expose
    public UserProfileData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserProfileData getData() {
        return data;
    }

    public void setData(UserProfileData data) {
        this.data = data;
    }
}
