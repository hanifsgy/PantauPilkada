package panawaapps.pantaupilkada.model.TPS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 24/11/15.
 */
public class Calon {
    @SerializedName("calon")
    @Expose
    public Calon_ calon;
    @SerializedName("wakil")
    @Expose
    public Wakil wakil;

    public Calon_ getCalon() {
        return calon;
    }

    public void setCalon(Calon_ calon) {
        this.calon = calon;
    }

    public Wakil getWakil() {
        return wakil;
    }

    public void setWakil(Wakil wakil) {
        this.wakil = wakil;
    }
}
