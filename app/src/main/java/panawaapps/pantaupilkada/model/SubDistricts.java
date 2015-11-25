package panawaapps.pantaupilkada.model;

import java.util.List;

/**
 * Created by ali on 21/11/15.
 */
public class SubDistricts {
    private String status;
    private List<SubDistrictData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SubDistrictData> getData() {
        return data;
    }

    public void setData(List<SubDistrictData> data) {
        this.data = data;
    }
}
