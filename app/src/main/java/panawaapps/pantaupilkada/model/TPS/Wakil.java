package panawaapps.pantaupilkada.model.TPS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 24/11/15.
 */
public class Wakil {
    @SerializedName("couple_id")
    @Expose
    public String coupleId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("avatar")
    @Expose
    public String avatar;

    public String getCoupleId() {
        return coupleId;
    }

    public void setCoupleId(String coupleId) {
        this.coupleId = coupleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
