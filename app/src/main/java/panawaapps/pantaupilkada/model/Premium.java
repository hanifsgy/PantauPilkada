package panawaapps.pantaupilkada.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sikikan on 12/2/2015.
 */
public class Premium {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("premium")
    @Expose
    public Boolean premium;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }
}
