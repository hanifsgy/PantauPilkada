package panawaapps.pantaupilkada.model.TPS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 24/11/15.
 */
public class TPS {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("data")
    @Expose
    public List<Datum> data = new ArrayList<Datum>();
    @SerializedName("total")
    @Expose
    public Integer total;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

