package panawaapps.pantaupilkada.model;

import java.util.List;

/**
 * Created by ali on 20/11/15.
 */
public class District {
    private String status;
    private List<DistrictData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DistrictData> getData() {
        return data;
    }

    public void setData(List<DistrictData> data) {
        this.data = data;
    }
}
