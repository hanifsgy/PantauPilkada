package panawaapps.pantaupilkada.model.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 27/11/15.
 */
public class CoupleName {
    @SerializedName("couple")
    @Expose
    private Couple couple;

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }
}
